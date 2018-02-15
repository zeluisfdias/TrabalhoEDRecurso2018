/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas_lineares;

/**
 * classe responsavel por criar um novo elemento na estrutura
 * @author Fábio Rêgo
 */
public class Element<T> {
    private T valor;
    Element next;

    /**
     * Metodo Construtor da class Element
     * @param valor 
     */
    public Element(T valor) {
        this.valor = valor;
        this.next = null;
    }

    /**
     * Metodos GET e SET da class Element
     * @return 
     */
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

} 