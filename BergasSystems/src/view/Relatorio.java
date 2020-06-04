/*
 * Esta tela é responsável por acessar o banco SQL e resgatar os fluxos de dados já gerados para poder 
 * gerar um relatório de acordo com o ID selecionado
 */
package view;

import controller.Arquivo;
import controller.BancoDeDados;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class Relatorio extends javax.swing.JInternalFrame {

    /**
     * Cria um novo formulário Relatorio
     */
    public Relatorio() throws FileNotFoundException {
        this.file = new Arquivo();
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

        listBuscar = new java.awt.List();
        btnListar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        btnListar.setText("Listar Fluxo de Caixa");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel3.setText("ID:");

        btnGerar.setText("Gerar Relatório");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-relatorios2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGerar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(listBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGerar)
                    .addComponent(btnListar)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    BancoDeDados bd = new BancoDeDados();
    Arquivo file;
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        String var;
        for (int i = 0; i < bd.buscarFluxoDeCaixa().size(); i++) {
            if (bd.buscarFluxoDeCaixa().get(i) != null) {
                this.listBuscar.add(bd.buscarFluxoDeCaixa().get(i).getID() + "  |  " + bd.buscarFluxoDeCaixa().get(i).getNome() + "  |  " + bd.buscarFluxoDeCaixa().get(i).getCredito() + "  |  "
                        + bd.buscarFluxoDeCaixa().get(i).getDebito() + "  |  " + bd.buscarFluxoDeCaixa().get(i).getData());
            }
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        // TODO adtxtCustoling code here:
        boolean grava = true, idb = true;
        int id = 0;
        try {
            id = Integer.parseInt(this.txtID.getText());
            idb = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e + "\nEntre com um valor válido para o ID");
            idb = false;
        }

        while (grava == true && idb == true) {
            try {
                file.WriteFile(bd.buscarFluxoDeCaixaID(id).get(0).getID() + "  |  " + bd.buscarFluxoDeCaixaID(id).get(0).getNome() + "  |  " + bd.buscarFluxoDeCaixaID(id).get(0).getCredito()
                        + "  |  " + bd.buscarFluxoDeCaixaID(id).get(0).getDebito() + "  |  " + bd.buscarFluxoDeCaixaID(id).get(0).getData());
                grava = false;
            } catch (IOException ex) {
                try {
                    //Logger.getLogger(FluxoDeCaixa.class.getName()).log(Level.SEVERE, null, ex);
                    this.file = new Arquivo();
                } catch (FileNotFoundException ex1) {
                    Logger.getLogger(FluxoDeCaixa.class.getName()).log(Level.SEVERE, null, ex1);
                }
                grava = true;
            }
        }
    }//GEN-LAST:event_btnGerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private java.awt.List listBuscar;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
