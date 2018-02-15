/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import models.Mensagem;

/**
 * Interface responsavel por definir os metodos para a Interface IGestaoFicheirosMensagens
 * @author Fábio Rêgo
 */
public interface IGestaoFicheirosMensagens {
     
    /**
     *  Metodo responsavel por escrever uma nova mensagem para um ficheiro
     * @param newMensagem
     * @return 
     */
     public boolean escreverFicheiroMensagem(Mensagem newMensagem);
     
     /**
      * Metodo responsavel por ler uma nova mensagem de um dado ficheiro
      * @return 
      */
     public DoubleLinkedUnorderedList<Mensagem> lerFicheiroMensagem();
    
}
