/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import interfaces.IGestaoFicheirosMensagens;
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
import models.Mensagem;

/**
 * Classe responsavel por criar uma excecao do tipo GestaoFicheiroMensagens
 *
 * @author Fábio Rêgo
 * @param <T>
 */
public class GestaoFicheiroMensagens<T> extends ObjectOutputStream implements IGestaoFicheirosMensagens {

    public GestaoFicheiroMensagens(OutputStream out) throws IOException {
        super(out);
    }

    private final String NOME_FICHEIRO = "mensagens.txt";

    public GestaoFicheiroMensagens() throws IOException {
    }

    /**
     * Escreve em ficheiro os dados de registo de uma nova mensagem.
     *
     * @param newMensagem
     * @return
     *
     *
     */
    @Override
    public boolean escreverFicheiroMensagem(Mensagem newMensagem) {

        ObjectOutputStream in = null;
        try {
            File file = new File(NOME_FICHEIRO);
            if (file.exists()) {
                in = new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO, true));
                in.writeObject(newMensagem);
                in.close();
                return true;

            } else {
                in = new ObjectOutputStream(new FileOutputStream(NOME_FICHEIRO));
                in.writeObject(newMensagem);
                in.close();
                return true;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestaoFicheiroMensagens.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestaoFicheiroMensagens.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;

    }

    /**
     * Ler do ficheiro os dados de uma nova mensagem.
     *
     * @return
     */
    @Override
    public DoubleLinkedUnorderedList<Mensagem> lerFicheiroMensagem() {

        DoubleLinkedUnorderedList<Mensagem> mensagensList = new DoubleLinkedUnorderedList<>();
        try {

            FileInputStream fis = new FileInputStream(NOME_FICHEIRO);

            while (fis.available() > 0) {

                try {
                    ObjectInputStream obje = new ObjectInputStream(fis);
                    Object sd = obje.readObject();
                    mensagensList.addToRear((Mensagem) sd);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GestaoFicheiroMensagens.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestaoFicheiroMensagens.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestaoFicheiroMensagens.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mensagensList;
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        super.writeStreamHeader(); //To change body of generated methods, choose Tools | Templates.

        reset();
    }

}
