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
 * Metodo Responsavel por definir a Interface ListADT
 * @author Zé Luís
 * @param <T>
 */
public interface ListADT<T extends Object> extends Iterable<T> {
    
  /**
 * Remove e retorna o primeiro elemento da lista.
 *
 * @return 
     * @throws excecoes.EmptyCollectionException
 */
 public T removeFirst () throws EmptyCollectionException;
 /**
 * Remove e retorna o ultimo elemento da lista.
 *
 * @return 
     * @throws excecoes.EmptyCollectionException
     * 
 */
 public T removeLast () throws EmptyCollectionException;
 /**
 * Remove e retorna o elemento especificado da lista.
 *
 * @param element the element to be removed from the list
     * @return 
     * @throws excecoes.ElementNotFoundException 
     * @throws excecoes.EmptyCollectionException 
     *
 */
 public T remove (T element) throws ElementNotFoundException,EmptyCollectionException ;
 /**
 * Retorna a referência do primeiro elemento a lista.
 * @return
     * @throws excecoes.EmptyCollectionException
 */
 public T first () throws EmptyCollectionException;
 /**
 * Retorna a referência do ultimo elemento a lista.
 * @return 
     * @throws excecoes.EmptyCollectionException
 */
 public T last () throws EmptyCollectionException;
 /**
 * Reorna true se a lista tiver o elemento especificado
 * @param target 
 * @return true 

 */
 public boolean contains (T target);
 /**
 * Retorna true se a lista não tiver elementos.
 * @return true 
 */
 public boolean isEmpty();
  /**
 * Retorna o numero de elemntos da lista
 *
 * @return 
 * elements in this list
 */
 public int size();
 /**
 * Retorna um Iterador com todos os elementos da lista
 *
 * @return 
 */
 @Override
 public Iterator<T> iterator();
 /**
 * respresentação do metodo toString
 *
 * @return 
 */
 @Override
 public String toString();
    
}
