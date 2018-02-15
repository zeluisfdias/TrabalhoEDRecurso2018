package estruturas_lineares;



/**
 * Classe responsavel por criar uma classe do tipo HeapNode
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class HeapNode<T> extends BinaryTreeNode<T> {
    //Referência para o Node pai deste HeapNode.
    public HeapNode<T> parent;

    /**
     * Método construtor responsavél pela criação de uma nova instância de 
     * HeapNode com um elemento especifico recebido por parâmetro.
     * 
     * @param element Elemento a ser guardado neste HeapNode.
     */
    public HeapNode(T element) {
        super(element);
        parent = null;
    }

    /**
     * Método responsavél por devolver o HeapNode pai deste HeapNode.
     * 
     * @return HeapNode pai deste HeapNode.
     */
    public HeapNode<T> getParent() {
        return parent;
    }

    /**
     * Método responsavél por definir um novo HeapNode pai para este HeapNode.
     * 
     * @param parent Novo HeapNode pai para este HeapNode.
     */
    public void setParent(HeapNode<T> parent) {
        this.parent = parent;
    }
    
    
    
}
