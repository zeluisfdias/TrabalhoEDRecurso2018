/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Iterator;

/**
 * nterface responsavel por definir os metodos para a Interface IUtilizador
 * @author ZeLuis
 */
public interface IUtilizador {
    
    /**
     * Metodo responsavel por retornar um Iterator com as ligacoes de todos os amigos de
     * um utilizador
     * @return 
     */
    public Iterator<IUtilizador> getAmigosUtilizador();
    
}
