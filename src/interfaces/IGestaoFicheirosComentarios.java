/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import models.Comentario;

/**
 * Interface responsavel por definir os metodos para a Interface IGestaoFicheirosComentarios
 * @author Fábio Rêgo
 */
public interface IGestaoFicheirosComentarios {
    
    /**
     * Metodo responsavel por escrever um novo comentario para um ficheiro
     * @param newComentario
     * @return 
     */
    public boolean escreverFicheiroComentario(Comentario newComentario);
    
    /**
     * Metodo responsavel por ler um comentario de um dado ficheiro
     * @return 
     */
    public DoubleLinkedUnorderedList<Comentario> lerFicheiroComentario();
    
}
