/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import estruturas_lineares.LinkedList;
import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.swing.table.TableColumn;

/**
 *
 * @author ZeLuis
 */
public class Comentario implements Serializable{
   
    /**
     * Atributo responsavel por atribuir uma descricao ao comentariio
     */
    private String descricao;
    /**
     * Atributo responvel por atribuir um utilizador que envia o comentario
     */
    private Utilizador utilizadorSender;
    
    private GregorianCalendar date;
    

    /**
     * Metodo Construtor da Classe Comentario
     * @param descricao
     * @param utilizadorSender 
     */
    public Comentario(String descricao, Utilizador utilizadorSender) {
        this.descricao = descricao;
        this.utilizadorSender = utilizadorSender;
    }

    public Comentario(String descricao, Utilizador utilizadorSender, GregorianCalendar date) {
        this.descricao = descricao;
        this.utilizadorSender = utilizadorSender;
        this.date = date;
    }


  
    /**
     * Metodos GET e SET da Classe Comentario
     * @return 
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Utilizador getUtilizadorSender() {
        return utilizadorSender;
    }

    public void setUtilizadorSender(Utilizador utilizadorSender) {
        this.utilizadorSender = utilizadorSender;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comentario{" + "descricao=" + descricao + ", utilizadorSender=" + utilizadorSender + ", date=" + date + '}';
    }

    
   
}
