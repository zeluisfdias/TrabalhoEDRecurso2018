/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas_lineares;

import excecoes.ElementNotFoundException;
import excecoes.EmptyCollectionException;
import interfacesADT.ListADT;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ZeLuis
 * @param <T>
 */
public class ArrayList<T> implements ListADT<T> {

    /**
     * Array Lista.
     */
    T[] array;

    /**
     * Tamanho por defeito da Lista.
     */
    private final int DEFAULT_SIZE = 100;

    /**
     * Próxima posição vazia
     */
    private int position;

    /**
     * Contador responsavél por contar todas as operações de add e remove.
     */
    private int modCount;

    /**
     * Método construtor para a instanciação da Lista vazia, com um tamanho por
     * defeito.
     */
    public ArrayList() {
        this.array = (T[]) (new Object[DEFAULT_SIZE]);
        this.position = 0;
        this.modCount = 0;
    }

    /**
     * Método construtor para a instanciação da Lista vazia com um determinado
     * tamanho
     *
     * @param maxSize Tamanho da Lista Ordenada.
     */
    public ArrayList(int maxSize) {
        this.array = (T[]) (new Object[DEFAULT_SIZE]);
        this.position = 0;
        this.modCount = 0;
    }

    /**
     * Método responsavél por aumentar a capacidade da Lista para o dobro da
     * actual.
     */
    public void expandCapacity() {
        T[] tmpArray = (T[]) (new Object[this.size() * 2]);
        int i = 0;

        while (i < this.size()) {
            tmpArray[i] = this.array[i];
            i++;
        }

        this.array = tmpArray;
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
            throw new EmptyCollectionException("Empty Collection.");
        }

        int i = 0;
        T tmpElement = this.array[i];

        while (i < this.position - 1) {
            this.array[i] = this.array[i + 1];
            i++;
        }

        this.array[i] = null;
        this.position--;
        this.modCount++;

        return tmpElement;

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
            throw new EmptyCollectionException("Empty Collection.");
        }

        T tmpElement = this.array[this.position - 1];
        this.array[this.position - 1] = null;
        this.position--;
        this.modCount++;

        return tmpElement;

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
    public T remove(T element) throws ElementNotFoundException, EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("A coleccao encontra-se vazia no momento");
        } else {
            if (this.contains(element) == false) {
                throw new ElementNotFoundException("Esse elemento não se encontra na Lista.");
            } else {
                int i = 0;

                while (!element.equals(this.array[i])) {
                    i++;
                }

                T tmpElement = this.array[i];

                while (i < this.position - 1) {
                    this.array[i] = this.array[i + 1];
                    i++;
                }

                this.array[i] = null;
                this.position--;
                this.modCount++;

                return tmpElement;
            }
        }
    }

    /**
     * Método responsavél por devolver o Elemento que se encontra na cabeça da
     * Lista.
     *
     * @return O Elemento que se encontra na cabeça da Lista.
     * @throws EmptyCollectionException Quando a Lista se encontra vazia.
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty Collection.");
        }
        return this.array[0];

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
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty Collection.");
        }

        return this.array[this.position - 1];

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
        if (this.isEmpty()) {
            return false;
        } else {
            int i = 0;

            while ((i < this.position) && !target.equals(this.array[i])) {
                i++;
            }

            return !(i == this.position);
        }
    }

    /**
     * Método que devolve um valor booleano que indica se a Lista se encontra ou
     * não vazia.
     *
     * @return Valor booleano que indica se a Lista se encontra ou não vazia.
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Método responsavél por devolver um valor inteiro que indica o tamanho da
     * Lista.
     *
     * @return Valor inteiro que indica o tamanho da Lista.
     */
    @Override
    public int size() {
        return this.position;
    }

    /**
     * Método responsavél por devolver a um valor inteiro que indica o número de
     * vezes que se invocou métodos de adicionar ou remover elementos.
     *
     * @return Valor inteiro que indica o número de vezes que se invocou métodos
     * de adicionar ou remover elementos.
     */
    public int getModCount() {
        return modCount;
    }

    /**
     * Método responsavél por definir um novo valor para a variavél que indica o
     * número de vezes que se invocou métodos de adicionar ou remover elementos.
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

        private int iteratorPosition;
        private int expectedModCount;
        private boolean okToRemove;

        /**
         * Método construtor responsavél pela criação de uma nova instância de
         * BasicIterator.
         */
        public BasicIterator() {
            this.iteratorPosition = 0;
            this.expectedModCount = modCount;
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
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException("A Lista foi modificada fora do iterator.");
            } else {
                return this.iteratorPosition < position;
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
                return (T) array[iteratorPosition++];
            }

            throw new NoSuchElementException("Não existe próximo elemento.");
        }

        /**
         * Método responsavél por remover um Elemento do BasicIterator.
         */
        @Override
        public void remove() {
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException("A Lista foi modificada fora do iterator.");
            } else if (!this.okToRemove) {
                throw new IllegalStateException("Antes de poder remover tem chamar o next().");
            } else {
                try {
                    //Faz-se --this.iteratorPosition porque o elemento a ser removido é 
                    //o que foi retornado anteriormente pelo iterator, pelo que primeiro temos
                    //de decrementar e só depois é que removemos, prefix
                    ArrayList.this.remove(array[--this.iteratorPosition]);
                    //Actualizar o contador
                    this.expectedModCount = modCount;
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }

            }
        }

    }

    /**
     * Método responsavél por retornar um Iterador com todos os elementos da
     * Lista.
     *
     * @return Iterador com os elementos da Lista.
     */
    @Override
    public Iterator<T> iterator() {
        BasicIterator<T> innerIterator = new BasicIterator<>();

        return innerIterator;
    }

    /**
     * Método que retornar uma representação em String do conteudo da Lista.
     *
     * @return Representação em String do conteudo da Lista.
     */
    @Override
    public String toString() {
        BasicIterator<T> innerIterator = new BasicIterator<>();
        StringBuilder str = new StringBuilder();

        while (innerIterator.hasNext()) {
            str.append(innerIterator.next().toString());
            str.append(" ");
        }

        return str.toString();
    }

    /**
     * Método responsavél por devolver a Lista.
     *
     * @return Lista.
     */
    public T[] getArray() {
        return array;
    }

    /**
     * Método responsavél por definir uma nova Lista.
     *
     * @param array Nova Lista.
     */
    public void setArray(T[] array) {
        this.array = array;
    }

    /**
     * Método responsavél por devolver a próxima posição vazia da Lista.
     *
     * @return Próxima posição vazia da Lista.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Método responsavél por definir uma nova próxima posição vazia da Lista.
     *
     * @param position Nova próxima posição vazia da Lista.
     */
    public void setPosition(int position) {
        this.position = position;
    }

}
