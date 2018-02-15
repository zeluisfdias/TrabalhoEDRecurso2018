package estruturas_lineares;

/**
 *
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class BinaryTreeNode<T> {
    
    //Elemento guardado neste Nó
    protected T element;
    
    //Filho a esquerda, Filho a direita
    public BinaryTreeNode<T> left, right;

    /**
     * Método responsavél por criar uma nova instância de BinaryTreeNode com
     * um elemento a ser guardado neste BinaryTreeNode passado por parâmetro.
     * 
     * @param element Elemento a ser parte da BinaryTreeNode.
     */
    public BinaryTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Método responsavél por devolver o número de filhos não nulos deste node.
     * 
     * @return Valor inteiro que representa o número de filhos não nulos deste 
     * node.
     */
    public int numChildren(){
        int children = 0;
        
        if(left != null){
            children = 1 + left.numChildren();
        }
        
        if(right != null){
            children = 1 + right.numChildren();
        }
        
        return children;
    }
    
    /**
     * Método responsavél por devolver um elemento.
     * 
     * @return Elemento.
     */
    public T getElement() {
        return element;
    }

    /**
     * Método responsavél por definir um novo elemento.
     * 
     * @param element Novo elemento.
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Método responsavél por devolver o filho à esquerda do node.
     * 
     * @return Filho à esquerda do node.
     */
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    /**
     * Método responsavél por definir um novo filho à esquerda do node.
     * 
     * @param left Novo filho à esquerda do node.
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Método responsavél por devolver o filho à direita do node.
     * 
     * @return Filho à direita do node.
     */
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    /**
     * Método responsavél por definir um novo filho à direita do node.
     * 
     * @param right Novo filho à direita do node.
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
    
}
