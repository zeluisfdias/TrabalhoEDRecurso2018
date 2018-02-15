/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesADT;

import excecoes.ElementNotFoundException;

/**
 * Classe que faz referencia a uma lista desordenada
 * @author Zé Luís
 * @author Fábio Rêgo
 * @param <T> Tipo Generico
 */
public interface UnorderedListADT<T extends Object> extends ListADT<T> {

    /**
     * Adiciona um elemento especifico no topo da lista 
     *
     * @param element elemento a adicionar
     */
    public void addToFront(T element);

    /**
     * Adiciona um elemento especifico na cauda da lista
     *
     * @param element elemento a adicionar
     */
    public void addToRear(T element);

    /**
     * Adiciona um elemento um lugar alvo.
     *
     * @param element elemento a adicionar
     * @param target elemento a alvo a ter em conta 
     * @throws excecoes.ElementNotFoundException excepção lancada quando nao e encontrado o elemento target
     */
    public void addAfter(T element, T target) throws ElementNotFoundException;
}
