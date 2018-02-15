/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import interfaces.IGestaoFicheirosComentarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Comentario;

/**
 * Classe responsavel por criar uma excecao do tipo GestaoFicheiroComentarios
 * @author Fábio Rêgo
 */
public class GestaoFicheiroComentarios<T> extends ObjectOutputStream implements IGestaoFicheirosComentarios {

    public GestaoFicheiroComentarios(OutputStream out) throws IOException {
        super(out);
    }

    private final String NOME_FICHEIRO = "comentarios.txt";

    public GestaoFicheiroComentarios() throws IOException {
    }

    /**
     * Escreve em ficheiro os dados de registo de um novo comentario.
     *
     * @param newComentario
     *
     *
     */
    @Override
    public boolean escreverFicheiroComentario(Comentario newComentario) {
        ObjectOutputStream in = null;
        try {
            File file = new File(NOME_FICHEIRO);
            if (file.exists()) {
                in = new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO, true));
                in.writeObject(newComentario);

            } else {
                in = new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO));
                in.writeObject(newComentario);
            }
            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestaoFicheiroComentarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestaoFicheiroComentarios.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }

    /**
     * Ler do ficheiro os dados de um novo comentario
     * @return 
     */
    @Override
    public DoubleLinkedUnorderedList<Comentario> lerFicheiroComentario() {

        DoubleLinkedUnorderedList<Comentario> comentariosList = new DoubleLinkedUnorderedList<>();
        try {

            FileInputStream fis = new FileInputStream(NOME_FICHEIRO);

            while (fis.available() > 0) {

                try {
                    ObjectInputStream obje = new ObjectInputStream(fis);
                    Object sd = obje.readObject();
                    comentariosList.addToRear((Comentario) sd);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GestaoFicheiroComentarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestaoFicheiroComentarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestaoFicheiroComentarios.class.getName()).log(Level.SEVERE, null, ex);

        }
        return comentariosList;
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        super.writeStreamHeader(); //To change body of generated methods, choose Tools | Templates.

        reset();
    }

}
