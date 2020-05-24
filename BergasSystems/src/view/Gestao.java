/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BancoDeDados;
import javax.swing.JOptionPane;
import model.GestaoCusto;

/**
 *
 * @author fhmbe
 */
public class Gestao extends javax.swing.JInternalFrame {

    /**
     * Creates new form Gestao
     */
    public Gestao() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCusto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        listBuscar = new java.awt.List();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        slnAtualizar = new javax.swing.JRadioButton();
        slnCadastrar = new javax.swing.JRadioButton();
        slnExcluir = new javax.swing.JRadioButton();
        btnListar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        jLabel1.setText("Nome do Custo: ");

        jLabel2.setText("Valor:");

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Executar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel4.setText("ICONE");

        jLabel5.setText("ID");

        jLabel6.setText("Nome");

        jLabel7.setText("Saldo");

        slnAtualizar.setText("Atualizar");

        slnCadastrar.setText("Cadastrar");

        slnExcluir.setText("Excluir");

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel3.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(listBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(slnAtualizar)
                                            .addComponent(slnCadastrar)
                                            .addComponent(slnExcluir)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(btnListar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel6)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel7))
                            .addComponent(jLabel2)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel4)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(slnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(slnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(slnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnListar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed
    BancoDeDados bd = new BancoDeDados();

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO adtxtCustoling code here:
        String nome;
        nome = "";
        int id = 0;
        float pagar = -1;
        if (this.slnCadastrar.isSelected() == true) {
            GestaoCusto gc;
            nome = this.txtCusto.getText();
            try {
                pagar = Float.parseFloat(this.txtValor.getText());
                if (nome.length() > 0 && pagar > 0) {
                    gc = new GestaoCusto(nome, pagar);
                    bd.inserirGestaoCusto(gc);
                    this.txtCusto.setText("");
                    this.txtValor.setText("");
                    this.txtID.setText("");
                    this.listBuscar.clear();
                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
                } else {
                    if (nome.length() == 0) {
                        JOptionPane.showMessageDialog(null, "Insira a identificação para o custo");
                    }
                    if (pagar == 0) {
                        JOptionPane.showMessageDialog(null, "Insira o valor de custo");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e + "\nInsira um valor válido");
            }
        } else if (this.slnAtualizar.isSelected() == true) {
            nome = this.txtCusto.getText();
            try {
                id = Integer.parseInt(this.txtID.getText());
                if (this.txtValor.getText().length() > 0) {
                    try {
                        pagar = Float.parseFloat(this.txtValor.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e + "\nInsira um valor válido");
                    }
                }
                bd.atualizarGestaoCusto(id, nome, pagar);
                this.txtCusto.setText("");
                this.txtValor.setText("");
                this.txtID.setText("");
                this.listBuscar.clear();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e + "\nInsira um ID válido");
            }
        } else if (this.slnExcluir.isSelected() == true) {
            id = 0;
            try {
                id = Integer.parseInt(this.txtID.getText());
                bd.deletarGestaoCusto(id);
                this.txtCusto.setText("");
                this.txtValor.setText("");
                this.txtID.setText("");
                this.listBuscar.clear();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e + "\nInsira um ID válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecionar uma opção (Atualizar, Cadastrar ou Excluir) para proseguir com a operação");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:

        for (int i = 0; i < bd.buscarGestaoDeCusto().size(); i++) {
            if (bd.buscarGestaoDeCusto().get(i) != null) {
                this.listBuscar.add(bd.buscarGestaoDeCusto().get(i).getID() + "  |  " + bd.buscarGestaoDeCusto().get(i).getNome() + "  |  "
                        + bd.buscarGestaoDeCusto().get(i).getValor());
            }

        }
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private java.awt.List listBuscar;
    private javax.swing.JRadioButton slnAtualizar;
    private javax.swing.JRadioButton slnCadastrar;
    private javax.swing.JRadioButton slnExcluir;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
