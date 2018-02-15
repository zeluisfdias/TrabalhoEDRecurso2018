/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

/**
 *
 * @author ZeLuis
 * @param <T>
 */
public class DoubleNode<T> {

    /**
     * Referência para o próximo Node
     */
    private DoubleNode<T> next;
    /**
     * Elemento guardado neste Node
     */
    private T element;
    /**
     * Referência para o Node anterior.
     */
    private DoubleNode<T> previous;

    /**
     * Método construtor para instanciação de um DoubleNode vazio.
     */
    public DoubleNode() {
        this.next = null;
        this.element = null;
        this.previous = null;
    }

    /**
     * Métdodo construtor para a instanciação de um DoubleNode com um elemento
     * especifico a ser guardado neste DoubleNode.
     *
     * @param element Elemento a ser guardado no novo DoubleNode
     */
    public DoubleNode(T element) {
        this.next = null;
        this.element = element;
        this.previous = null;
    }

    /**
     * Método responsavél por devolver o próximo Node.
     *
     * @return Próximo Node.
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Método responsavél por definir um novo próximo Node.
     *
     * @param next Novo próximo Node.
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Método responsavél por devolver um elemento.
     *
     * @return Elemento.
     */
    public T getElement() {
        return element;
    }

    /**
     * Método responsavél por definir um novo elemento.
     *
     * @param element Novo elemento.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Método responsavél por devolver o Node anterior.
     *
     * @return Node anterior.
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    /**
     * Método responsavél por definir um novo Node anterior.
     *
     * @param previous Novo Node anterior.
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

}
