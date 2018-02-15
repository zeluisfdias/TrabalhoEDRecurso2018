package estruturas_lineares;

import excecoes.EmptyCollectionException;
import interfacesADT.HeapADT;



/**
 *
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {

    /**
     * Método responsavél pela criação de uma nova instância de ArrayHeap vazia.
     */
    public ArrayHeap() {
        super();
    }

    /**
     * Método responsavél pela criação de uma nova instância de ArrayHeap com
     * um elemento a ser root da ArrayHeap passado por parâmetro.
     * 
     * @param element Elemento a ser root da ArrayHeap.
     */
    public ArrayHeap(T element) {
        super(element);
    }

  
    /**
     * Método responsavél por adicionar o elemento recebido por parâmetro
     * na posição apropriada na ArrayHeap de acordo com o seu valor. Elementos
     * iguais são adicionados do lado direito.
     * 
     * @param obj Elemento a ser adicionado a ArrayHeap.
     */
    @Override
    public void addElement(T obj) {

        //Se atingimos o tamanho máximo do array, expandimos a capacidade
        if (super.count == super.tree.length) {
            expandCapacity();
        }

        super.tree[super.count] = obj;
        super.count++;

        //Se tivermos mais do que um elemento na heap precisamos de ordenar
        //a heap para manter a sua ordem.
        if (super.count > 1) {
            heapifyAdd();
        }
    }

    /**
     * Método responsavél por reordenar a ArrayHeap e manter a sua integridade
     * após a adição de um node.
     */
    public void heapifyAdd() {
        T temp;

        //Como o count aponta sempre para a próxima posição livre, então
        //o último elemento a ser adicionado está na posição count-1
        int next = super.count - 1;

        temp = super.tree[next];

        //Se o elemento na posição actual for menor que o seu pai
        //Então este toma o lugar do pai e o pai passa para o lugar do filho
        while ((next != 0) && (((Comparable) temp).compareTo(tree[(next - 1) / 2]) < 0)) {
            tree[next] = tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }

        tree[next] = temp;
    }

   
    /**
     * Método responsavél por remover e devolver o elemento com menor valor da 
     * ArrayHeap.
     * 
     * @return Elemento com menor valor da ArrayHeap.
     * @throws EmptyCollectionException Quando a ArrayHeap está vazia.
     */
    @Override
    public T removeMin() throws EmptyCollectionException {

        if (super.isEmpty()) {
            throw new EmptyCollectionException("Heap está vazia.");
        }

        //O menor elemento encontra-se sempre na raiz por ser uma minHeap,
        //se fosse maxHeap seria o maior valor a estar na raiz
        T minElement = tree[0];

        //Elemento raiz fica com o Elemento da folha mais a direita da heap
        //ou seja com o maior elemento.
        tree[0] = tree[super.count - 1];

        //Como a folha mais a direita está na raiz agora temos de por o seu valor a 
        //null, senao estariamos a repetir
        tree[super.count-1] = null;
        
        //Reordenar a heap
        heapifyRemove();
        super.count--;

        return minElement;
    }

    /**
     * Método responsavél por reordenar a ArrayHeap e manter a sua integridade
     * após a remoção de um node.
     */
    public void heapifyRemove() {
        T temp;

        //Nó raiz
        int node = 0;
        //Nó Filho Esquerda
        int left = 1;
        //Nó Filho Direita
        int rigth = 2;

        //Proximo elemento a verificar
        int next;

        //Se não tiver filhos, avançamos para o fim da heap
        if ((super.tree[left] == null) && (super.tree[rigth] == null)) {
            next = count;
        } else //Se não tiver filhos a esquerda avançamos para o filho direita
        if (super.tree[left] == null) {
            next = rigth;
        } else //Se não tiver filhos a direita avançamos para o filho esquerda
        if (super.tree[rigth] == null) {
            next = left;
        } else //Se o filho esquerda for menor que o filho direita vamos esquerda
        //senão para a direita
        if (((Comparable) super.tree[left]).compareTo(super.tree[rigth]) < 0) {
            next = left;
        } else {
            next = rigth;
        }

        temp = tree[node];

        //Enquanto não chegarmos ao fim da heap e o próximo elemento for menor que
        //o elemento no guardado na raiz temos de realizar a troca
        while ((next < super.count) && (((Comparable) super.tree[next]).compareTo(temp) < 0)) {

            //Raiz toma o valor do elemento no next
            super.tree[node] = super.tree[next];
            //Avança para o next
            node = next;
            //Filho Esquerda
            left = 2 * node + 1;
            //Filho Direita
            rigth = 2 * (node + 1);

            //Se não tiver filhos, avançamos para o fim da heap
            if ((super.tree[left] == null) && (super.tree[rigth] == null)) {
                next = count;
            } else //Se não tiver filhos a esquerda avançamos para o filho direita
            if (super.tree[left] == null) {
                next = rigth;
            } else //Se não tiver filhos a direita avançamos para o filho esquerda
            if (super.tree[rigth] == null) {
                next = left;
            } else //Se o filho esquerda for menor que o filho direita vamos esquerda
            //senão para a direita
            if (((Comparable) super.tree[left]).compareTo(super.tree[rigth]) < 0) {
                next = left;
            } else {
                next = rigth;
            }
        }

        tree[node] = temp;
        
    }

    /**
     * Método responsavél por encontrar e devolver o elemento com menor valor 
     * da ArrayHeap.
     * 
     * @return Elemento com menor valor da ArrayHeap.
     * @throws EmptyCollectionException Quando a ArrayHeap está vazia.
     */
    @Override
    public T findMin() throws EmptyCollectionException{
    
        if(super.isEmpty()){
            throw new EmptyCollectionException("Heap está vazia");
        }
        
        return super.tree[0];
    }

}
