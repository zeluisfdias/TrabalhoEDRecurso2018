package estruturas_lineares.non_ordered;

import estruturas_lineares.DoubleLinkedList;
import excecoes.ElementNotFoundException;
import interfacesADT.UnorderedListADT;
import java.io.Serializable;
import nodes.DoubleNode;



/**
 * Classe responsavel por criar uma classe do tipo DoubleLinkedUnorderedList
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T>,Serializable {

    /**
     *Método construtor para a criação de uma nova Instância de 
     * DoubleLinkedUnorderedList vazia.
     */
    public DoubleLinkedUnorderedList() {
        super();
    }

    /**
     * Método responsavél por adicionar um novo Elemento à cabeça da 
     * DoubleLinkedUnorderedList.
     * 
     * @param element Novo Elemento a ser adicionado.
     */
    @Override
    public void addToFront(T element) {
        if (element != null) {
            DoubleNode<T> tmpNode = new DoubleNode<>(element);

            if (super.isEmpty()) {
                super.setHead(tmpNode);
                super.setTail(super.getHead());
            } else {
                super.getHead().setPrevious(tmpNode);
                tmpNode.setNext(super.getHead());

                super.setHead(tmpNode);
            }

            super.setCountElements(super.getCountElements() + 1);
            super.setModCount(super.getModCount() + 1);
        }
    }

    /**
     * Método responsavél por adicionar um novo Elemento à cauda da 
     * DoubleLinkedUnorderedList.
     * 
     * @param element Novo Elemento a ser adicionado.
     */
    @Override
    public void addToRear(T element) {
        if (element != null) {
            DoubleNode<T> tmpNode = new DoubleNode<>(element);

            if (super.isEmpty()) {
                super.setHead(tmpNode);
                super.setTail(super.getHead());
            } else {
                super.getTail().setNext(tmpNode);
                tmpNode.setPrevious(super.getTail());

                super.setTail(tmpNode);
            }

            super.setCountElements(super.getCountElements() + 1);
            super.setModCount(super.getModCount() + 1);
        }
    }

    /**
     * Método responsavél por adicionar um novo Elemento a seguir a um Elemento
     * já existente na DoubleLinkedUnorderedList.
     * 
     * @param element Novo Elemento a ser adicionado.
     * @param target Elemento na posição anterior ao novo Elemento a ser 
     * adicionado.
     * @throws ElementNotFoundException Quando o Elemento a ser procurado não
     * existe na ArrayUnorderedList.
     */
    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException {
        if (element != null) {
            if (!super.isEmpty()) {

                if (super.contains(target)) {

                    DoubleNode<T> current = super.getHead();
                    DoubleNode<T> tmpNode = new DoubleNode<>(element);

                    while (!target.equals(current.getElement())) {
                        current = current.getNext();
                    }

                    //Se for adicionado no meio da lista ou no inicio
                    if (current.getNext() != null) {
                        tmpNode.setPrevious(current);
                        tmpNode.setNext(current.getNext());

                        current.getNext().setPrevious(tmpNode);
                        current.setNext(tmpNode);

                        //Se for adicionar a seguir ao ultimo elemento da lista
                    } else {
                        tmpNode.setPrevious(current);

                        current.setNext(tmpNode);

                        //Actualizar a Tail
                        super.setTail(tmpNode);
                    }

                    super.setCountElements(super.getCountElements() + 1);
                    super.setModCount(super.getModCount() + 1);
                } else {
                    throw new ElementNotFoundException("Esse elemento não se encontra na Lista.");
                }
            }
        }
    }

}
