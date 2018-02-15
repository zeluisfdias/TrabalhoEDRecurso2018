/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas_lineares;

/**
 *
 * @author Fábio Rêgo
 */
import excecoes.EmptyCollectionException;
import interfacesADT.HeapADT;


public class Heap<T> extends LinkedBinaryTree<T> implements HeapADT<T> 
{
   public HeapNode<T> lastNode;  

  /**
   * Criação de um construtor vazio
   */
   public Heap() 
   {
      super();
   }

   /**
    * Adiciona o elemento à heap na posição apropriada de acordo com seu valor key
    * elementos iguais são adicionados à direita
    * @param obj 
    */
   @Override
   public void addElement (T obj) 
   {
      HeapNode<T> node = new HeapNode<T>(obj);

      if (root == null)
         root=node;
      else
      {
         HeapNode<T> next_parent = getNextParentAdd(); 
         if (next_parent.left == null)
            next_parent.left = node;
         else
            next_parent.right = node;
         node.parent = next_parent;
      }
      lastNode = node;
      count++;
      if (count>1)
         heapifyAdd();
   }

   /**
    * retorna o nó que será o pai do novo nó
    * @return 
    */
   private HeapNode<T> getNextParentAdd()
   {
      HeapNode<T> result = lastNode;
      while ((result != root) && (result.parent.left != result))
         result = result.parent;

      if (result != root)
         if (result.parent.right == null)
            result = result.parent;
         else
         {
            result = (HeapNode<T>)result.parent.right;
            while (result.left != null)
               result = (HeapNode<T>)result.left;
         }
      else
         while (result.left != null)
            result = (HeapNode<T>)result.left;
        
      return result;
   }
   
   /**
    * reordena a heap depois de adicionar um elemento
    */
   private void heapifyAdd()
   {
      T temp;
      HeapNode<T> next = lastNode;
      
      while ((next != root) && (((Comparable)
              next.element).compareTo(next.parent.element) < 0))
      {
         temp = next.element;
         next.element = next.parent.element;
         next.parent.element = temp;
         next = next.parent;
      }
   }
   
   /**
    * remove o elemento com valor mais baixo na heap e retorna a sua referencia
    * @return
    * @throws EmptyCollectionException se a heap estiver vazia
    */
   @Override
   public T removeMin() throws EmptyCollectionException 
   {
      if (isEmpty())
         throw new EmptyCollectionException ("Empty Heap");

      T minElement =  root.element;

      if (count == 1)
      {
         root = null;
         lastNode = null;
      }
      else
      {
         HeapNode<T> next_last = getNewLastNode();
         if (lastNode.parent.left == lastNode)
            lastNode.parent.left = null;
         else
            lastNode.parent.right = null;

         root.element = lastNode.element;
         lastNode = next_last;
         heapifyRemove();
      }

      count--;
      return minElement;
   }
   
   /**
    * reordena a heap depois de remover um elemento
    */
   private void heapifyRemove()
   {
      T temp;
      HeapNode<T> node = (HeapNode<T>)root;
      HeapNode<T> left = (HeapNode<T>)node.left;
      HeapNode<T> right = (HeapNode<T>)node.right;
      HeapNode<T> next;
      
      if ((left == null) && (right == null))
         next = null;
      else if (left == null)
         next = right;
      else if (right == null)
         next = left;
      else if (((Comparable)left.element).compareTo(right.element) < 0)
         next = left;
      else
         next = right;

      while ((next != null) && (((Comparable)
              next.element).compareTo(node.element) < 0))
      {
         temp = node.element;
         node.element = next.element;
         next.element = temp;
         node = next;
         left = (HeapNode<T>)node.left;
         right = (HeapNode<T>)node.right;
         if ((left == null) && (right == null))
            next = null;
         else if (left == null)
            next = right;
         else if (right == null)
            next = left;
         else if (((Comparable)left.element).compareTo
                   (right.element) < 0)
            next = left;
         else
            next = right;
      }
   }

   /**
    * Retorna o nó que será o último nó após uma remoção.
    * @return 
    */
   private HeapNode<T> getNewLastNode()
   {
      HeapNode<T> result = lastNode;
      
      while ((result != root) && (result.parent.left == result))
         result = result.parent;
      
      if (result != root)
         result = (HeapNode<T>)result.parent.left;

      while (result.right != null)
         result = (HeapNode<T>)result.right;

      return result;
   }
   
   /**
    * retorna o elemento com o valor mais baixo na heap
    * @return
    * @throws EmptyCollectionException se a heap estiver vazia
    */
   public T findMin () throws EmptyCollectionException
   {
      if (isEmpty())
         throw new EmptyCollectionException ("Empty Heap");

      return root.element;
   }

   /**
    * metodo responsavel por remover todos os elementos da heap
    */
    void removeAllElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
