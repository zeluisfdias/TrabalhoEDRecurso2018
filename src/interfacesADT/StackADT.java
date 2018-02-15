/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesADT;

import excecoes.EmptyCollectionException;

/**
 * Metodo Responsavel por definir a Interface StackADT
 * @author Zé Luís
 * @param <T>
 */
public interface StackADT<T>  {
    
    /**
     * Metodo responsavel por adicionar um elemento no topo da stack
     * @param element 
     */
    public void push(T element); // adiciona um elemento no topo da stack
    
    /**
     * Metodo responsavel por remover e retorna o elemento do topo da stack 
     * @return
     * @throws EmptyCollectionException 
     */
    public T pop() throws EmptyCollectionException; //remove e retorna o elemento do topo da stack 
    
    /**
     * Metodo responsavel por retornar sem remover o elemento do topo da stack
     * @return
     * @throws EmptyCollectionException 
     */
    public T peek() throws EmptyCollectionException; //retorna sem remover o elemento do topo da stack
    
    /**
     * Metodo responsavel por retornar true se a stack contem nenhum elementos
     * @return 
     */
    public boolean isEmpty(); // retorna true se a stack contem nenhum elementos
    
    /**
     * Metodo responsavel por retornar o numero de elementos na stack 
     * @return 
     */
    public int size(); // retorna o numero de elementos na stack 
    
    /**
     * Metodo responsavel pelo toString da stack
     * @return 
     */
    @Override
    public String toString();
    
    
}
