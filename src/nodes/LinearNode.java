/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

/**
 *
 * @author Zé Luís
 * @param <T>
 */
public class LinearNode<T> {

    /**
     * Referencia ao proximo no da lista
     */
    private LinearNode<T> nextElement;
    /**
     * Elemento que está no actual no
     */
    private T element;

    /**
     * Cria um no vazio na lista
     */
    public LinearNode() {
        this.nextElement = null;
        this.element = null;
    }

    /**
     * Cria um nó que esta localizado num determinado element
     *
     * @param element - elemento a ser armazenado
     */
    public LinearNode(T element) {
        this.nextElement = null;
        this.element = element;
    }

    /**
     * Retorna o no que procede este no
     * @return 
     */
    public LinearNode<T> getNextElement() {
        return nextElement;
    }

    /**
     * Configura um novo no procedente a este
     * @param nextElement 
     */
    public void setNextElement(LinearNode<T> nextElement) {
        this.nextElement = nextElement;
    }

    /**
     * Retorna o elemento que esta armazenado neste no 
     * @return 
     */
    public T getElement() {
        return element;
    }

    /**
     * Configura o novo elemento para este no
     * @param element 
     */
    public void setElement(T element) {
        this.element = element;
    }
    
    
    
    

}
