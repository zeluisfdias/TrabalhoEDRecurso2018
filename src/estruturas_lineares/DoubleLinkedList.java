package estruturas_lineares;


import excecoes.ElementNotFoundException;
import excecoes.EmptyCollectionException;
import interfacesADT.ListADT;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


import java.util.logging.Level;
import java.util.logging.Logger;
import nodes.DoubleNode;

/**
 *
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class DoubleLinkedList<T> implements ListADT<T>, Serializable {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int countElements;
    private int modCount;

    /**
     * Método construtor para a instanciação de um DoubleLinkedList vazia.
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.countElements = 0;
        this.modCount = 0;
    }

    /**
     * Método responsavél por remover e devolver o Elemento que se encontra na
     * cabeça da Lista.
     *
     * @return o Elemento removido.
     * @throws EmptyCollectionException Quando a Lista se encontra vazia.
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("A Lista está vazia.");
        } else {
            T tmpElement = this.head.getElement();

            if (this.size() == 1) {
                this.head = this.tail = null;
            } else {
                this.head = this.head.getNext();
                this.head.setPrevious(null);

            }

            this.countElements--;
            this.modCount++;
            return tmpElement;
        }
    }

    /**
     * Método responsavél por remover e devolver o Elemento que se encontra na
     * cauda da Lista.
     * 
     * @return o Elemento removido.
     * @throws EmptyCollectionException Quando a Lista se encontra vazia.
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("A Lista está vazia.");
        } else {
            T tmpElement = this.tail.getElement();

            if (this.size() == 1) {
                this.head = this.tail = null;
            } else {
                this.tail = this.tail.getPrevious();
                this.tail.setNext(null);

            }

            this.countElements--;
            this.modCount++;

            return tmpElement;
        }
    }

    /**
     * Método responsavél por remover um Elemento da Lista, sendo esse Elemento
     * passado por parâmetro.
     * 
     * @param element Elemento a ser removido da Lista.
     * @return Elemento removido da Lista.
     * @throws ElementNotFoundException Quando a Lista se encontra vazia.
     */
    @Override
    public T remove(T element) throws ElementNotFoundException {

        if (!this.contains(element)) {
            throw new ElementNotFoundException("Elemento não se encontra na Collection.");
        }

        T tmpElement = null;
        //Se o elemento a remover estiver na cabeça usar o metodo removeFirst
        //Caso o elemento a remover esteja na cauda usar o metodo removeLast
        //Senao iterar até encontrar o elemento a remover
        if (this.head.getElement().equals(element)) {
            try {
                tmpElement = removeFirst();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(DoubleLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (this.tail.getElement().equals(element)) {
            try {
                tmpElement = removeLast();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(DoubleLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            DoubleNode<T> current = this.head;

            //Fazer a verificação não no nó actual mas o próximo. Fica mais
            //facil para depois trocar as referencias
            while (!element.equals(current.getNext().getElement())) {
                current = current.getNext();
            }

            current.setNext(current.getNext().getNext());
            current.getNext().setPrevious(current);

            this.countElements--;
            this.modCount++;
        }

        return tmpElement;
    }

    /**
     * Método responsavél por devolver o Elemento que se encontra na cabeça
     * da Lista.
     * 
     * @return O Elemento que se encontra na cabeça da Lista.
     * @throws EmptyCollectionException Quando a Lista se encontra vazia.
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Lista está vazia");
        } else {
            return this.head.getElement();
        }
    }

    /**
     * Método responsavél por devolver o Elemento que se encontra na cauda da
     * Lista.
     * 
     * @return O Elemento que se encontra na cauda da Lista.
     * @throws EmptyCollectionException Quando a Lista se encontra vazia.
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A Lista está vazia");
        }
        return this.tail.getElement();

    }

    /**
     * Método que devolve um valor booleano indicando se o Elemento passado por
     * parâmetro se encontra ou não na Lista.
     * 
     * @param target Elemento a ser procurado.
     * @return Valor booleano que indica a presença ou não do Elemento na Lista.
     */
    @Override
    public boolean contains(T target) {

        if (!isEmpty()) {
            DoubleNode<T> current = this.head;
            boolean found = false;

            while (current != null && !found) {
                if (target.equals(current.getElement())) {
                    found = true;
                } else {
                    current = current.getNext();
                }
            }

            return found;
        }

        return false;
    }

    /**
     * Método que devolve um valor booleano que indica se a Lista se encontra
     * ou não vazia.
     * 
     * @return Valor booleano que indica se a Lista se encontra ou não vazia.
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Método responsavél por devolver um valor inteiro que indica o tamanho
     * da Lista.
     * 
     * @return Valor inteiro que indica o tamanho da Lista.
     */
    @Override
    public int size() {
        return this.countElements;
    }

    /**
     * Método responsavél por devolver a um valor inteiro que indica o número
     * de vezes que se invocou métodos de adicionar ou remover elementos.
     * 
     * @return Valor inteiro que indica o número de vezes que se invocou métodos 
     * de adicionar ou remover elementos.
     */
    public int getModCount() {
        return modCount;
    }

    /**
     * Método responsavél por definir um novo valor para a variavél que indica
     * o número de vezes que se invocou métodos de adicionar ou remover 
     * elementos.
     * 
     * @param modCount Novo valor inteiro.
     */
    public void setModCount(int modCount) {
        this.modCount = modCount;
    }

    /**
     * Inner Classe que implementa a interface Iterator
     *
     * @param <T>
     */
    class BasicIterator<T> implements Iterator<T> {

        private DoubleNode<T> current;

        private int expectedModCount;
        private boolean okToRemove;

        /**
         * Método construtor responsavél pela criação de uma nova instância de 
         * BasicIterator.
         */
        public BasicIterator() {
            this.current = (DoubleNode<T>) head;
            this.expectedModCount = getModCount();
            this.okToRemove = false;
        }

        /**
         * Método que indica se existe ou não um próximo elemento no 
         * BasicIterator.
         * 
         * @return Valor booleano que indica a existência ou não de um próximo
         * elemento.
         */
        @Override
        public boolean hasNext() {
            if (this.expectedModCount != getModCount()) {
                throw new ConcurrentModificationException("A Lista foi modificada fora do iterator.");
            } else {
                return this.current != null;
            }
        }

        /**
         * Método que devolve o próximo Elemento do BasicIterator.
         * 
         * @return Próximo Elemento do BasicIterator.
         */
        @Override
        public T next() {
            if (this.hasNext()) {
                this.okToRemove = true;
                DoubleNode<T> next = this.current.getNext();
                T returnElement = this.current.getElement();

                this.current = next;

                return returnElement;
            } else {
                throw new NoSuchElementException("Não existe próximo elemento.");
            }
        }

        /**
         * Método responsavél por remover um Elemento do BasicIterator.
         */
        @Override
        public void remove() {
            if (this.expectedModCount != getModCount()) {
                throw new ConcurrentModificationException("A Lista foi modificada fora do iterator.");
            } else if (!this.okToRemove) {
                throw new IllegalStateException("Antes de poder remover tem chamar o next().");
            } else {

                //Temos de remover o anterior
                DoubleNode<T> toRemove;
                toRemove = current.getPrevious();

                //Se formos remover a cabeça da Lista
                if (toRemove.getPrevious() == null) {
                    try {
                        DoubleLinkedList.this.removeFirst();
                    } catch (EmptyCollectionException ex) {
                        System.out.println(ex.toString());
                    }
                } else {
                    //O anterior do anterior aponta para o actual
                    toRemove.getPrevious().setNext(current);
                    //O anterior do actual agora é o anteior do anterior
                    current.setPrevious(toRemove.getPrevious());

                    toRemove.setNext(null);
                    toRemove.setPrevious(null);
                }

                this.okToRemove = false;

            }
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
        //return (Iterator<T>) new DoubleLinkedList();
    }

    @Override
    public String toString() {
        //BasicIterator<T> innerIterator = new BasicIterator<>();
        StringBuilder str = new StringBuilder();
        DoubleNode<T> current = this.head;

        while (current != null) {
            str.append(current.getElement());
            current = current.getNext();
            str.append(" ");
        }

        return str.toString();
    }

    /**
     * Método responsavél por devolver a cabeça da Lista.
     *
     * @return Cabeça da Lista.
     */
    public DoubleNode<T> getHead() {
        return head;
    }

    /**
     * Método responsavél por definir uma nova cabeça da Lista.
     *
     * @param head Nova cabeça da Lista.
     */
    public void setHead(DoubleNode<T> head) {
        this.head = head;
    }

    /**
     * Método responsavél por devolver a cauda da Lista.
     *
     * @return Cauda da Lista.
     */
    public DoubleNode<T> getTail() {
        return tail;
    }

    /**
     * Método responsavél por definir uma nova cauda da Lista.
     *
     * @param tail Nova cauda da Lista.
     */
    public void setTail(DoubleNode<T> tail) {
        this.tail = tail;
    }

    /**
     * Método responsavél por devolver quanto elementos existem na Lista.
     *
     * @return Valor inteiro que indica quanto elementos existem na Lista.
     */
    public int getCountElements() {
        return countElements;
    }

    /**
     * Método responsavél por definir quantos elementos existem na Lista.
     *
     * @param countElements Novo valor inteiro que indica quantos elementos
     * existem na Lista.
     */
    public void setCountElements(int countElements) {
        this.countElements = countElements;
    }

}
