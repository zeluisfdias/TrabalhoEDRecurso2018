/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import java.util.Iterator;
import models.Utilizador;

/**
 * Classe responsavel por verificar se o utilizador existe ao fazer login
 * @author ZeLuis
 */
public class existingValues {

    private DoubleLinkedUnorderedList<Utilizador> dataTemp;
    

    public existingValues(DoubleLinkedUnorderedList<Utilizador> dataforComparing) {
        this.dataTemp = dataforComparing;
    }

    /**
     * Metodo que permite verificar se o utilizador existe quando estamos a fazer login
     * @param userTemp
     * @return 
     */
    public boolean existUserWithCredentilials(Utilizador userTemp) {
           Iterator<Utilizador> users =  dataTemp.iterator();
           
           
           while (users.hasNext()) {
               Utilizador user = users.next();
               
               if(user.getNome().equals(userTemp.getNome()) && user.getPassword().equals(userTemp.getPassword())) {
                   return true;
               }
            
        }
           return false;
    }
     public boolean existUserProfile(Utilizador userProf) {
           Iterator<Utilizador> users =  dataTemp.iterator();
           
           
           while (users.hasNext()) {
               Utilizador user = users.next();
               
               if(user.getNome().equals(userProf.getNome())) {
                   return true;
               }
            
        }
           return false;
    }
    

}
