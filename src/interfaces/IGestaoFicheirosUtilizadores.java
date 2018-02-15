/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import models.Utilizador;

/**
 *
 * Interface responsavel por criar os metodos para a Interface IGestaoFicheirosUtilizadores
 * @author ZeLuis
 */
public interface IGestaoFicheirosUtilizadores {
    
    /**
     * Metodo responsavel por escrever um novo utlizador para um ficheiro
     * @param newUser
     * @param usersTemp
     * @return 
     */
     public boolean escreverFicheiro(Utilizador newUser, DoubleLinkedUnorderedList<Utilizador> usersTemp);
     
     /**
      * Metodo responsavel por ler os dados de um novo utilizador de um dado ficheiro
      * @return 
      */
     public DoubleLinkedUnorderedList<Utilizador> lerFicheiro();
}
