/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 * Classe responsavel por fazer a gestao dos itens da ComBox
 * @author ZeLuis
 */
public class ComboxboxItem {

    private String key;
    private String value;
    
    /**
     * Contrutor da class ComboxboxItem
     * @param key
     * @param value 
     */
    public ComboxboxItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Metodos GET e SET da class ComboxboxItem
     * @return 
     */
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Metodo toString da classComboxboxItem
     * @return 
     */
    @Override
    public String toString() {
        return value;
    }

}
