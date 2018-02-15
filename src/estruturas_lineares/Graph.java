package estruturas_lineares;

import estruturas_lineares.non_ordered.ArrayUnorderedList;
import estruturas_lineares.LinkedQueue;
import estruturas_lineares.LinkedListStack;
import java.util.Iterator;
import excecoes.EmptyCollectionException;
import interfacesADT.GraphADT;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class Graph<T> implements GraphADT<T>, Serializable
{
   protected final int DEFAULT_CAPACITY = 10;
   protected int numVertices;   // número de vértices no gráfico
   protected boolean[][] adjMatrix;   // matrix de adjacencias
   protected T[] vertices;   // valores dos vertices

   /**
    * Metodo construtor responsavel por criar um Graph vazio
    */
   public Graph()
   {
      numVertices = 0;
      this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
      this.vertices = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   /**
    * Metodo toString responsavel por retornar a representacao da matrix de adjacencia
    * @return 
    */
   @Override
   public String toString()
   {
      if (numVertices == 0)
         return "Graph is empty";

      String result = new String("");

      result += "Adjacency Matrix\n";
      result += "----------------\n";
      result += "index\t";

      for (int i = 0; i < numVertices; i++) 
      {
         result += "" + i;
         if (i < 10)
            result += " ";
      }
      result += "\n\n";

      for (int i = 0; i < numVertices; i++)
      {
         result += "" + i + "\t";
      
         for (int j = 0; j < numVertices; j++)
         {
            if (adjMatrix[i][j])
               result += "1 ";
            else
               result += "0 ";
         }
         result += "\n";
      }

      result += "\n\nVertex Values";
      result += "\n-------------\n";
      result += "index\tvalue\n\n";

      for (int i = 0; i < numVertices; i++)
      {
         result += "" + i + "\t";
         result += vertices[i].toString() + "\n";
      }
      result += "\n";
      return result;
   }

   /**
    * Metodo responsavel por inserir um nó entre dois vertices do graph
    * @param index1
    * @param index2 
    */
   public void addEdge (int index1, int index2)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = true;
         adjMatrix[index2][index1] = true;
      }
   }

   /**
    * Metodo responsavel por remover um nó entre dois vertices do graph
    * @param index1
    * @param index2 
    */
   public void removeEdge (int index1, int index2)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = false;
         adjMatrix[index2][index1] = false;
      }
   }

   /**
    * Metodo responsavel por inserir um nó entre dois vertices do graph
    * @param vertex1
    * @param vertex2 
    */
   @Override
   public void addEdge (T vertex1, T vertex2)
   {
      addEdge (getIndex(vertex1), getIndex(vertex2));
   }

   /**
    * Metodo responsavel por remover um nó entre dois vertices do graph
    * @param vertex1
    * @param vertex2 
    */
   @Override
   public void removeEdge (T vertex1, T vertex2)
   {
      removeEdge (getIndex(vertex1), getIndex(vertex2));
   }

  /**
   * Metodo responsavel por adicionar um vértice ao graph, expandindo a sua 
   * capacidade do graph, se for necessário.
   */
   public void addVertex ()
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = null;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = false;
         adjMatrix[i][numVertices] = false;
      }      
      numVertices++;
   }

   /**
    * Metodo responsabel por adicionar um vértice ao graph, expandindo a sua capacidade
    * se for necessário. Também associa um object ao vértice.
    * @param vertex 
    */
   @Override
   public void addVertex (T vertex)
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = vertex;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = false;
         adjMatrix[i][numVertices] = false;
      }      
      numVertices++;
   }

  /**
   * Remove um vértice num índice dado do graph
   * @param index 
   */
   public void removeVertex (int index)
   {
      if (indexIsValid(index))
      {
         numVertices--;

         for (int i = index; i < numVertices; i++)
            vertices[i] = vertices[i+1];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j <= numVertices; j++)
               adjMatrix[i][j] = adjMatrix[i+1][j];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               adjMatrix[j][i] = adjMatrix[j][i+1];
      }
   }

   /**
    * Remove um vértice num índice dado do graph
    * @param vertex 
    */
   @Override
   public void removeVertex (T vertex)
   {
      for (int i = 0; i < numVertices; i++)
      {
         if (vertex.equals(vertices[i]))
         {
            removeVertex(i);
            return;
         }
      }
   }

   /**
    * retorna o iteratorDFS a partir do índice dado.
    * @param startIndex
    * @return
    * @throws EmptyCollectionException 
    */
   public Iterator<T> iteratorDFS(int startIndex) throws EmptyCollectionException
   {
      Integer x;
      boolean found;
      LinkedListStack<Integer> traversalStack = new LinkedListStack<Integer>();
      ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
      boolean[] visited = new boolean[numVertices];

      if (!indexIsValid(startIndex))
         return resultList.iterator();

      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      traversalStack.push(new Integer(startIndex));
      resultList.addToRear(vertices[startIndex]);
      visited[startIndex] = true;
      
      while (!traversalStack.isEmpty())
      {
         x = traversalStack.peek();
         found = false;

        for (int i = 0; (i < numVertices) && !found; i++)
         {
            if (adjMatrix[x.intValue()][i] && !visited[i])
            {
               traversalStack.push(new Integer(i));
               resultList.addToRear(vertices[i]);
               visited[i] = true;
               found = true;
            }
         }
         if (!found && !traversalStack.isEmpty())
            traversalStack.pop();
      }
      return resultList.iterator();
   }

  /**
   * retorna o iteratorDFS a partir do índice dado.
   * @param startVertex
   * @return 
   */
   @Override
   public Iterator<T> iteratorDFS(T startVertex)
   {      
       try {
           return iteratorDFS(getIndex(startVertex));
       } catch (EmptyCollectionException ex) {
           Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }

  /**
   * retorna o iteratorBFS a partir do índice dado.
   * @param startIndex
   * @return
   * @throws EmptyCollectionException 
   */
   public Iterator<T> iteratorBFS(int startIndex) throws EmptyCollectionException
   {
      Integer x;
      LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
      ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();

      if (!indexIsValid(startIndex))
         return resultList.iterator();

      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      traversalQueue.enqueue(new Integer(startIndex));
      visited[startIndex] = true;
      
      while (!traversalQueue.isEmpty())
      {
         x = traversalQueue.dequeue();
         resultList.addToRear(vertices[x.intValue()]);

         for (int i = 0; i < numVertices; i++)
         {
            if (adjMatrix[x.intValue()][i] && !visited[i])
            {
               traversalQueue.enqueue(new Integer(i));
               visited[i] = true;
            }
         }
      }
      return resultList.iterator();
   }

   /**
    * retorna o iteratorBFS a partir do índice dado.
    * @param startVertex
    * @return 
    */
   @Override
   public Iterator<T> iteratorBFS(T startVertex)
   {      
       try {
           return iteratorBFS(getIndex(startVertex));
       } catch (EmptyCollectionException ex) {
           Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }

   /**
    * Retorna um iterador que contém os índices dos vértices que estão no caminho mais curto entre os dois vértices dados.
    * @param startIndex
    * @param targetIndex
    * @return
    * @throws EmptyCollectionException 
    */
   protected Iterator<Integer> iteratorShortestPathIndices
                              (int startIndex, int targetIndex) throws EmptyCollectionException
   {
      int index = startIndex;
      int[] pathLength = new int[numVertices];
      int[] predecessor = new int[numVertices];
      LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
      ArrayUnorderedList<Integer> resultList = 
                                  new ArrayUnorderedList<Integer>();

      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || 
                                       (startIndex == targetIndex))
         return resultList.iterator();

      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      traversalQueue.enqueue(new Integer(startIndex));
      visited[startIndex] = true;
      pathLength[startIndex] = 0;
      predecessor[startIndex] = -1;

      while (!traversalQueue.isEmpty() && (index != targetIndex))
      {
         index = (traversalQueue.dequeue()).intValue();

        
        for (int i = 0; i < numVertices; i++)
         {
            if (adjMatrix[index][i] && !visited[i])
            {
               pathLength[i] = pathLength[index] + 1;
               predecessor[i] = index;
               traversalQueue.enqueue(new Integer(i));
               visited[i] = true;
            }
         }
      }
      if (index != targetIndex)  // no path must have been found
         return resultList.iterator();

      LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
      index = targetIndex;
      stack.push(new Integer(index));
      do
      {
         index = predecessor[index];
         stack.push(new Integer(index));
      } while (index != startIndex);
      
      while (!stack.isEmpty())
         resultList.addToRear(((Integer)stack.pop()));

      return resultList.iterator();
   }

   /**
    * retorna um iterador com o caminho mais curto entre dois vertices
    * @param startIndex
    * @param targetIndex
    * @return
    * @throws EmptyCollectionException 
    */
   public Iterator<T> iteratorShortestPath(int startIndex, 
                                           int targetIndex) throws EmptyCollectionException
   {
      ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
         return resultList.iterator();

      Iterator<Integer> it = iteratorShortestPathIndices(startIndex, 
                             targetIndex);      
      while (it.hasNext())
         resultList.addToRear(vertices[((Integer)it.next()).intValue()]);
      return resultList.iterator();
   }

   /**
    * retorna um iterador com o caminho mais curto entre dois vertices
    * @param startVertex
    * @param targetVertex
    * @return 
    */
   @Override
   public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex)
   {
       try {
           return iteratorShortestPath(getIndex(startVertex),
                   getIndex(targetVertex));
       } catch (EmptyCollectionException ex) {
           Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }

   /**
    * Retorna o comprimento do menor caminho na network. Retorna true se o caminho não for encontrado.
    * @param startIndex
    * @param targetIndex
    * @return
    * @throws EmptyCollectionException 
    */
   public int shortestPathLength(int startIndex, int targetIndex) throws EmptyCollectionException
   {
      int result = 0;
      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
         return 0;

      int index1, index2;
      Iterator<Integer> it = iteratorShortestPathIndices(startIndex, 
                             targetIndex);

      if (it.hasNext())
         index1 = ((Integer)it.next()).intValue();
      else
         return 0;

      while (it.hasNext())
      {
         result++;
         it.next();
      }
      
      return result;
   }

   /**
    * Retorna o comprimento do menor caminho na network. Retorna true se o caminho não for encontrado.
    * @param startVertex
    * @param targetVertex
    * @return
    * @throws EmptyCollectionException 
    */
   public int shortestPathLength(T startVertex, T targetVertex) throws EmptyCollectionException
   {
      return shortestPathLength(getIndex(startVertex), getIndex(
                                                       targetVertex));
   }

   /**
    * retorna a minimum spanning tree do graph
    * @return
    * @throws EmptyCollectionException 
    */
   public Graph getMST() throws EmptyCollectionException
   {
      int x, y;
      int[] edge = new int[2];
      LinkedListStack<int[]> vertexStack = new LinkedListStack<int[]>();
      Graph<T> resultGraph = new Graph<T>();

      if (isEmpty() || !isConnected())
         return resultGraph;
      
      resultGraph.adjMatrix = new boolean[numVertices][numVertices];
      
      for (int i = 0; i < numVertices; i++)
         for (int j = 0; j < numVertices; j++)
            resultGraph.adjMatrix[i][j] = false;
            
      resultGraph.vertices = (T[])(new Object[numVertices]);
      boolean[] visited = new boolean[numVertices];
      
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;      
      
      edge[0] = 0;
      resultGraph.vertices[0] = this.vertices[0];
      resultGraph.numVertices++;
      visited[0] = true;

      
      for (int i = 0; i < numVertices; i++)
      {
         if (!visited[i] && this.adjMatrix[0][i])
         {
            edge[1] = i;
            vertexStack.push(edge.clone());
            visited[i] = true;
         }
      }

      while ((resultGraph.size() < this.size()) && !vertexStack.isEmpty())
      {
         
         edge = vertexStack.pop();
         x = edge[0];
         y = edge[1];
         resultGraph.vertices[y] = this.vertices[y];
         resultGraph.numVertices++;
         resultGraph.adjMatrix[x][y] = true;
         resultGraph.adjMatrix[y][x] = true;
         visited[y] = true;

        
         for (int i = 0; i < numVertices; i++)
         {
            if (!visited[i] && this.adjMatrix[i][y])
            {
               edge[0] = y;
               edge[1] = i;
               vertexStack.push(edge.clone());
               visited[i] = true;
            }
         }
      }

      return resultGraph;
   }

   /**
    * Cria novos arrays para armazenar o conteúdo do graph, multiplicando a capacidade por 2
    */
   protected void expandCapacity()
   {
      T[] largerVertices = (T[])(new Object[vertices.length*2]);
      boolean[][] largerAdjMatrix = 
            new boolean[vertices.length*2][vertices.length*2];

      for (int i = 0; i < numVertices; i++)
      {
         for (int j = 0; j < numVertices; j++)
         {
            largerAdjMatrix[i][j] = adjMatrix[i][j];
         }
         largerVertices[i] = vertices[i];
      }

      vertices = largerVertices;
      adjMatrix = largerAdjMatrix;
   }

   /**
    * retorna o numero de vertices do graph
    * @return 
    */
   @Override
   public int size()
   {
      return numVertices;
   }

   /**
    * retorna TRUE se o graph tiver vazio e FALSE caso contrario
    * @return 
    */
   @Override
   public boolean isEmpty()
   {
      return (numVertices == 0);
   }

   /**
    * retorna TRUE se o graph tiver connectado e FALSE caso contrario
    * @return 
    */
   @Override
   public boolean isConnected()
   {
      if (isEmpty())
         return false;
      
      Iterator<T> it = null;
       try {
           it = iteratorBFS(0);
       } catch (EmptyCollectionException ex) {
           Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
       }
      int count = 0;

      while (it.hasNext())
      {
         it.next();
         count++;
      }
      return (count == numVertices);
   }

   /**
    * Retorna o valor do índice da primeira ocorrência do vértice.
    * Retorna -1 se a key não for encontrada.
    * @param vertex
    * @return 
    */
   public int getIndex(T vertex)
   {
      for (int i = 0; i < numVertices; i++)
         if (vertices[i].equals(vertex))
            return i;
      return -1;
   }

   /**
    * retorna TRUE se o index for valido
    * @param index
    * @return 
    */
   protected boolean indexIsValid(int index)
   {
      return ((index < numVertices) && (index >= 0));
   }

   /***
    * retorna a copia do vertices do array
    * @return 
    */
   public Object[] getVertices()
   {
      Object[] vertices = new Object[numVertices];
      Object vertex;
      
      for (int i = 0; i < numVertices; i++)
      {
         vertex = this.vertices[i];
         vertices[i] = vertex;
      }
      return vertices;
   }
}
