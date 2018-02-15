/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGUI;

import backend.ComboxboxItem;
import backend.existingValues;
import estruturas_lineares.non_ordered.DoubleLinkedUnorderedList;
import files.GestaoFicheiroComentarios;
import files.GestaoFicheiroMensagens;
import files.GestaoFicheiroUtilizadores;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Comentario;
import models.Mensagem;
import models.Utilizador;

/**
 * Interface responsavél pela 
 * @author Fábio Rêgo
 */
public class BlogSocialMainFrame extends javax.swing.JFrame {

    private final DefaultTableModel modelTable = new DefaultTableModel();
    private Utilizador utilizador;
    private Mensagem userMensagem;
    private Comentario comentario;
    private GestaoFicheiroMensagens gestMensagem = null;
    private GestaoFicheiroComentarios gestComentarios = null;
    private GestaoFicheiroUtilizadores gestFiles = null;;
    private DoubleLinkedUnorderedList<Mensagem> mensagens = new DoubleLinkedUnorderedList<>();
    private DoubleLinkedUnorderedList<Comentario> comentarios = new DoubleLinkedUnorderedList<>();
    private DoubleLinkedUnorderedList<Utilizador> users = new DoubleLinkedUnorderedList<>();
    private DoubleLinkedUnorderedList<Mensagem> comentariosMensagem = new DoubleLinkedUnorderedList<>();
    

    /**
     * Creates new form BlogSocial
     */
    public BlogSocialMainFrame() throws IOException {

        this.gestMensagem = new GestaoFicheiroMensagens();
        this.gestComentarios = new GestaoFicheiroComentarios();
        this.gestFiles = new GestaoFicheiroUtilizadores();
        initComponents();
        initiFrames();

    }

    BlogSocialMainFrame(Utilizador userTemp) throws IOException {

        this.utilizador = userTemp;
        this.gestMensagem = new GestaoFicheiroMensagens();
        this.gestComentarios = new GestaoFicheiroComentarios();
        this.gestFiles = new GestaoFicheiroUtilizadores();
        initComponents();
        initiFrames();

    }

    /**
     * Metodo responsavel por adicionar uma coluna ao modelo
     */
    private void personalizeColumsRows() {

        tableofNews.setModel(modelTable);

        modelTable.addColumn("Publicacoes");
        modelTable.addColumn("Privacidade");

        tableofNews.setRowHeight(150);

    }

    private void initiFrames() throws IOException {
        
        
        
        addComentario.setVisible(false);
        buttontoPublicar.setVisible(false);
        this.userOnlien.setText(utilizador.getNome());

        testeRetornoMensagens(); //retorna as mensagens existentes em ficheiro - provavelmente tera que usar algum metodo da network.
        testeRetornoComentarios(); //retorna os comentarios existentes em ficheiro
        personalizeColumsRows(); //metodo responsavel por personalizar as colunas do tabela com o nome 
        giveItenstoCombobox(); //metodo responsavel por poupular a combox com os dois valores de privacidade que uma mensagem podera ter

        if (mensagens.isEmpty()) {

            modelTable.addRow(new Object[]{"Sem publicações para mostrar..."
                + "Sem comentários", 0});

        } else {
            
            for (Mensagem mes : mensagens) { //percorre a lista de mensagens existentes na plataforma e popula a lista, posteriormente e necessario verificar se os utilizadores sao amigos do utilizador online 
               if(mes.isPriv()) {
                    modelTable.addRow(new Object[]{mes.getConteudo(), "Privada"});
               }else {
                     modelTable.addRow(new Object[]{mes.getConteudo(), "Pública"});
               }
               
            }
        }
        
       
    }

    private void testeRetornoMensagens() {
        File check = new File("mensagens.txt");

        if (check.exists()) {
            mensagens = gestMensagem.lerFicheiroMensagem();
            mensagens.addToFront(userMensagem);
            System.out.println("Tamanho da Lista[Mensagens]: " + mensagens.getCountElements());
        }
    }

