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
public class Consultas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Consultas
     */
    public Consultas() {
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

        listConsultas = new java.awt.List();
        slnCPagar = new javax.swing.JRadioButton();
        slnCReceber = new javax.swing.JRadioButton();
        slnGestao = new javax.swing.JRadioButton();
        slnExtrato = new javax.swing.JRadioButton();
        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LN1 = new javax.swing.JLabel();
        LN2 = new javax.swing.JLabel();

        slnCPagar.setText("Contas a Pagar");

        slnCReceber.setText("Contas a Receber");

        slnGestao.setText("Gestão de custos");

        slnExtrato.setText("Extrato Bancário");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel1.setText("ICONE");

        jLabel2.setText("ID");

        jLabel3.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(slnCReceber)
                                    .addComponent(slnCPagar))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(slnExtrato)
                                    .addComponent(slnGestao))
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(LN1)
                                .addGap(18, 18, 18)
                                .addComponent(LN2)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(LN1)
                    .addComponent(LN2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slnCPagar)
                            .addComponent(slnExtrato))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slnCReceber)
                            .addComponent(slnGestao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnConsultar)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    BancoDeDados bd = new BancoDeDados();
    private String contaP;
    private String contaAP;
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        this.listConsultas.clear();
        if (this.slnCPagar.isSelected() == true) {
            this.LN1.setText("A Pagar");
            this.LN2.setText("Pagas");
            for (int i = 0; i < bd.buscarContasAPagar().size(); i++) {
                if (bd.buscarContasAPagar().get(i) != null) {
                    contaP = "" + bd.buscarContasAPagar().get(i).getContasPagas();
                    contaAP = "" + bd.buscarContasAPagar().get(i).getContasPagar();
                    this.listConsultas.add(bd.buscarContasAPagar().get(i).getID() + "  |  " + bd.buscarContasAPagar().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);
                }

            }
        } else if (this.slnCReceber.isSelected() == true) {
            this.LN1.setText("A Receber");
            this.LN2.setText("Recebidas");
            for (int i = 0; i < bd.buscarContasAReceber().size(); i++) {
                if (bd.buscarContasAReceber().get(i) != null) {
                    contaP = "" + bd.buscarContasAReceber().get(i).getContasRecebidas();
                    contaAP = "" + bd.buscarContasAReceber().get(i).getContasReceber();
                    this.listConsultas.add(bd.buscarContasAReceber().get(i).getID() + "  |  " + bd.buscarContasAReceber().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);

                }

            }
        } else if (this.slnExtrato.isSelected() == true) {
            this.LN1.setText("Entrada");
            this.LN2.setText("Saída");
            for (int i = 0; i < bd.buscarExtrato().size(); i++) {
                if (bd.buscarExtrato().get(i) != null) {
                    this.listConsultas.add(bd.buscarExtrato().get(i).getID() + "  |  " + bd.buscarExtrato().get(i).getNome() + "  |  " + bd.buscarExtrato().get(i).getEntrada() + "  |  "
                            + bd.buscarExtrato().get(i).getSaida());
                }
            }
        } else if (this.slnGestao.isSelected() == true) {
            this.LN1.setText("Valor");
            this.LN2.setText("");
            for (int i = 0; i < bd.buscarGestaoDeCusto().size(); i++) {
                if (bd.buscarGestaoDeCusto().get(i) != null) {
                    this.listConsultas.add(bd.buscarGestaoDeCusto().get(i).getID() + "  |  " + bd.buscarGestaoDeCusto().get(i).getNome() + "  |  "
                            + bd.buscarGestaoDeCusto().get(i).getValor());
                }

            }
        } else{
            JOptionPane.showMessageDialog(null, "Selecione uma opção para proceguir a consulta");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LN1;
    private javax.swing.JLabel LN2;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.List listConsultas;
    private javax.swing.JRadioButton slnCPagar;
    private javax.swing.JRadioButton slnCReceber;
    private javax.swing.JRadioButton slnExtrato;
    private javax.swing.JRadioButton slnGestao;
    // End of variables declaration//GEN-END:variables
}
