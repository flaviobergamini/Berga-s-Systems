/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BancoDeDados;
import javax.swing.JOptionPane;

/**
 *
 * @author fhmbe
 */
public class ContasRecebidas extends javax.swing.JInternalFrame {

    /**
     * Creates new form ContasRecebidas
     */
    public ContasRecebidas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtContaRecebida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        listContasRecebida = new java.awt.List();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtContaRecebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContaRecebidaActionPerformed(evt);
            }
        });

        jLabel2.setText("Conta recebida:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        listContasRecebida.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setText("ID");

        jLabel5.setText("Nome");

        jLabel6.setText("Débito");

        jLabel7.setText("Recebimento");

        jLabel4.setText("ICONE");

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
                                .addComponent(btnPesquisar)
                                .addGap(73, 73, 73)
                                .addComponent(btnCadastrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(listContasRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel3)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel5)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel6)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel7)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContaRecebida, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtID))))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listContasRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(txtContaRecebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnPesquisar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    BancoDeDados bd = new BancoDeDados();
    private String contaP;
    private String contaAP;
    Tela1 t = new Tela1();
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int id = 0;
        float valor = 0, conta = 0;
        boolean confirma = false;
        try {
            id = Integer.parseInt(this.txtID.getText());
            confirma = true;
            try {
                valor = Float.parseFloat(this.txtContaRecebida.getText());
                conta = bd.buscaContasAPagarID(id, 2);
                if(valor == conta)
                confirma = true;
                else{
                    JOptionPane.showMessageDialog(null, "Valor não correspondente, nota de R$" + conta);
                    confirma = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e + "\nEntre com um Valor válido");
                confirma = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e + "\nEntre com um ID válido");
            confirma = false;
        }
        if (confirma == true) {
            bd.atualizarContasReceber(id, "", 0, valor);
            this.txtID.setText("");
            this.txtContaRecebida.setText("");
            this.listContasRecebida.clear();
        }
        //t.atualizaTela();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        for (int i = 0; i < bd.buscarContasAReceber().size(); i++) {
            if (bd.buscarContasAReceber().get(i) != null && bd.buscarContasAReceber().get(i).getContasReceber()> 0) {
                contaP = "" + bd.buscarContasAReceber().get(i).getContasRecebidas();
                contaAP = "" + bd.buscarContasAReceber().get(i).getContasReceber();
                this.listContasRecebida.add(bd.buscarContasAReceber().get(i).getID() + "  |  " + bd.buscarContasAReceber().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);

            }

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtContaRecebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContaRecebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContaRecebidaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private java.awt.List listContasRecebida;
    private javax.swing.JTextField txtContaRecebida;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
