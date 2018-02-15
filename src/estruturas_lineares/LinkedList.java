/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas_lineares;

import excecoes.ElementNotFoundException;
import excecoes.EmptyCollectionException;
import java.util.Iterator;

/**
 * Classe responsavel por criar uma classe do tipo LinkedList
 * @author Fábio Rêgo
 */
    
public class LinkedList<T> implements Iterable<T>{
    
    private Element head;

    /**
     * Metodos GET e SET da class LinkedList
     * @return 
     */
    public Element getHead() {
        return head;
    }

    public void setHead(Element head) {
        this.head = head;
    }
    
    /**
     * Metodo responsavel por adicionar um novo elemento à list
     * @param newElemento 
     */
    public void addElemento(T newElemento) {
        if (head == null) {
            head = new Element(newElemento);
        } else {
            Element x = head;
            while (x.next != null) {
                x = x.next;
            }
            Element y = new Element(newElemento);
            x.next = y;
        }
    }
    
    /**
     * Metodo responsavel por remover um dado elemento da list
     * @param element
     * @return
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException 
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        T elementToReturn;
        if (head.getValor() == element) {
            elementToReturn = (T) head.getValor();
            head = head.next;
            
        } else {
            while (head.next.getValor() != element) {
                head = head.next;
            }
            elementToReturn = (T) head.getValor();
            head.next = head.next.next;
        }
        return elementToReturn;
    }

    /**
     * Metodo responsavel por imprimir um valor do element
     */
    public void Print() {
        Element x = head;
        while (x != null) {
            System.out.println(x.getValor());
            x = x.next;
        }
    }
    
    /**
     * Metodos responsaveis por imprimir 
     * @param e
     * @return 
     */
    public String toStringR(Element e){
        if(e == null){
            return ".";
        }else{
            return e.getValor() + " " + toStringR(e.getNext()); 
        }
    }
    public String toStringR(){
        String str = toStringR(head);
        return str;
    }

    
    /**
     * Metodo Iterator que retorna um BasicIterator
     * @return 
     */
    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
    }
    
    
    /**
     * metodo responsavel por criar o BasicIterator
     * @param <T> 
     */
    public class BasicIterator<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            if(head != null)
                return true;
            return false;
        }

        @Override
        public T next() {
            Object retorno = head.getValor();
            head = head.getNext();
            return (T) retorno;
        }
        
    
}
    
    /**
     * Metodo toString
     * @return 
     */
    @Override
    public String toString() {
        return "LinkedList{" + "head=" + head.getValor() + iterator().next().toString()+'}';
    }
    
}

