/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesADT;

import excecoes.EmptyCollectionException;

/**
 * Metodo Responsavel por definir a Interface BinaryTreeADT
 * @author Zé Luís
 * @param <T>
 */
public interface QueueADT<T> {
    
    /**
     * Metodo responsavel por adicionar um elemento na  Queue
     * @param element 
     */
    public void enqueue(T element); //adiciona um elemento na  Queue
    
    /**
     * Metodo responsavel por eliminar um elemento na Queue
     * @return
     * @throws EmptyCollectionException 
     */
    public T dequeue()throws EmptyCollectionException; // elimina um elemento na Queue
    
    /**
     * Metodo responsavel por retornar um elemento sem eliminar
     * @return
     * @throws EmptyCollectionException 
     */
    public T first()  throws EmptyCollectionException; //retorna um elemento sem eliminar
    
    /**
     * Metodo responsavel por retornar se a  queue esta ou nao vazia
     * @return 
     */
    public boolean isEmpty(); //retorna se a  queue esta ou nao vazia
    
    /**
     * Metodo responsavel por retornar o tamanho da queue
     * @return 
     */
    public int size(); // retorna o tamanho da queue
    
    /**
     * Metodo responsavel pelo toString da queue
     * @return 
     */
    @Override
    public String toString(); // 
    
    
    
    
}
