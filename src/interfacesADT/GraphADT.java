/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesADT;

import excecoes.ElementNotFoundException;
import java.util.Iterator;

/**
 * Metodo Responsavel por definir a Interface GraphADT
 * @author Fábio Rêgo
 * @param <T>
 */


public interface GraphADT<T>
{
   /** 
    * Adiciona um vértice ao graph, associando o objeto ao vértice.
     * @param vertex 
     */
   public void addVertex (T vertex);

    /**
     * Remove um vértice com o valor fornecido a partir do graph.
     * @param vertex
     * @throws excecoes.ElementNotFoundException 
     */
   public void removeVertex (T vertex) throws ElementNotFoundException;

   /** Insere um nó entre dois vértices do graph.
     * @param vertex1
     * @param vertex2
     * @throws excecoes.ElementNotFoundException */
   public void addEdge (T vertex1, T vertex2) throws ElementNotFoundException;

   /** Remove um nó entre dois vértices do graph.
     * @param vertex1
     * @param vertex2
     * @throws excecoes.ElementNotFoundException */
   public void removeEdge (T vertex1, T vertex2) throws ElementNotFoundException;

   /**Retorna o iteratorBFS começando com um vértice dado.
     * @param startVertex
     * @return  */
   public Iterator iteratorBFS(T startVertex);

   /** Retorna o iteratorDFS começando com um vértice dado.
     * @param startVertex
     * @return  */
   public Iterator iteratorDFS(T startVertex);

   /** Retorna um iterador que contém o caminho mais curto entre os dois vértices.
       the two vertices.
     * @param startVertex
     * @param targetVertex
     * @return  */
   public Iterator iteratorShortestPath(T startVertex, T targetVertex);

   /** Retorna verdadeiro se o graph estiver vazio, falso caso contrário.
     * @return  */
   public boolean isEmpty();

   /** Retorna verdadeiro se o graph estiver conectado, falso caso contrário.
     * @return  */
   public boolean isConnected();

   /** Retorna o numero de vertices do graph
     * @return  */
   public int size();

   /** Retorna o metodo toString da matriz de adjacencias
     * @return  */
   @Override
   public String toString();
}