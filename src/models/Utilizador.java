/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Classe Utilizador, responsavel por modelar um objecto Utilizador responsavel
 * por definir um utilizador do blog social.
 *
 * @author ZeLuis
 */
public class Utilizador implements Serializable{

    private static final AtomicLong NEXT_ID = new AtomicLong(2);
    private final long ID = NEXT_ID.getAndIncrement();
    private String nome;
    private String password;
    private int idade;
    private String email;
    private Date dataNasc;
    
   
  
    //UnorderedList<Utilizador> amigos; - lista de amigos do utilizador


   public Utilizador(String nome, String password, int idade) {
        this.nome = nome;
        this.password = password;
        this.idade = idade;
    
        
    }

   

   
   public Utilizador(String nome, String password) {
        this.nome = nome;
        this.password = password;
    
        
    }

    public Utilizador(String nome, String password, int idade, String email) {
        this.nome = nome;
        this.password = password;
        this.idade = idade;
        this.email = email;
    }

    public Utilizador(String nome, String password, int idade, String email, Date dataNasc) {
        this.nome = nome;
        this.password = password;
        this.idade = idade;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    
   
//    public Utilizador(String nome) {
//        this.nome = nome;
//    }
//    
//    
    public static AtomicLong getNEXT_ID() {
        return NEXT_ID;
    }

   

  
    /**
     * Metodo responsavel por obter o ID do utilizador instanciado
     *
     * @return retorna o ID do utilizador instanciado
     */
//    public int getID() {
//        return ID;
//    }
    /**
     * Metodo responsavel por definir um ID para o utilizador instanciado
     *
     * @param ID id que é passado como parametro
     */
//    public void setID(int ID) {
//        this.ID = ID;
//    }
    public long getID() {
        return ID;
    }

    /**
     * Metodo responsavel por obter o nome do utilizador instanciado
     *
     * @return retorna o nome do utilizador instanciado
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo responsavel por atribuir um novo nome de utilizador ao utilizador
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    

//    public ArrayUnorderedList<Utilizador> getAmigos() {
//        return amigos;
//    }
//
//    public void setAmigos(ArrayUnorderedList<Utilizador> amigos) {
//        this.amigos = amigos;
//    }
    
//    public void adicionarAmigo (Utilizador request){
//        amigos.addToRear(request);
//    }
//     
//    public ArrayUnorderedList getAmigos(){
//        return amigos;
//    }

    @Override
    public String toString() {
        return "Utilizador{" + "ID=" + ID + ", nome=" + nome + ", password=" + password + ", idade=" + idade + ", email=" + email + ", dataNasc=" + dataNasc + '}';
    }

    
    
}
