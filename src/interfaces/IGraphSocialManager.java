/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.IOException;
import java.util.Iterator;
import models.Utilizador;

/**
 * Interface responsavel por definir o contrato de metodos relacionados com o
 * grafo
 *
 * @author ZeLuis
 */
public interface IGraphSocialManager {

    
    
    
    /**
     * Metodo responsavel de ligaçao entre dois vertices (adicao de aresta) do
     * grafo equivalente ao pedido de amizade normal
     *
     * @param userAdiciona utilizador que adiciona
     * @param user utilizador que e adicionado
     */
    public void adicionarAmigosDirectos(Utilizador userAdiciona, Utilizador user);

    /**
     * Metodo responsavel de ligacao entre dois vertices (adicao de aresta) do
     * grafo equivalente ao pedido de amizade normal
     *
     * @param user utilizador que ira ser adicionado
     */
    public void adicionarAmigosPatrocinado(Utilizador user);

    /**
     * Metodo responsavel de remocao de uma aresta entre dois amigos, entre dois
     * pontos do grafo
     *
     * @param user utilizador com o qual o utilizador que esta ligado vai
     * remover a amizade
     */
    public void removerAmigosDirectos(Utilizador user);

    /**
     * Metodo responsavel por calcular o alcance de uma mensagem antes de ser
     * publicada.<br>
     * Para este método é usado o iterador BFS que ira retornar todos
     * os vertices do grafo a partir do inicial - este vertice inicial faz
     * referencia ao utilizador que ira publicar a mensagem e quer testar o seu
     * alcance.
     *
     * @param userRaiz utilizador raiz, ou seja o utilizador que vai publicar a mensagem
     * @return retorna um objecto do tipo Iterador com todos os utilizadores que estao dentro do raio de alcance da mensagem
     */
    public Iterator<Utilizador> calculaAlcanceMensagem(Utilizador userRaiz );

    /**
     * Metodo responsavel por calcular a taxa que o utilizador (calculo do
     * caminho mais curto) ira pagar pelo pedido de amizade patrocinado que
     * efectuar.
     *
     * @param caminho conjunto de utilizadores que compoem o caminho mais curto entre um e outro dado utilizador
     * @return valor total da taxa a pagar
     */
    public int calculaTaxaPedidoAmizade(Iterator<Utilizador> caminho);

    /**
     * Metodo responsavel por verificar se dois utilizadores estão directamente
     * ligados por uma aresta
     *
     * @param user um utilizador do grafo passado como parametro 
     * @param user1 outro utilizador do grafo passado como parametro
     * @return
     */
    public boolean isAmizadeDirecta(Utilizador user, Utilizador user1);

    /**
     * Metodo responsavel por retornar um Iterator com as ligacoes directas de
     * um utilizador, ou seja amigos de um utilizador
     *
     * @return
     */
    public Iterator<Utilizador> getAmigosUser(); //uma classe pair, aqui secalhar nao seria mal pensado.
    
    /**
     * Metodo responsavel por obter todos os utilizadores existentes no grafo social
     * @return um iterator com todos os utilizadores existentes
     */
    public Iterator<Utilizador> getAllUsers() throws IOException;
    
    
}
