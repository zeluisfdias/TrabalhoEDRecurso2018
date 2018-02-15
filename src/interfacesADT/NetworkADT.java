/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesADT;

/**
 * Metodo Responsavel por definir a Interface NetworkADT
 * @author Fábio Rêgo
 * @param <T>
 */
public interface NetworkADT<T> extends GraphADT<T>
{
   /** Insere um no entre dois vértices do graph
     * @param vertex1
     * @param vertex2
     * @param weight */
   public void addEdge (T vertex1, T vertex2, double weight);
   
   /** Retorna o caminho mais curto entre dois vertices do graph
     * @param vertex1
     * @param vertex2
     * @return  */
   public double shortestPathWeight(T vertex1, T vertex2);
}