/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import estruturas_lineares.LinkedList;
import estruturas_lineares.LinkedListStack;
import estruturas_lineares.LinkedStack;
import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * Classe para modelar uma mensagem
 *
 * @author ZeLuis
 */
public class Mensagem implements Serializable {

    /**
     * Atributo que identifica unicamente um utilizador
     */
    // private int id;
    /**
     * Atributo que guarda o conteudo de uma mensagem
     */
    private String conteudo;
    /**
     * Atributo que identifica o utilizador que escreveu a mensagem
     */
    private Utilizador user;
    /**
     * Atributo que indica se a mensagem é privada ou publica
     */
    private boolean priv;
    
    /**
     * Atributo que indica a data da mensagem
     */
    private GregorianCalendar date;
    
    // Lista desordenada ou ordenada de 
//   LinkedListStack<Mensagem> mensagens = new LinkedListStack<>();
//     private final LinkedList<Comentario> comentarios = new LinkedList<>();

    private DoubleLinkedUnorderedList<Comentario> comentariosMens = new DoubleLinkedUnorderedList<>();

    public Mensagem(String conteudo, Utilizador user, boolean priv) {

        this.conteudo = conteudo;
        this.user = user;
        this.priv = priv;
    }

    public Mensagem(String conteudo, Utilizador user, boolean priv, GregorianCalendar date) {
        this.conteudo = conteudo;
        this.user = user;
        this.priv = priv;
        this.date = date;
    }

    
    /**
     * Metodo responsavel por obter o counteudo de uma mensagem por parte de
     * utilizador
     *
     * @return
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Metodo responsavel por dar um novo counteudo a mensagem, por exemplo,
     * numa edicao.
     *
     * @param conteudo
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Metodo responsavel por obter o utilizador que escreveu a mensagem.
     *
     * @return
     */
    public Utilizador getUser() {
        return user;
    }

    /**
     * Metodo responsavel por associar um utilizador a uma mensagem.
     *
     * @param user
     */
    public void setUser(Utilizador user) {
        this.user = user;
    }

    /**
     * Metodo responsavel por verificar se a mensagem é privada
     *
     * @return
     */
    public boolean isPriv() {
        return priv;
    }

    /**
     * Metodo responsavel por definir a privacidade de uma mensagem
     *
     * @param priv
     */
    public void setPriv(boolean priv) {
        this.priv = priv;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    
    public void ComentarMensagem(Comentario comentario) {
        this.comentariosMens.addToFront(comentario);
    }

    public void getComentariosMensagem() {

        Iterator it = comentariosMens.iterator();
        System.out.println("Comentários:");
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }

    @Override
    public String toString() {
        return "Mensagem{" + "conteudo=" + conteudo + ", user=" + user + ", priv=" + priv + ", date=" + date + ", comentariosMens=" + comentariosMens + '}';
    }

    

}
