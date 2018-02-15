/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas_lineares;

import excecoes.EmptyCollectionException;
import interfacesADT.QueueADT;
import nodes.LinearNode;

/**
 * Classe responsavel por criar uma classe do tipo LinkedQueue
 * @author Zé Luís
 * @param <T> Classe parametrizada.
 */
public class LinkedQueue<T> implements QueueADT<T> {

    public LinearNode front;
    public LinearNode rear;
    public int size;

    /**
     * Metodo construtor para instanciar uma nova Queue sem elementos, e com a
     * rear e front a null
     */
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;

    }

    /**
     * Metodo Construtor para instanciar uma nova Queue, com o elemento cabeca.
     *
     * @param front
     */
    public LinkedQueue(LinearNode front) {
        this.front = front;
        this.size++;
    }

    /**
     * Metodo responsavel por adicionar elementos a Queue,
     *
     * @param element elemento a introduzir na Queue
     */
    @Override
    public void enqueue(T element) {
          System.out.println("Adição do Elemento "+element+" a Queue\n");
          LinearNode temp = new LinearNode(element);
        
         //Verifica se a Queue se encontra vazia
          if (isEmpty()) {
            front = temp;
            rear = front; //atribui a cauda e a cabeca com o mesmo valor, pois só existe apenas 1 elemento
            size++; //incrementa um valor ao tamanho da queue
        } else {

            rear.setNextElement(temp); // atribui o proximo elemento do elemento cauda, como o novo elemento a adicionar
            rear = rear.getNextElement(); // atribui o valor do novo elemento a cauda que foi o elemento que adicionamos como proximo anteriormente.
            size++; // incrementa um valor ao tamanho da queue.
        }
    }

    /**
     * Metodo responsavel por remover um elemento da Queue
     *
     * @return retorna um elemento generico referente ao elemento que foi eliminado
     * @throws excecoes.EmptyCollectionException lancada quando a Queue se encontra vazia.
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        
        System.out.println("REMOÇÃO DE ELEMENTO DA QUEUE\n");
        if (isEmpty()) { //verifica se a queue se encontra vazia
            throw new EmptyCollectionException("A queue encontra-se vazia!");
        }

        T elementoRetornar = (T) front.getElement(); // obtem o elemento da frente
        front = front.getNextElement();
        size--; //descresce um valor ao tamanho da queue
        return elementoRetornar; //retorna o elemento que foi eliminado 

    }

    /**
     * Metodo responsavel por retornar o primeiro elemento da Queue
     *
     * @return
     * @throws excecoes.EmptyCollectionException
     */
    @Override
    public T first()  throws EmptyCollectionException{
        if (isEmpty()) { //se a Queue estiver vazia
          throw new EmptyCollectionException("Queue Vazia");
        }
        T elementoRetornar = (T) front.getElement();
        return elementoRetornar;

    }

    /**
     * Metodo responsável por retornar se a Queue se encontra ou nao vazia
     * @return um valor booleano a informar se a Queue esta vazia
     */
    @Override
    public boolean isEmpty() {
        return size == 0; 

    }

    /**
     * Método responsável por retornar o valor inteiro que corresponde ao tamanho da Queue.
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Retorna o nó referente a cabeca da queue.
     *
     * @return
     */
    public LinearNode getFront() {
        return front;
    }

    /**
     * Atribui um novo valor a um no ja existente.
     *
     * @param front
     */
    public void setFront(LinearNode front) {
        this.front = front;
    }

    /**
     * Obtem a cauda da Queue
     *
     * @return
     */
    public LinearNode getRear() {
        return rear;
    }

    /**
     * Da um novo valor à cauda da queue
     *
     * @param rear
     */
    public void setRear(LinearNode rear) {
        this.rear = rear;
    }

    /**
     * Retorna um desenho grafico da queue;
     *
     * @return
     */
    @Override
    public String toString() {
        String stringToReturn;
        int i =0;
        if (isEmpty()) {
            return "QUEUE VAZIA! ADICIONE ELEMENTOS";
        }
        stringToReturn = "REPRESENTAÇÃO DA QUEUE\n\n-CABECA:" + front.getElement() + "\n";

        LinearNode<T> next = front.getNextElement();

        while (next != null) {
            stringToReturn +="ELEMENT:"+i+"__VALUE: "+next.getElement()+" | ";
            next = next.getNextElement();
            i++;
        }
        
        stringToReturn+="\nCAUDA:"+rear.getElement();
        return stringToReturn;
    } // End of toString met

}
