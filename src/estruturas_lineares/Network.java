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
import estruturas_lineares.non_ordered.ArrayUnorderedList;
import excecoes.*;
import interfacesADT.NetworkADT;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Network<T>  extends Graph<T> implements NetworkADT<T>
{
   private double[][] adjMatrix;    // adjacency matrix

   /**
    * Criacao de uma NetWork vazia
    */
   public Network()
   {
      numVertices = 0;
      this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
      this.vertices = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   /**
    * Retorna a representação grafica da matriz de adjacencias
    * @return 
    */
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
            if (adjMatrix[i][j] < Double.POSITIVE_INFINITY)
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

      
      result += "\n\nWeights of Edges";
      result += "\n----------------\n";
      result += "index\tweight\n\n";

      for (int i = 0; i < numVertices; i++)
      {
         for (int j = numVertices-1; j > i; j--)
         {
            if (adjMatrix[i][j] < Double.POSITIVE_INFINITY)
            {
               result += i + " to " + j + "\t";
               result += adjMatrix[i][j] + "\n";
            }
         }
      }

      result += "\n";
      return result;
   }

   /**
    * metodo responsavel por inserir um nó entre dois vertices de um graph
    * @param index1
    * @param index2
    * @param weight 
    */
   public void addEdge (int index1, int index2, double weight)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = weight;
         adjMatrix[index2][index1] = weight;
      }
   }

   /**
    * metodo responsavel por remover um nó entre dois vertices de um graph
    * @param index1
    * @param index2 
    */
   @Override
   public void removeEdge (int index1, int index2)
   {
      if (indexIsValid(index1) && indexIsValid(index2))
      {
         adjMatrix[index1][index2] = Double.POSITIVE_INFINITY;
         adjMatrix[index2][index1] = Double.POSITIVE_INFINITY;
      }
   }

   /**
    * metodo responsavel por inserir um nó entre dois vertices de um graph
    * @param vertex1
    * @param vertex2
    * @param weight 
    */
   @Override
   public void addEdge (T vertex1, T vertex2, double weight)
   {
      addEdge (getIndex(vertex1), getIndex(vertex2), weight);
   }

   /**
    * metodo responsavel por inserir um nó entre dois vertices de um graph. Assumindo o weight a 0
    * @param vertex1
    * @param vertex2 
    */
   @Override
   public void addEdge (T vertex1, T vertex2)
   {
      addEdge (getIndex(vertex1), getIndex(vertex2), 0);
   }

   /**
    * metodo responsavel por remover um nó entre dois vertices de um graph
    * @param vertex1
    * @param vertex2 
    */
   @Override
   public void removeEdge (T vertex1, T vertex2)
   {
      removeEdge (getIndex(vertex1), getIndex(vertex2));
   }

   /**
    * metodo responsavel por adicionar um nó ao graph. Expandindo a sua capacidade se necessario
    */
   public void addVertex ()
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = null;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = Double.POSITIVE_INFINITY;
         adjMatrix[i][numVertices] = Double.POSITIVE_INFINITY;
      }      
      numVertices++;
   }

   /**
    * metodo responsavel por adicionar um nó ao graph. Expandindo a sua capacidade se necessario
    * @param vertex 
    */
   public void addVertex (T vertex)
   {
      if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = vertex;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = Double.POSITIVE_INFINITY;
         adjMatrix[i][numVertices] = Double.POSITIVE_INFINITY;
      }      
      numVertices++;
   }

   /**
    * metodo responsavel por remover um nó de uma dado index do graph.
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
    *  metodo responsavel por remover um simples nó do graph.
    * @param vertex 
    */
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
    *  metodo responsavel por retornar o iteratorDFS dado um determinado nó do graph.
    * @param startIndex
    * @return
    * @throws EmptyCollectionException 
    */
   @Override
   public Iterator<T> iteratorDFS(int startIndex) throws EmptyCollectionException
   {
      Integer x;
      boolean found;
      LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
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
            if((adjMatrix[x.intValue()][i] < Double.POSITIVE_INFINITY)
               && !visited[i])
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
    * metodo responsavel por retornar o iteratorDFS dado um determinado nó do graph.
    * @param startVertex
    * @return 
    */
   @Override
   public Iterator<T> iteratorDFS(T startVertex)
   {      
       try {
           return iteratorDFS(getIndex(startVertex));
       } catch (EmptyCollectionException ex) {
           Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }

   /**
    * metodo responsavel por retornar o iteratorBFS dado um determinado nó do graph.
    * @param startIndex
    * @return
    * @throws EmptyCollectionException 
    */
   @Override
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
            if((adjMatrix[x.intValue()][i] < Double.POSITIVE_INFINITY)
               && !visited[i])
            {
               traversalQueue.enqueue(new Integer(i));
               visited[i] = true;
            }
         }
      }
      return resultList.iterator();
   }

   /**
    * metodo responsavel por retornar o iteratorBFS dado um determinado nó do graph.
    * @param startVertex
    * @return 
    */
   @Override
   public Iterator<T> iteratorBFS(T startVertex)
   {      
       try {
           return iteratorBFS(getIndex(startVertex));
       } catch (EmptyCollectionException ex) {
           Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
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
   @Override
   protected Iterator<Integer> iteratorShortestPathIndices
                              (int startIndex, int targetIndex) throws EmptyCollectionException
   {
      int index;
      double weight;
      int[] predecessor = new int[numVertices];
      Heap<Double> traversalMinHeap = new Heap<Double>();
      ArrayUnorderedList<Integer> resultList = 
                                  new ArrayUnorderedList<Integer>();
      LinkedStack<Integer> stack = new LinkedStack<Integer>();

      int[] pathIndex = new int[numVertices];
      double[] pathWeight = new double[numVertices];
      for (int i = 0; i < numVertices; i++)
         pathWeight[i] = Double.POSITIVE_INFINITY;

      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;

      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || 
                       (startIndex == targetIndex) || isEmpty())
         return resultList.iterator();

      pathWeight[startIndex] = 0;
      predecessor[startIndex] = -1;      
      visited[startIndex] = true;
      weight = 0;

     
      for (int i = 0; i < numVertices; i++)
      {
         if (!visited[i])
         {
            pathWeight[i] = pathWeight[startIndex] + 
                            adjMatrix[startIndex][i];
            predecessor[i] = startIndex;
            traversalMinHeap.addElement(new Double(pathWeight[i]));
         }
      }

      do 
      {
         weight = (traversalMinHeap.removeMin()).doubleValue();
         traversalMinHeap.removeAllElements();
         if (weight == Double.POSITIVE_INFINITY)  // no possible path
            return resultList.iterator();
         else 
         {
            index = getIndexOfAdjVertexWithWeightOf(visited, pathWeight, 
                                                    weight);
            visited[index] = true;
         }

         for (int i = 0; i < numVertices; i++)
         {
            if (!visited[i])
            {
               if((adjMatrix[index][i] < Double.POSITIVE_INFINITY) && 
                  (pathWeight[index] + adjMatrix[index][i]) < pathWeight[i])
               {
                  pathWeight[i] = pathWeight[index] + adjMatrix[index][i];
                  predecessor[i] = index;
               }        
               traversalMinHeap.addElement(new Double(pathWeight[i]));
            }
         }
      } while (!traversalMinHeap.isEmpty() && !visited[targetIndex]);

      index = targetIndex;
      stack.push(new Integer(index));
      do
      {
         index = predecessor[index];
         stack.push(new Integer(index));
      } while (index != startIndex);
      
      while (!stack.isEmpty())
         resultList.addToRear((stack.pop()));

      return resultList.iterator();
   }

   /**
    * Retorna o índice do vértice que é adjacente ao vértice com o índice dado
    * também possui um caminho igual ao peso.
    * @param visited
    * @param pathWeight
    * @param weight
    * @return 
    */
   protected int getIndexOfAdjVertexWithWeightOf(boolean[] visited, 
                 double[] pathWeight, double weight)
   {
      for (int i = 0; i < numVertices; i++)
         if ((pathWeight[i] == weight) && !visited[i])
            for (int j = 0; j < numVertices; j++)
               if ((adjMatrix[i][j] < Double.POSITIVE_INFINITY) && 
                    visited[j])
                  return i;

      return -1;  // should never get to here
   }

   /**
    * retorna um iterador com o caminho mais curto entre dois vertices
    * @param startIndex
    * @param targetIndex
    * @return
    * @throws EmptyCollectionException 
    */
   @Override
   public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex) throws EmptyCollectionException
   {
      ArrayUnorderedList templist = new ArrayUnorderedList();
      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
         return templist.iterator();

      Iterator<Integer> it = iteratorShortestPathIndices(startIndex, 
                             targetIndex);      
      while (it.hasNext())
         templist.addToRear(vertices[(it.next()).intValue()]);
      return templist.iterator();
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
           Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }

   /**
    * Retorna o peso do menor caminho na network. Retorna POSITIVE_INFINITY se o caminho não for encontrado.
    * @param startIndex
    * @param targetIndex
    * @return
    * @throws EmptyCollectionException 
    */
   public double shortestPathWeight(int startIndex, int targetIndex) throws EmptyCollectionException
   {
      double result = 0;
      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
         return Double.POSITIVE_INFINITY;

      int index1, index2;
      Iterator<Integer> it = iteratorShortestPathIndices(startIndex,
                             targetIndex);

      if (it.hasNext())
         index1 = ((Integer)it.next()).intValue();
      else
         return Double.POSITIVE_INFINITY;

      while (it.hasNext())
      {
         index2 = (it.next()).intValue();
         result += adjMatrix[index1][index2];
         index1 = index2;
      }
      
      return result;
   }

   /**
    * Retorna o peso do menor caminho na network. Retorna POSITIVE_INFINITY se o caminho não for encontrado.
    * @param startVertex
    * @param targetVertex
    * @return 
    */
   @Override
   public double shortestPathWeight(T startVertex, T targetVertex)
   {
       try {
           return shortestPathWeight(getIndex(startVertex),
                   getIndex(targetVertex));
       } catch (EmptyCollectionException ex) {
           Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
       }
       return 0;
   }

   /**
    * retorna a minimum spanning tree da Network
    * @return
    * @throws EmptyCollectionException 
    */
   public Network mstNetwork() throws EmptyCollectionException
   {
      int x, y;
      int index;
      double weight;
      int[] edge = new int[2];
      Heap<Double> minHeap = new Heap<Double>();
      Network<T> resultGraph = new Network<T>();

      if (isEmpty() || !isConnected())
         return resultGraph;

      resultGraph.adjMatrix = new double[numVertices][numVertices];
      for (int i = 0; i < numVertices; i++)
         for (int j = 0; j < numVertices; j++)
            resultGraph.adjMatrix[i][j] = Double.POSITIVE_INFINITY;
      resultGraph.vertices = (T[])(new Object[numVertices]);      
      
      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      edge[0] = 0;
      resultGraph.vertices[0] = this.vertices[0];
      resultGraph.numVertices++;
      visited[0] = true;

      
      for (int i = 0; i < numVertices; i++)
            minHeap.addElement(new Double(adjMatrix[0][i]));

      while ((resultGraph.size() < this.size()) && !minHeap.isEmpty())
      {
        
         do
         {
            weight = (minHeap.removeMin()).doubleValue();
            edge = getEdgeWithWeightOf(weight, visited);
         } while (!indexIsValid(edge[0]) || !indexIsValid(edge[1]));

         x = edge[0];
         y = edge[1];
         if (!visited[x])
            index = x;
         else 
            index = y;

         
         resultGraph.vertices[index] = this.vertices[index];
         visited[index] = true;
         resultGraph.numVertices++;

         resultGraph.adjMatrix[x][y] = this.adjMatrix[x][y];
         resultGraph.adjMatrix[y][x] = this.adjMatrix[y][x];

         
         for (int i = 0; i < numVertices; i++)
         {
            if (!visited[i] && (this.adjMatrix[i][index] < 
                                Double.POSITIVE_INFINITY))
            {
               edge[0] = index;
               edge[1] = i;
               minHeap.addElement(new Double(adjMatrix[index][i]));
            }
         }
      }
      return resultGraph;
   }

   /**
    * Retorna um nó com o peso especificado. pelos menos um dos vértice tem de ser visitado.
    * @param weight
    * @param visited
    * @return 
    */
   protected int[] getEdgeWithWeightOf(double weight, boolean[] visited)
   {
      int[] edge = new int[2];
      for (int i = 0; i < numVertices; i++)
         for (int j = 0; j < numVertices; j++)
            if ((adjMatrix[i][j] == weight) && (visited[i] ^ visited[j]))
            {
               edge[0] = i;
               edge[1] = j;
               return edge;
            }

      /** Will only get to here if a valid edge is not found */
      edge[0] = -1;
      edge[1] = -1;
      return edge;
   }

   /**
    * Cria novos arrays para armazenar o conteúdo do graph, multiplicando a capacidade por 2
    */
   protected void expandCapacity()
   {
      T[] largerVertices = (T[])(new Object[vertices.length*2]);
      double[][] largerAdjMatrix = 
         new double[vertices.length*2][vertices.length*2];

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
}