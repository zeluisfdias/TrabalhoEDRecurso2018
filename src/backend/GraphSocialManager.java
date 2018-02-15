/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import estruturas_lineares.Network;
import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import files.GestaoFicheiroUtilizadores;
import interfaces.IGraphSocialManager;
import java.io.IOException;
import java.util.Iterator;

import models.Comentario;
import models.Mensagem;
import models.Utilizador;

/**
 * Classe responsavel por fazer a gestao dos vertices e arestas do grafo, com
 * metodos mais genericos
 *
 * @author ZeLuis
 */
public class GraphSocialManager implements IGraphSocialManager {

    private Network<Utilizador> network;
    private DoubleLinkedUnorderedList<Utilizador> userOnGraph;
    private DoubleLinkedUnorderedList<Mensagem> mensagensOnGraph;
    private DoubleLinkedUnorderedList<Comentario> comentariosOnGraph;

    /**
     * Metodo construtor responsavel por instanciar um novo grafo social.
     */
    public GraphSocialManager() {
        this.network = new Network<>();
        this.userOnGraph = new DoubleLinkedUnorderedList<>();
        this.comentariosOnGraph = new DoubleLinkedUnorderedList<>();
        this.mensagensOnGraph = new DoubleLinkedUnorderedList<>();
    }

    /**
     * Metodo responsavel de ligaçao entre dois vertices (adicao de aresta) do
     * grafo equivalente ao pedido de amizade normal
     *
     * @param userAdiciona utilizador que adiciona
     * @param user utilizador que e adicionado
     */
    @Override
    public void adicionarAmigosDirectos(Utilizador userAdiciona, Utilizador user) {

        this.network.addEdge(userAdiciona, user);

    }

    @Override
    public void adicionarAmigosPatrocinado(Utilizador user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerAmigosDirectos(Utilizador user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Utilizador> calculaAlcanceMensagem(Utilizador userRaiz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculaTaxaPedidoAmizade(Iterator<Utilizador> caminho) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAmizadeDirecta(Utilizador user, Utilizador user1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Utilizador> getAmigosUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Utilizador> getAllUsers()throws IOException{
       
        GestaoFicheiroUtilizadores<Utilizador> userManagment = null;
        try {
           
            userManagment = new GestaoFicheiroUtilizadores<>();
            this.userOnGraph = userManagment.lerFicheiro();

        } catch (IOException ex) {
              throw new IOException("Ocorreu um erro com a leitura do ficheiro [Exepcao relacionada com operacoes I/O do ficheiro]");
        }
        
        return userOnGraph.iterator();
    }

}
