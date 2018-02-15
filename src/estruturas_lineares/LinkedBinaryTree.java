package estruturas_lineares;

import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import estruturas_lineares.LinkedQueue;
import estruturas_lineares.BinaryTreeNode;
import java.util.Iterator;
import excecoes.ElementNotFoundException;
import excecoes.EmptyCollectionException;
import interfacesADT.BinaryTreeADT;

/**
 * Classe responsavel por criar uma classe do tipo LinkedBinaryTree
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    //Número de Elementos na Tree
    protected int count;
    //Referência para a root da Tree.
    protected BinaryTreeNode<T> root;

    /**
     * Método responsavél pela criação de uma nova instância de LinkedBinaryTree
     * com um elemento passado por parâmetro como root da LinkedBinaryTree.
     *
     * @param element Elemento a ser root da LinkedBinaryTree.
     */
    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<>(element);
    }

    /**
     * Método responsavél pela criação de uma nova instância de LinkedBinaryTree
     * vazia.
     */
    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    /**
     * Método responsavél por devolver a root da LinkedBinaryTree.
     *
     * @return Elemento root da LinkedBinaryTree
     * @throws EmptyCollectionException Quando da LinkedBinaryTree está vazia.
     */
    public T getRoot() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Collection.");
        }

        return this.root.getElement();
    }

    /**
     * Método resposnsavél por devolver um valor booleano que indica se a
     * LinkedBinaryTree se encontra ou não vazia.
     *
     * @return Valor booleano que indica se a LinkedBinaryTree se encontra ou
     * não vazia.
     */
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Método responsavél por retornar um valor inteiro que representa o tamanho
     * da LinkedBinaryTree.
     *
     * @return Valor inteiro que representa o tamanho da LinkedBinaryTree.
     */
    @Override
    public int size() {

        if (isEmpty()) {
            return 0;
        } else {
            int result;

            //Temos de adicionar o 1 porque vamos ter do metodo o numero de
            //filhos da raiz. Mas temos de somar também a raiz como um elemento
            result = 1 + this.root.numChildren();

            return result;
        }
    }

    /**
     * Método responsavél por devolver um valor booleano que indica se um
     * Elemento passado por parâmetro se encontra ou não na LinkedBinaryTree.
     *
     * @param targetElement Elemento a ser procurado.
     * @return valor booleano que indica se um Elemento passado por parâmetro se
     * encontra ou não na LinkedBinaryTree.
     */
    @Override
    public boolean contains(T targetElement) {

        try {
            find(targetElement);
            return true;
        } catch (ElementNotFoundException ex) {
            return false;
        }
    }

    /**
     * Método responsavél por procurar se um determinado elemento passado por
     * parâmetro existe na LinkedBinaryTree.
     *
     * @param targetElement Elemento a ser procurado.
     * @return Elemento encontrado.
     * @throws ElementNotFoundException Quando o elemento não se encontra na
     * LinkedBinaryTree.
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        //Se o elemento não foi encontrado.
        if (current == null) {
            throw new ElementNotFoundException("Elemento not found.");
        }

        //Se foi retorna o elemento
        return current.getElement();
    }

    /**
     * Método recursivo responsavél por devolver um Elemento a ser procurado na
     * LinkedBinaryTree caso seja encontrado.
     *
     * @param targetElement Elemento a ser procurado.
     * @param next Node onde se começa a pesquisa
     * @return Elemento encontrado ou null caso não seja encontrado.
     */
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {

        //Se o Node for nulo retorna null
        if (next == null) {
            return null;
        }

        //Se estivermos no nó que tem o elemento que procuramos returnamos
        //esse nó
        if (next.getElement().equals(targetElement)) {
            return next;
        }

        //Recursivamente chama para o filho da esquerda
        BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());

        //Se nao encontrou na esquerda e se tiver filhos na direita, procurar
        //nos filhos da direita
        if (temp == null) {
            temp = findAgain(targetElement, next.getRight());
        }

        //Se o elemento a ser procurado existe o BinaryTreeNode<T> temp vai ter
        //o nó onde esse elemento está, caso contrário está a null
        return temp;
    }

    /**
     * Método responsavél pela realização de uma travessia inorder na
     * LinkedBinaryTree começando na sua root.
     *
     * @return Iterador com a travessia efectuada.
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        //Unorder Linked List que guarda a travessia
        DoubleLinkedUnorderedList<T> tempList = new DoubleLinkedUnorderedList<>();

        //Chama o método recursivo que vai iterar em inorder
        inorder(root, tempList);

        //Retorna um iterador da lista criada com a travessia correta
        return tempList.iterator();
    }

    /**
     * Método recursivo que executa a travessia inorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     */
    private void inorder(BinaryTreeNode<T> node, DoubleLinkedUnorderedList<T> tempList) {
        if (node != null) {
            //Visita o filho da esquerda
            inorder(node.getLeft(), tempList);
            //Guarda o Node
            tempList.addToRear(node.getElement());
            //visita o filho da direita
            inorder(node.getRight(), tempList);
        }
    }

    /**
     * Método responsavél pela realização de uma travessia preorder na
     * LinkedBinaryTree começando na sua root.
     *
     * @return Iterador com a travessia efectuada.
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        //Unorder Linked List que guarda a travessia
        DoubleLinkedUnorderedList<T> tempList = new DoubleLinkedUnorderedList<>();

        //Chama o método recursivo que vai iterar em preorder
        preorder(root, tempList);

        //Retorna um iterador da lista criada com a travessia correta
        return tempList.iterator();
    }

    /**
     * Método recursivo que executa a travessia preorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     */
    private void preorder(BinaryTreeNode<T> node, DoubleLinkedUnorderedList<T> tempList) {
        //Se for null acaba
        if (node != null) {
            //Guarda o Node
            tempList.addToRear(node.getElement());
            //Vai para o filho da esquerda
            preorder(node.getLeft(), tempList);
            //Vai para o filho da direita
            preorder(node.getRight(), tempList);
        }
    }

    /**
     * Método responsavél pela realização de uma travessia postorder na
     * LinkedBinaryTree começando na sua root.
     *
     * @return Iterador com a travessia efectuada.
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        //Unorder Linked List que guarda a travessia
        DoubleLinkedUnorderedList<T> tempList = new DoubleLinkedUnorderedList<>();

        //Chama o método recursivo que vai iterar em postorder
        postorder(root, tempList);

        //Retorna um iterador da lista criada com a travessia correta
        return tempList.iterator();
    }

    /**
     * Método recursivo que executa a travessia postorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     */
    private void postorder(BinaryTreeNode<T> node, DoubleLinkedUnorderedList<T> tempList) {
        if (node != null) {
            //Vai para o filho da esquerda
            postorder(node.getLeft(), tempList);
            //Vai para o filho da direita
            postorder(node.getRight(), tempList);
            //Guarda o node
            tempList.addToRear(node.getElement());
        }
    }

    /**
     * Método responsavél pela realização de uma travessia levelorder na
     * LinkedBinaryTree começando na sua root.
     *
     * @return Iterador com a travessia efectuada.
     * @throws excecoes.EmptyCollectionException
     */
    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        //Unorder Linked List que guarda a travessia
        DoubleLinkedUnorderedList<T> tempList = new DoubleLinkedUnorderedList<>();

        //Chama o método recursivo que vai iterar em postorder
        levelorder(root, tempList);

        //Retorna um iterador da lista criada com a travessia correta
        return tempList.iterator();
    }

    /**
     * Método recursivo que executa a travessia levelorder.
     *
     * @param node Nó onde começa a travessia
     * @param tempList Lista temporária onde vai ser guardada a travessia
     * @throws EmptyCollectionException Quando a ArrayBinaryTree estiver vazia.
     */
    private void levelorder(BinaryTreeNode<T> node, DoubleLinkedUnorderedList<T> tempList) throws EmptyCollectionException {
        if (node != null) {
            //Criar uma queue que guarda nós da arvore
            LinkedQueue<BinaryTreeNode<T>> tempQueue = new LinkedQueue<>();
            //Adiciona o nó actual a queue
            tempQueue.enqueue(node);
            //Adiciona o elemento desse nó à lista
            tempList.addToRear(node.getElement());

            //Enquanto tivermos elementos na queue, continuamos a iterar
            //Quando a queue tiver vazia é porque já não temos mais filhos
            while (!tempQueue.isEmpty()) {
                BinaryTreeNode<T> tmpNode = tempQueue.dequeue();

                if (tmpNode != null) {
                    //Se tem um filho da esquerda
                    if (tmpNode.getLeft() != null) {
                        //Guarda na lista no fim o filho
                        tempList.addToRear(tmpNode.getLeft().getElement());

                        //Faz enqueue deste filho para a Queue, porque depois 
                        //Vai voltar a fazer quando chegarmos ao while
                        tempQueue.enqueue(tmpNode.getLeft());
                    }

                    //Se tem filho na direita
                    if (tmpNode.getRight() != null) {
                        //Guarda na lista no fim o filho
                        tempList.addToRear(tmpNode.getRight().getElement());
                        //Faz enqueue para a queue do nó do filho da direita
                        tempQueue.enqueue(tmpNode.getRight());
                    }
                }
            }

        }
    }

}
