/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas_lineares;

import excecoes.EmptyCollectionException;
import interfacesADT.StackADT;
import nodes.LinearNode;

/**
 * Classe responsavel por criar uma classe do tipo LinkedStack
 * @author Zé Luís
 * @param <T>
 */
public class LinkedStack<T> implements StackADT<T>{

    private LinearNode<T> topoLista; //referencia ao elemento que esta no topo da stack
    private int size; // um silo não tem limite de espaço

    /**
     * Construtor que cria uma stack com um tamanho e um elemento do top já
     * definidos inicialmente
     *
     * @param topoLista no do topo da stack
     * @param size tamanho da stack que estamos a criar no momento
     */
    public LinkedStack(LinearNode<T> topoLista, int size) {
        this.topoLista = topoLista;
        this.size = size;
    }

    /**
     * Construtor que cria uma stack sem elementos, ou seja vazia inicialmente.
     * A unica maneira de adicionar é com recurso ao metodo @link push()
     */
    public LinkedStack() {
        this.topoLista = null;
        this.size = 0;
    }

    /**
     * Metodos GET e SET da class LinkedStack
     * @return 
     */
    public LinearNode<T> getTopoLista() {
        return topoLista;
    }

    public void setTopoLista(LinearNode<T> topoLista) {
        this.topoLista = topoLista;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Adiciona um novo elemento a Stack
     * @param t
     */
    @Override
    public void push(T t) {

        LinearNode<T> nodeTemp = new LinearNode<>(t);

        if (isEmpty()) { 
            topoLista = nodeTemp;
            size++;
        } else { //senão estiver vazia entao dá adiciona o novo valor a stack, atribuindo o seguinte nó como o antigo topo da lista 
            nodeTemp.setNextElement(topoLista);
            topoLista = nodeTemp; //atribui como topo da lista o novo que se adicionou
            size++; //aumenta-se o tamanho da stack
        }

    }

    /**
     * Remove um dado elemento da Stack
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T pop() throws EmptyCollectionException {

        LinearNode<T> node;
        if (isEmpty()) {
            throw new EmptyCollectionException("A stack encontra-se vazia no momemento");
        } else {
            T element = topoLista.getElement();
            topoLista.setElement(element);
            size--;
            return element;
                  
        }
    }

    /**
     * Rwtorna o elemento do topo da stack sem o remover
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A stack encontra-se vazia no momento");
        } else {
            return topoLista.getElement();
        }
    }

    /**
     * Metodo responsavel por verificar se a LinkedStack está vazia
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * Metodo responsavel por devolver o tamanho da LinkedStack
     * @return 
     */
    @Override
    public int size() {
        return this.size;
    }
    
    
    
}
