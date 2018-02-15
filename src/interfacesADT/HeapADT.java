/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesADT;

import excecoes.EmptyCollectionException;

/**
 * Metodo Responsavel por definir a Interface HeapADT
 * @author Fábio Rêgo
 * @param <T>
 */
public interface HeapADT<T> extends BinaryTreeADT<T> 
{
   /** Adiciona o objeto especificado a uma heap.
     * @param obj */
   public void addElement (T obj);
   
   /** Remove e retorna uma referência para o elemento 
    * com o valor mais baixo na heap.
     * @return 
     * @throws excecoes.EmptyCollectionException */
   public T removeMin() throws EmptyCollectionException;
   
   /** Remove o elemento com o valor mais baixo na heap.
     * @return 
     * @throws excecoes.EmptyCollectionException */
   public T findMin() throws EmptyCollectionException;
}