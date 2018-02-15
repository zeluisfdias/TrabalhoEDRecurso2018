/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import backend.existingValues;
import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import interfaces.IGestaoFicheirosUtilizadores;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Utilizador;

/**
 * Classe responsavel por criar uma excecao do tipo GestaoFicheiroUtilizadores
 * @author ZeLuis
 * @param <T>
 */
public class GestaoFicheiroUtilizadores<T> extends ObjectOutputStream implements IGestaoFicheirosUtilizadores {

    public GestaoFicheiroUtilizadores(OutputStream out) throws IOException {
        super(out);
    }

    private final String NOME_FICHEIRO = "utilizadores.txt";

    public GestaoFicheiroUtilizadores() throws IOException {
    }

    /**
     * Escreve em ficheiro os dados de registo do utilizador.
     *
     * @param newUser
     * @param usersTemp
     * @return 
     *
     *
     */
     @Override
    public boolean escreverFicheiro(Utilizador newUser, DoubleLinkedUnorderedList<Utilizador> usersTemp) {
        ObjectOutputStream in = null;
        try {
            File file = new File(NOME_FICHEIRO);
            if (file.exists()) {

                existingValues exValues = new existingValues(usersTemp);
                boolean isExisting = exValues.existUserWithCredentilials(newUser);

                if (!isExisting) {
                    in = new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO, true));
                    in.writeObject(newUser);
                    in.close();
                    return true;
                } else {

                    return false;
                }

            } else {
                in = new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO));
                in.writeObject(newUser);
                in.close();
                return true;
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Ficheiro não encontrado. \n Foi lancada a seguinte excepcao: " + ex.getMessage());
            return false;
        } catch (IOException ex) {
            return false;

        }

    }

    /**
     * Ler do ficheiro os dados de uu novo utilizador
     * @return 
     */
    @Override
    public   DoubleLinkedUnorderedList<Utilizador> lerFicheiro() {

        DoubleLinkedUnorderedList<Utilizador> usersList = new DoubleLinkedUnorderedList<>();
        try {

            FileInputStream fis = new FileInputStream(NOME_FICHEIRO);

            while (fis.available() > 0) {

                try {
                    ObjectInputStream obje = new ObjectInputStream(fis);
                    Object sd = obje.readObject();
                    usersList.addToRear((Utilizador) sd);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GestaoFicheiroUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestaoFicheiroUtilizadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestaoFicheiroUtilizadores.class.getName()).log(Level.SEVERE, null, ex);

        }
        return usersList;
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        super.writeStreamHeader(); //To change body of generated methods, choose Tools | Templates.

        reset();
    }

}
