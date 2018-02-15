/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fábio Rêgo
 */
public class MensagemModel extends DefaultTableModel {

    public MensagemModel(final Object[][] dados) {
        super(dados, new String[]{"Publicacoes", "Comentario", "PUB/PRIV"});
    }

    // usaremos este método para atualizar os dados da JTable
    public void setDados(final Object[][] dados) {
        dataVector = super.convertToVector(dados);
    }

    private final Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class};
    private final boolean[] canEdit = new boolean[]{false, false, false};

    @Override
    public Class getColumnClass(final int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return canEdit[columnIndex];
    }

}
