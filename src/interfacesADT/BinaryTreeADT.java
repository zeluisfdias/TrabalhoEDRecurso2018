/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesADT;
import excecoes.ElementNotFoundException;
import excecoes.EmptyCollectionException;
import java.util.Iterator;


/**
 * Metodo Responsavel por definir a Interface BinaryTreeADT
 * @author Fábio Rêgo
 */

public interface BinaryTreeADT<T> 
{
   

   /**
    * Metodo responsavel por retornar true se a árvore binária estiver vazia 
    * e falso caso contrário
    * @return 
    */
   public boolean isEmpty();

   /**
    * Metodo responsavel por retornar o número de elementos nesta árvore binária.
    * @return 
    */
   public int size();

   /**
    * Metodo responsavel por retornar verdadeiro se a árvore binária tiver um elemento que corresponda
    * o elemento especificado e falso, caso contrário.
    * @param targetElement
    * @return 
    */
   public boolean contains (T targetElement);

   /**
    * Metodo responsavel por retornar uma referência ao elemento especificado se for encontrada na árvore binária.
    * Lança uma exceção se o elemento especificado não for encontrado
    * @param targetElement
    * @return
    * @throws ElementNotFoundException 
    */
   public T find (T targetElement) throws ElementNotFoundException;

   /**
    * Metodo responsavel por retornar o metodo toString da árvore binária
    * @return 
    */
   @Override
   public String toString();

  /**
   * Metodo responsavel por realizar uma travessia InOrder na árvore binária
   * @return 
   */
   public Iterator<T> iteratorInOrder();

   /**
    * Metodo responsavel por realizar uma travessia PreOrdee na árvore binária
    * @return 
    */
   public Iterator<T> iteratorPreOrder();

  /**
   * Metodo responsavel por realizar uma travessia PostOrder na árvore binária
   * @return 
   */
   public Iterator<T> iteratorPostOrder();

   /**
    * Metodo responsavel por realizar uma travessia LevelOrder na árvore binária
    * @return
    * @throws EmptyCollectionException 
    */
   public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException;
}