    /**
     * Adiciona dois elementos predefinidos e unicos para a privacidade da
     * mensagem
     */
    private void giveItenstoCombobox() {

        comboBoxtoPrivacy.removeAllItems();

        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) comboBoxtoPrivacy.getModel();
        modelCombo.addElement(new ComboxboxItem("PRIV", "Privada"));
        modelCombo.addElement(new ComboxboxItem("PUB", "Pública"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jSeparator1 = new javax.swing.JSeparator();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        messageInputField = new javax.swing.JTextField();
        publishButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendsList = new javax.swing.JList<>();
        newFriendsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userOnlien = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableofNews = new javax.swing.JTable();
        seeComents = new javax.swing.JButton();
        addComent = new javax.swing.JButton();
        seeAlcance = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        addComentario = new javax.swing.JTextArea();
        buttontoPublicar = new javax.swing.JButton();
        comboBoxtoPrivacy = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BLOG SOCIAL :: UM LUGAR ONDE A AMIZADE ESTÁ A DISTÂNCIA DE UM CLIQUE");

        messageInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageInputFieldActionPerformed(evt);
            }
        });

        publishButton.setText("Publicar ");
        publishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(47, 47, 47));

        friendsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(friendsList);

        newFriendsButton.setForeground(java.awt.Color.white);
        newFriendsButton.setText("Novos Amigos ");
        newFriendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFriendsButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("OS SEUS AMIGOS");

        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Ver perfil ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(newFriendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newFriendsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Bem Vindo, ");

        userOnlien.setText("[Nome_Utilizador]");

        tableofNews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tableofNews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableofNewsMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableofNews);

        seeComents.setText("Ver comentários ");
        seeComents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeComentsActionPerformed(evt);
            }
        });

        addComent.setText("Adicionar Comentário");
        addComent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComentActionPerformed(evt);
            }
        });

        seeAlcance.setText("Alcance ");

        addComentario.setColumns(20);
        addComentario.setRows(5);
        jScrollPane3.setViewportView(addComentario);

        buttontoPublicar.setText("Publicar");
        buttontoPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttontoPublicarActionPerformed(evt);
            }
        });

        comboBoxtoPrivacy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxtoPrivacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxtoPrivacyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addComent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(seeComents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttontoPublicar))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userOnlien))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(publishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(seeAlcance, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxtoPrivacy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(messageInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userOnlien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publishButton)
                    .addComponent(seeAlcance)
                    .addComponent(comboBoxtoPrivacy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seeComents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addComent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttontoPublicar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFriendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFriendsButtonActionPerformed
        // TODO add your handling code here:
        sendNewFriendAsk newFriendAsk = new sendNewFriendAsk();
        newFriendAsk.setVisible(true);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        
    }//GEN-LAST:event_newFriendsButtonActionPerformed

    /**
     * Metodo responsavel pela accao do botao de publicar mensagem
     *
     * @param evt
     */
    private void publishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishButtonActionPerformed
        Mensagem newMensagem;
        String message = this.messageInputField.getText();
        String com = this.comboBoxtoPrivacy.getSelectedItem().toString();

        if (message != null) {
           
            if (com.equals("Privada")) {
                newMensagem = new Mensagem(message, utilizador, true);
            } else {
                newMensagem = new Mensagem(message, utilizador, false);

            }
            
            modelTable.addRow(new Object[]{message, com});
            gestMensagem.escreverFicheiroMensagem(newMensagem);
            this.messageInputField.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "A mensagem encontra-se vazia", "Try Again!", JOptionPane.WARNING_MESSAGE);
            this.messageInputField.setText("");
        }

    }//GEN-LAST:event_publishButtonActionPerformed

    private void testeRetornoComentarios() {
        File check = new File("comentarios.txt");

        if (check.exists()) {
            comentarios = gestComentarios.lerFicheiroComentario();
            System.out.println("Tamanho da Lista[Comentarios]: " + comentarios.getCountElements());
        }
    }

    private void addComentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComentActionPerformed
        // TODO add your handling code here:
        int row = tableofNews.getSelectedRow(); 
        tableofNews.getValueAt(row, 1).toString();
        
         tableofNews.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e) {  
                if (e.getClickCount() == 1) {   
                    
                    
                    addComent.setEnabled(false);
//                    buttontoPublicar.setVisible(true);
//                    addComentario.setVisible(true);
                    } 
                  
            }  
        });
  
        //obtem a escolha da tabela
//        addComent.setEnabled(false);
        buttontoPublicar.setVisible(true);
        addComentario.setVisible(true);
    }//GEN-LAST:event_addComentActionPerformed

    private void buttontoPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttontoPublicarActionPerformed
        // TODO add your handling code here:
        String comment = this.addComentario.getText();
        Comentario newComentario = new Comentario(comment, utilizador);

        if (comment != null) {

            gestComentarios.escreverFicheiroComentario(newComentario);
            this.addComentario.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "O Comentario encontra-se vazia", "Try Again!", JOptionPane.WARNING_MESSAGE);
            this.addComentario.setText("");
        }
    }//GEN-LAST:event_buttontoPublicarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
               
                try {
                   profile_frame pf = new profile_frame(utilizador);
                    pf.setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(loginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
   
    }//GEN-LAST:event_jButton1ActionPerformed
   
    private void seeComentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeComentsActionPerformed
        try {
            // TODO add your handling code here:
            
            
            Comentarios comments = new Comentarios();
            
            comments.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BlogSocialMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    

     
    }//GEN-LAST:event_seeComentsActionPerformed

    private void comboBoxtoPrivacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxtoPrivacyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxtoPrivacyActionPerformed

    private void messageInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageInputFieldActionPerformed

    private void tableofNewsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableofNewsMousePressed
        // TODO add your handling code here:
      
            int row = tableofNews.getSelectedRow(); 
        tableofNews.getValueAt(row, 1).toString();
        
         tableofNews.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e) {  
                if (e.getClickCount() == 1) {   
                    
                     addComent.setEnabled(true);
                    
                    // OU
                    
//                    addComent.setEnabled(false);
//                    buttontoPublicar.setVisible(true);
//                    addComentario.setVisible(true);
                    } 
                  
            }  
        });
        
       
    }//GEN-LAST:event_tableofNewsMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComent;
    private javax.swing.JTextArea addComentario;
    private javax.swing.JButton buttontoPublicar;
    private javax.swing.JComboBox<String> comboBoxtoPrivacy;
    private javax.swing.JList<String> friendsList;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField messageInputField;
    private javax.swing.JButton newFriendsButton;
    private javax.swing.JButton publishButton;
    private javax.swing.JButton seeAlcance;
    private javax.swing.JButton seeComents;
    private javax.swing.JTable tableofNews;
    private javax.swing.JLabel userOnlien;
    // End of variables declaration//GEN-END:variables

}
