package estruturas_lineares;

import nodes.LinearNode;
import excecoes.EmptyCollectionException;
import interfacesADT.StackADT;

/**
 * Classe responsavel por criar uma classe do tipo LinkedListStack
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class LinkedListStack<T> implements StackADT<T> {

    /**
     * Stack
     */
    private LinearNode<T> stack;
    
    /**
     * Referência para o elemento no topo da Stack.
     */
    private LinearNode<T> top;

    /**
     * Método construtor para a crição de uma nova instância de LinkedListStack
     * vazia.
     */
    public LinkedListStack() {
        this.stack = null;
        this.top = null;
    }

    /**
     * Adiciona um novo elemento ao topo da LinkedListStack.
     * 
     * @param element Novo elemento a ser adicionado a LinkedListStack.
     */
    @Override
    public void push(T element) {
        LinearNode<T> tmp = new LinearNode<>(element);
        tmp.setNextElement(this.stack);
        this.stack = tmp;
        this.top = this.stack;

    }

    /**
     * Método responsavél por remover e devolver o elemento que se encontra
     * no topo da LinkedListStack.
     * 
     * @return Elemento removido do topo da LinkedListStack.
     * @throws EmptyCollectionException Quando a LinkedListStack se encontra 
     * vazia.
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Collection.");
        }

        //Se já tivermos elementos
        if (this.stack != null) {
            T element;
            //Se já só tivermos a head
            if (this.stack.getNextElement()== null) {
                element = this.stack.getElement();
                this.stack = null;
                this.top = null;
            } else {
                //Coleção tmp que não tem a head actual da stack.
                LinearNode<T> tmp = this.stack.getNextElement();
                //Elemento que está na head da stack
                element = this.stack.getElement();

                //Stack passa a não ter o head eliminado
                this.stack = tmp;
                //Actualização da referencia da head.
                this.top = this.stack;
            }

            return element;
        } else {
            return null;
        }
    }

    /**
     * Método responsavél por devolver o elemento no topo da LinkedListStack sem
     * o remover.
     * 
     * @return Elemento no topo da LinkedListStack.
     * @throws EmptyCollectionException Quando a LinkedListStack se encontra 
     * vazia.
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Collection.");
        }
        return this.top.getElement();

    }

    /**
     * Método resposnsavél por devolver um valor booleano que indica se a 
     * LinkedListStack se encontra ou não vazia.
     * 
     * @return Valor booleano que indica se a LinkedListStack se encontra ou não 
     * vazia.
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Método responsavél por retornar um valor inteiro que representa o 
     * tamanho da LinkedListStack.
     * 
     * @return Valor inteiro que representa o tamanho da LinkedListStack.
     */
    @Override
    public int size() {
        int cont = 0;
        LinearNode<T> it = this.stack;

        while (it != null) {
            cont++;
            it = it.getNextElement();
        }

        return cont;
    }

    /**
     * Método responsavél por devolver uma representação textual da 
     * LinkedListStack.
     * 
     * @return String que representa uma representação textual da 
     * LinkedListStack.
     */
    @Override
    public String toString() {
        LinearNode<T> it = this.stack;
        StringBuffer print = new StringBuffer();

        while (it != null) {

            print.append(it.getElement() + "\t");
            it = it.getNextElement();
        }

        return print.toString();
    }

    /**
     * Método responsavél por obter a Stack.
     * 
     * @return a Stack
     */
    public LinearNode<T> getStack() {
        return stack;
    }

    /**
     * Método responsavél por definir uma nova Stack.
     * 
     * @param stack Nova Stack
     */
    public void setStack(LinearNode<T> stack) {
        this.stack = stack;
    }

    /**
     * Método responsavél por obter o LinearNode no topo da LinkedListStack.
     * 
     * @return LinearNode no topo da LinkedListStack.
     */
    public LinearNode<T> getTop() {
        return top;
    }

    /**
     * Método responsavél por definir um novo LinearNode no topo da 
     * LinkedListStack.
     * 
     * @param top novo LinearNode no topo da LinkedListStack.
     */
    public void setTop(LinearNode<T> top) {
        this.top = top;
    }

    /**
     * Método responsavél por apresentar no ecrã uma informação textual do
     * conteudo da LinkedListStack.
     * 
     */
    public void printAll() {
        LinearNode<T> it = this.stack;

        while (it != null) {
            System.out.print(it.toString() + "\t");
            it = it.getNextElement();
        }
        
        //Só para dar quebra de linha
        System.out.println("");
    }

}
