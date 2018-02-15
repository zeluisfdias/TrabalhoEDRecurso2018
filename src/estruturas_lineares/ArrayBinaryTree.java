package estruturas_lineares;


import estruturas_lineares.non_ordered.ArrayUnorderedList;
import estruturas_lineares.LinkedQueue;
import java.util.Iterator;
import excecoes.ElementNotFoundException;
import excecoes.EmptyCollectionException;
import interfacesADT.BinaryTreeADT;


/**
 *
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected T[] tree;
    private final int CAPACITY = 50;

    /**
     * Método construtor para criação de uma nova intância de ArrayBinaryTree
     * vazia.
     */
    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[CAPACITY];
    }

    /**
     * Método construtor para criação de uma nova instância de ArrayBinaryTree
     * com um elemento como root da ArrayBinaryTree passado por parâmetro.
     *
     * @param element Elemento que será a root da ArrayBinaryTrees.
     */
    public ArrayBinaryTree(T element) {
        count = 1;
        tree = (T[]) new Object[CAPACITY];
        tree[0] = element;
    }

    /**
     * Método responsavél por expandir a capacidade da ArrayBinaryTree para
     * o dobro do tamanho actual.
     */
    protected void expandCapacity() {
        T[] temp = (T[]) new Object[tree.length * 2];
        
        for (int i = 0; i < tree.length; i++) {
            temp[i] = tree[i];
        }
        tree = temp;
    }

    /**
     * Método responsavél por ober o elemento que está como root da
     * ArrayBinaryTree.
     * 
     * @return Elemento que está como root da ArrayBinaryTree.
     * @throws EmptyCollectionException Quando a ArrayBinaryTree estiver
     * vazia.
     */
    public T getRoot() throws EmptyCollectionException {
        if (tree[0] == null) {
            throw new EmptyCollectionException("A árvore está vazia.");
        }

        return tree[0];
    }

    /**
     * Método resposnsavél por devolver um valor booleano que indica se a 
     * ArrayBinaryTree se encontra ou não vazia.
     * 
     * @return Valor booleano que indica se a ArrayBinaryTree se encontra ou não 
     * vazia.
     */
    @Override
    public boolean isEmpty() {
        return (tree[0] == null);
    }

    /**
     * Método responsavél por retornar um valor inteiro que representa o 
     * tamanho da ArrayBinaryTree.
     * 
     * @return Valor inteiro que representa o tamanho da ArrayBinaryTree.
     */
    @Override
    public int size() {
  
        return count;
    }

    /**
     * Método responsavél por devolver um valor booleano que indica se um 
     * Elemento passado por parâmetro se encontra ou não na ArrayBinaryTree.
     * 
     * @param targetElement Elemento a ser procurado.
     * @return valor booleano que indica se um Elemento passado por parâmetro se 
     * encontra ou não na ArrayBinaryTree.
     */
    @Override
    public boolean contains(T targetElement) {
        try {
            //Se o T returnado pelo find for null então vamos retornar false, já
            //que o elemento não existe, se o find retornar um element, entao
            //retornamos true.
            return !(find(targetElement) == null);
        } catch (ElementNotFoundException ex) {
            return false;
        }
    }

    /**
     * Método responsavél por procurar se um determinado elemento passado por
     * parâmetro existe na ArrayBinaryTree.
     * 
     * @param targetElement Elemento a ser procurado.
     * @return Elemento encontrado ou null caso não seja encontrado.
     * @throws ElementNotFoundException Quando o elemento não se encontra na
     * ArrayBinaryTree.
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int i = 0; i < count && !found; i++) {
            if (this.tree[i] != null) {
                if (this.tree[i].equals(targetElement)) {
                    found = true;
                    temp = tree[i];
                }
            }

        }

        //Se a flag found continua a false então é porque o elemento nao existe
        //lança-se uma excepção
        if (!found) {
            throw new ElementNotFoundException("O elemento não existe na árvore.");
        }

        //Retorna-se o elemento encontrado.
        return temp;
    }

    /**
     * Método responsavél pela realização de uma travessia inorder na 
     * ArrayBinaryTree começando na sua root.
     * 
     * @return Iterador com a travessia efectuada.
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();
        inorder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Método recursivo que executa a travessia inorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     */
    protected void inorder(int node, ArrayUnorderedList<T> tempList) {
        //Se o index actual for menor que o tamano do array entramos
        //caso contrário saí do metodo
        if (node < tree.length) {

            if (tree[node] != null) {
                //Visita o filho do lado esquerdo
                inorder(node * 2 + 1, tempList);
                //Adiciona o elemento na lista
                tempList.addToRear(tree[node]);
                //Visita o filho do lado direito
                inorder((node + 1) * 2, tempList);
            }
        }

    }

    /**
     * Método responsavél pela realização de uma travessia preorder na 
     * ArrayBinaryTree começando na sua root.
     * 
     * @return Iterador com a travessia efectuada.
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        preorder(0, tmpList);

        return tmpList.iterator();
    }

    /**
     * Método recursivo que executa a travessia preorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     */
    protected void preorder(int node, ArrayUnorderedList<T> tempList) {
        //Se o index actual for menor que o tamano do array entramos
        //caso contrário saí do metodo
        if (node < tree.length) {
            //Se o node estiver a null é sinal que o anterior era uma folha
            if (tree[node] != null) {
                //Adiciona a lista o elemento
                tempList.addToRear(tree[node]);
                //Visita o filho do lado esquerdo
                preorder(node * 2 + 1, tempList);
                //Visita o filho do lado direito
                preorder((node + 1) * 2, tempList);
            }
        }
    }

    /**
     * Método responsavél pela realização de uma travessia postorder na 
     * ArrayBinaryTree começando na sua root.
     * 
     * @return Iterador com a travessia efectuada.
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tmpList = new ArrayUnorderedList<>();
        postorder(0, tmpList);

        return tmpList.iterator();
    }

    /**
     * Método recursivo que executa a travessia postorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     */
    protected void postorder(int node, ArrayUnorderedList<T> tempList) {
        //Se o index actual for menor que o tamano do array entramos
        //caso contrário saí do metodo
        if (node < tree.length) {
            //Se o elemento neste index nao estiver a null então
            if (tree[node] != null) {
                //Visita-se o filho da esquerda
                postorder(node * 2 + 1, tempList);
                //Visita-se o filho da direita
                postorder((node + 1) * 2, tempList);
                //Adiciona-se o elemento na lista
                tempList.addToRear(tree[node]);
            }
        }
    }

    /**
     * Método responsavél pela realização de uma travessia levelorder na 
     * ArrayBinaryTree começando na sua root.
     * 
     * @return Iterador com a travessia efectuada.
     *@throws EmptyCollectionException Quando a ArrayBinaryTree estiver
     * vazia.
     */
    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<>();

        levelorder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Método recursivo que executa a travessia levelorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     * @throws EmptyCollectionException Quando a ArrayBinaryTree estiver
     * vazia.
     */
    protected void levelorder(int node, ArrayUnorderedList<T> tempList) throws EmptyCollectionException {
        if (tree[node] != null) {
            //Criar a queue
            LinkedQueue<T> queue = new LinkedQueue<>();

            //Adicionar o root element a queue.
            queue.enqueue(tree[node]);

            //Enquanto a queue tiver elementos é sinal que ainda não chegamos ao fim
            while (!queue.isEmpty()) {
                //Fazer dequeu do elemento no topo da queue.
                T tmpElement = queue.dequeue();

                //Adicionar o elemento a lista temporaria.
                tempList.addToRear(tmpElement);

                //Se tiver filho na esquerda adiciona a queue
                if (tree[node * 2 + 1] != null) {
                    queue.enqueue(tree[node * 2 + 1]);
                }

                //Se tiver filho da direita adiciona a queue
                if (tree[(node + 1) * 2] != null) {
                    queue.enqueue(tree[(node + 1) * 2]);
                }

                //ir para o próximo
                node++;
            }
        }
    }

    /**
     * Método responsavél por devolver uma representação textual da 
     * ArrayBinaryTree.
     * 
     * @return String que representa uma representação textual da 
     * ArrayBinaryTree.
     */
    @Override
    public String toString() {
        ArrayUnorderedList<T> tmp = new ArrayUnorderedList<>();
        //Adiciona á Lista segundo uma Travessia em Order
        inorder(0, tmp);
        
        return tmp.toString();
    }

    
    /**
     * Método responsavél por devolver o número de elemento da ArrayBinaryTree
     * bem como a próxima posição vazia.
     * 
     * @return Número de elemento da ArrayBinaryTree bem como a próxima 
     * posição vazia.
     */
    public int getCount() {
        return count;
    }

    /**
     * Método responsavél por definir um novo número de elemento da 
     * ArrayBinaryTree bem como a próxima posição vazia.
     * 
     * @param count Novo número de elemento da ArrayBinaryTree bem como a 
     * próxima posição vazia.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Método responsavél por obter um array de genéricos que representa a 
     * ArrayBinaryTree.
     * 
     * @return Array de genéricos que representa a ArrayBinaryTree.
     */
    public T[] getTree() {
        return tree;
    }

    /**
     * Método responsavél por definir um novo array de genéricos que representa 
     * a ArrayBinaryTree.
     * 
     * @param tree novo array de genéricos que representa a ArrayBinaryTree.
     */
    public void setTree(T[] tree) {
        this.tree = tree;
    }

  

}
