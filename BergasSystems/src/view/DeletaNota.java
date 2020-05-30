/*
 * Esta tela Faz a exclusão de qualquer nota existente no sistema, basta apenas selecionar a categoria desejada para pesquizar
 * digitar o ID que se deseja excluir e clicar no botão btnDeletar
 */
package view;

import controller.BancoDeDados;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class DeletaNota extends javax.swing.JInternalFrame {

    /**
     * Cria um novo formulário DeletaNota
     */
    public DeletaNota() {
        initComponents();
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o
     * formulário. AVISO: NÃO modifique este código. O conteúdo desse método é
     * sempre regenerado pelo Editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPesquisar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        listContas = new java.awt.List();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chContaAPagar = new javax.swing.JRadioButton();
        chContaAReceber = new javax.swing.JRadioButton();
        chContaPagas = new javax.swing.JRadioButton();
        chContaRecebidas = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Excluir");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        listContas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setText("ID");

        jLabel5.setText("Nome");

        jLabel6.setText("Débito");

        jLabel7.setText("Crédito");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/invoice1.png"))); // NOI18N

        chContaAPagar.setText("Contas a Pagar");

        chContaAReceber.setText("Contas a Receber");
        chContaAReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chContaAReceberActionPerformed(evt);
            }
        });

        chContaPagas.setText("Contas Pagas");

        chContaRecebidas.setText("Contas Recebidas");

        jLabel2.setText("Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnPesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chContaAPagar)
                                    .addComponent(chContaAReceber)
                                    .addComponent(chContaPagas)
                                    .addComponent(chContaRecebidas))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnDeletar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listContas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addComponent(jLabel5)
                .addGap(50, 50, 50)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(183, 183, 183))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listContas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chContaAPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chContaPagas)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chContaRecebidas)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeletar)
                            .addComponent(btnPesquisar)))
                    .addComponent(chContaAReceber))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    BancoDeDados bd = new BancoDeDados();
    private String contaP;
    private String contaAP;

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (this.chContaAReceber.isSelected() == true) {
            this.listContas.clear();
            for (int i = 0; i < bd.buscarContasAReceber().size(); i++) {
                if (bd.buscarContasAPagar().get(i) != null && bd.buscarContasAReceber().get(i).getContasReceber() > 0) {
                    contaP = "" + bd.buscarContasAReceber().get(i).getContasRecebidas();
                    contaAP = "" + bd.buscarContasAReceber().get(i).getContasReceber();

                    this.listContas.add(bd.buscarContasAReceber().get(i).getID() + "  |  " + bd.buscarContasAReceber().get(i).getData() + "  |  " + bd.buscarContasAReceber().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);

                }
            }
        } else if (this.chContaAPagar.isSelected() == true) {
            this.listContas.clear();
            for (int i = 0; i < bd.buscarContasAPagar().size(); i++) {
                if (bd.buscarContasAPagar().get(i) != null && bd.buscarContasAPagar().get(i).getContasPagar() > 0) {
                    contaP = "" + bd.buscarContasAPagar().get(i).getContasPagas();
                    contaAP = "" + bd.buscarContasAPagar().get(i).getContasPagar();
                    this.listContas.add(bd.buscarContasAPagar().get(i).getID() + "  |  " + bd.buscarContasAPagar().get(i).getData() + "  |  " + bd.buscarContasAPagar().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);

                }
            }
        } else if (this.chContaRecebidas.isSelected() == true) {
            this.listContas.clear();
            for (int i = 0; i < bd.buscarContasAReceber().size(); i++) {
                if (bd.buscarContasAReceber().get(i) != null && bd.buscarContasAReceber().get(i).getContasRecebidas() > 0) {
                    contaP = "" + bd.buscarContasAReceber().get(i).getContasRecebidas();
                    contaAP = "" + bd.buscarContasAReceber().get(i).getContasReceber();
                    this.listContas.add(bd.buscarContasAReceber().get(i).getID() + "  |  " + bd.buscarContasAReceber().get(i).getData() + "  |  " + bd.buscarContasAReceber().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);

                }
            }
        } else if (this.chContaPagas.isSelected() == true) {
            this.listContas.clear();
            for (int i = 0; i < bd.buscarContasAPagar().size(); i++) {
                if (bd.buscarContasAPagar().get(i) != null && bd.buscarContasAPagar().get(i).getContasPagas() > 0) {
                    contaP = "" + bd.buscarContasAPagar().get(i).getContasPagas();
                    contaAP = "" + bd.buscarContasAPagar().get(i).getContasPagar();
                    this.listContas.add(bd.buscarContasAPagar().get(i).getID() + "  |  " + bd.buscarContasAPagar().get(i).getData() + "  |  " + bd.buscarContasAPagar().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção para pesquisar");
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed
    Tela1 t = new Tela1();
    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int id = 0;
        try {
            id = Integer.parseInt(this.txtID.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e + "\nEntre com um valor ID válido");
        }
        if (this.chContaAPagar.isSelected() == true) {
            bd.deletarContaPagar(id);
            this.txtID.setText("");
            this.listContas.clear();
        } else if (this.chContaAReceber.isSelected() == true) {
            bd.deletarContaReceber(id);
            this.txtID.setText("");
            this.listContas.clear();
        } else if (this.chContaPagas.isSelected() == true) {
            bd.deletarContaPagar(id);
            this.txtID.setText("");
            this.listContas.clear();
        } else if (this.chContaRecebidas.isSelected() == true) {
            bd.deletarContaReceber(id);
            this.txtID.setText("");
            this.listContas.clear();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma opção para excluir");
        }
        // t.atualizaTela();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void chContaAReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chContaAReceberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chContaAReceberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JRadioButton chContaAPagar;
    private javax.swing.JRadioButton chContaAReceber;
    private javax.swing.JRadioButton chContaPagas;
    private javax.swing.JRadioButton chContaRecebidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private java.awt.List listContas;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
