/*
 * Esta tela Realiza a pesquisa das contas a pagar existentes e através do ID, é possivel atualizar o sistema indicando que foi pago
 */
package view;

import controller.BancoDeDados;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ContasAPagar;

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class ContasPagas extends javax.swing.JInternalFrame {

    /**
     * Cria um novo formulário ContasPagas
     */
    public ContasPagas() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        txtContaPaga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        listContasPagas = new java.awt.List();
        btnPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txtContaPaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContaPagaActionPerformed(evt);
            }
        });

        jLabel2.setText("Conta paga:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/invoice1.png"))); // NOI18N

        listContasPagas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        jLabel5.setText("Nome");

        jLabel6.setText("Débito");

        jLabel7.setText("Pagamento");

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
                                    .addComponent(listContasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(txtContaPaga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtID))))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listContasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(txtContaPaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnPesquisar))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    BancoDeDados bd = new BancoDeDados();
    private String contaP;
    private String contaAP;

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int id = 0;
        float valor = 0, conta = 0;
        boolean confirma = false;
        try {
            id = Integer.parseInt(this.txtID.getText());
            confirma = true;
            try {
                valor = Float.parseFloat(this.txtContaPaga.getText());
                conta = bd.buscaContasAPagarID(id, 1);
                if (valor == conta) {
                    confirma = true;
                } else {
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
            bd.atualizarContasPagar(id, "", 0, valor);
            this.txtID.setText("");
            this.txtContaPaga.setText("");
            this.listContasPagas.clear();
            //t.atualizaTela();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtContaPagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContaPagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContaPagaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed
    ArrayList<ContasAPagar> listaDeContasAPagar = new ArrayList<>();
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        for (int i = 0; i < bd.buscarContasAPagar().size(); i++) {
            if (bd.buscarContasAPagar().get(i) != null && bd.buscarContasAPagar().get(i).getContasPagar() > 0) {
                contaP = "" + bd.buscarContasAPagar().get(i).getContasPagas();
                contaAP = "" + bd.buscarContasAPagar().get(i).getContasPagar();
                this.listContasPagas.add(bd.buscarContasAPagar().get(i).getID() + "  |  " + bd.buscarContasAPagar().get(i).getNome() + "  |  " + contaAP + "  |  " + contaP);

            }

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.List listContasPagas;
    private javax.swing.JTextField txtContaPaga;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
