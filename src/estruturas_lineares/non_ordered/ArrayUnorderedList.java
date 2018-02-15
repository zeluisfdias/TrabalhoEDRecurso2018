package estruturas_lineares.non_ordered;

import estruturas_lineares.ArrayList;
import estruturas_lineares.ArrayList;
import excecoes.ElementNotFoundException;
import interfacesADT.UnorderedListADT;

/**
 * Classe responsavel por criar uma classe do tipo ArrayUnorderedList
 * @author Fábio Rêgo
 * @param <T> Tipo genérico.
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    
    /**
     *Método construtor para a criação de uma nova Instância de 
     * ArrayUnorderedList vazia.
     */
    public ArrayUnorderedList() {
        super();
    }
    
    /**
     * Método construtor para a criação de uma nova instância de 
     * ArrayUnorderedList vazia ecom um tamanho máximo passado por parâmetro.
     * 
     * @param maxSize Tamanho máximo.
     */
    public ArrayUnorderedList(int maxSize) {
        super(maxSize);
    }
    
    /**
     * Método responsavél por mover todas as posições do ArrayUnorderedList 
     * desde o index zero até ao index passado por parâmetro.
     * 
     * @param stopIndex Index de paragem.
     */
    public void shiftPositions(int stopIndex) {
        for (int j = super.size(); j > stopIndex; j--) {
            super.getArray()[j + 1] = super.getArray()[j];
        }
    }
    
    /**
     * Método responsavél por adicionar um novo Elemento à cabeça da 
     * ArrayUnorderedList.
     * 
     * @param element Novo Elemento a ser adicionado.
     */
    @Override
    public void addToFront(T element) {
        if (this.size() == super.getArray().length) {
            super.expandCapacity();
        }
        
        if (this.isEmpty()) {
            super.getArray()[super.getPosition()] = element;
            
        } else {

            //Tem de ir até ao index zero, logo para no -1
            this.shiftPositions(-1);
            super.getArray()[0] = element;
            
        }
        
        super.setPosition(super.getPosition() + 1);
        super.setModCount(super.getModCount() + 1);
    }
    
    /**
     * Método responsavél por adicionar um novo Elemento à cauda da 
     * ArrayUnorderedList.
     * 
     * @param element Novo Elemento a ser adicionado.
     */
    @Override
    public void addToRear(T element) {
        if (super.size() == super.getArray().length) {
            super.expandCapacity();
        }
        
        super.getArray()[super.getPosition()] = element;
        super.setPosition(super.getPosition() + 1);
        super.setModCount(super.getModCount() + 1);
    }
    
    /**
     * Método responsavél por adicionar um novo Elemento a seguir a um Elemento
     * já existente na ArrayUnorderedList.
     * 
     * @param element Novo Elemento a ser adicionado.
     * @param target Elemento na posição anterior ao novo Elemento a ser 
     * adicionado.
     * @throws ElementNotFoundException Quando o Elemento a ser procurado não
     * existe na ArrayUnorderedList.
     */
    @Override
    public void addAfter(T element, T target) throws ElementNotFoundException {
        
        if (super.contains(target)) {
            
            if (super.size() == super.getArray().length) {
                super.expandCapacity();
            }
            
            int i = 0;

            //Iterar enquanto não encontrarmos
            while (!target.equals(super.getArray()[i])) {
                i++;
            }
            
            //Como tem de se inserir a seguir ao target, para-se no index do target
            this.shiftPositions(i);
            
            super.getArray()[i + 1] = element;
            
            super.setPosition(super.getPosition() + 1);
            super.setModCount(super.getModCount() + 1);
            
        } else {
            throw new ElementNotFoundException("Esse elemento não se encontra na Lista");
        }
    }
    
}
