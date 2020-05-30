/*
 * Esta tela gera o Fluxo de dados, ela realiza a toda a operação de fechamento de de caixa, cria o objeto da classe FluxoCaixa,
 * salva os valores no banco SQL e salva os mesmos dados num arquivo gerando o relatório
 */
package view;

import controller.Arquivo;
import controller.BancoDeDados;
import controller.FluxoCaixa;
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
public class FluxoDeCaixa extends javax.swing.JInternalFrame {

    /**
     * Cria um novo formulário FluxoDeCaixa
     */
    public FluxoDeCaixa() throws FileNotFoundException {
        this.file = new Arquivo();
        initComponents();
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o formulário.
     * AVISO: NÃO modifique este código. O conteúdo desse método é sempre regenerado pelo Editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        listFluxo = new java.awt.List();
        btnGerar = new javax.swing.JButton();
        txtData = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNomeFluxo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fluxo"));

        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/page_add.png"))); // NOI18N
        btnGerar.setText("Gerar Fluxo de Caixa");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        jLabel1.setText("Data:");

        jLabel2.setText("Nome:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(listFluxo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeFluxo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(btnGerar)
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(listFluxo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomeFluxo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnGerar)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    BancoDeDados bd = new BancoDeDados();
    private float contasAPagar;
    private float contasPagas;
    private float contasAReceber;
    private float contasRecebidas;
    private float custosValor;
    private float bancoSaldos;
    private float bancoDebitos;
    private float totalLucro;
    Arquivo file;

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        // TODO add your handling code here: 
        this.contasAPagar = 0;
        this.contasPagas = 0;
        this.contasAReceber = 0;
        this.contasRecebidas = 0;
        this.custosValor = 0;
        this.bancoSaldos = 0;
        this.bancoDebitos = 0;
        this.totalLucro = 0;
        this.listFluxo.clear();
        String cap, cp, car, cr, ca, sb;
        FluxoCaixa fc;
        try{
        if (this.txtData.getText().matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}") == false) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido, seguir o formato: dd/mm/aaaa");
        } else {
            this.listFluxo.add("--------------------------------------------------");
            for (int i = 0; i < bd.buscarContasPagar().size(); i++) {
                if (bd.buscarContasPagar().get(i) != null) {
                    this.contasAPagar += bd.buscarContasAPagar().get(i).getContasPagar();
                    cap = "Contas serem Pagas: " + bd.buscarContasPagar().get(i).getNome() + "  |  R$" + bd.buscarContasPagar().get(i).getContasPagar() + "  |  "
                            + bd.buscarContasPagar().get(i).getData();
                    this.listFluxo.add(cap);
                }
            }
            
            for (int i = 0; i < bd.buscarContasPagas().size(); i++) {
                 if (bd.buscarContasPagas().get(i) != null) {
                    this.contasPagas += bd.buscarContasPagas().get(i).getContasPagas();
                    cp = "Contas Pagas: " + bd.buscarContasPagas().get(i).getNome() + "  |  R$" + bd.buscarContasPagas().get(i).getContasPagas() + "  |  "
                            + bd.buscarContasPagas().get(i).getData();
                    this.listFluxo.add(cp);
                }
            }

            for (int i = 0; i < bd.buscarContasReceber().size(); i++) {
                if (bd.buscarContasReceber().get(i) != null) {
                    this.contasAReceber += bd.buscarContasReceber().get(i).getContasReceber();
                    car = "Contas a serem Recebidas: " + bd.buscarContasReceber().get(i).getNome() + "  |  R$" + bd.buscarContasReceber().get(i).getContasReceber() + "  |  "
                            + bd.buscarContasReceber().get(i).getData();
                    this.listFluxo.add(car);
                }
            }
            
            for (int i = 0; i < bd.buscarContasRecebidas().size(); i++) {
                 if (bd.buscarContasRecebidas().get(i) != null) {
                    this.contasRecebidas += bd.buscarContasRecebidas().get(i).getContasRecebidas();
                    cr = "Contas Recebidas: " + bd.buscarContasRecebidas().get(i).getNome() + "  |  R$" + bd.buscarContasRecebidas().get(i).getContasRecebidas() + "  |  "
                            + bd.buscarContasRecebidas().get(i).getData();
                    this.listFluxo.add(cr);
                }
            }

            for (int i = 0; i < bd.buscarGestaoDeCusto().size(); i++) {
                if (bd.buscarGestaoDeCusto().get(i) != null) {
                    this.custosValor += bd.buscarGestaoDeCusto().get(i).getValor();
                    ca = "Custos adicionais: " + bd.buscarGestaoDeCusto().get(i).getNome() + "  |  " + bd.buscarGestaoDeCusto().get(i).getValor();
                    this.listFluxo.add(ca);
                }
            }

            for (int i = 0; i < bd.buscarExtrato().size(); i++) {
                if (bd.buscarExtrato().get(i) != null) {
                    this.bancoSaldos += bd.buscarExtrato().get(i).getEntrada();
                    sb = "Saldos Bancários: " + bd.buscarExtrato().get(i).getNome() + "  |  " + bd.buscarExtrato().get(i).getEntrada();
                    this.listFluxo.add(sb);
                }
            }

            this.listFluxo.add("---------------------RESUMO-----------------------");
            this.listFluxo.add("Contas a pagar: R$" + this.contasAPagar);
            this.listFluxo.add("Contas Pagas: R$" + this.contasPagas);
            this.listFluxo.add("--------------------------------------------------");
            this.listFluxo.add("Contas a receber: R$" + this.contasAReceber);
            this.listFluxo.add("Contas recebidas: R$" + this.contasRecebidas);
            this.listFluxo.add("--------------------------------------------------");
            this.listFluxo.add("Custos: R$" + this.custosValor);
            this.listFluxo.add("--------------------------------------------------");
            this.totalLucro = this.contasRecebidas + this.bancoSaldos - this.contasPagas - this.custosValor;
            this.listFluxo.add("Fechamento:");
            this.listFluxo.add("");
            this.listFluxo.add("Lucro: R$" + this.totalLucro);
            this.listFluxo.add("Contas a receber: R$" + this.contasAReceber);
            this.listFluxo.add("Contas a pagar: R$" + this.contasAPagar);
            if (this.totalLucro > 0) {
                this.listFluxo.add("+------------------------+");
                this.listFluxo.add("  Status: Teve Lucro");
                fc = new FluxoCaixa(this.txtNomeFluxo.getText(), this.totalLucro, 0, this.txtData.getText());
                this.listFluxo.add("+------------------------+");
            } else if (this.totalLucro < 0) {
                this.listFluxo.add("+------------------------+");
                this.listFluxo.add("  Status: Teve Prejuíso");
                fc = new FluxoCaixa(this.txtNomeFluxo.getText(), 0, this.totalLucro, this.txtData.getText());
                this.listFluxo.add("+------------------------+");
            } else {
                this.listFluxo.add("+------------------------+");
                this.listFluxo.add("  Status: Zerado");
                fc = new FluxoCaixa(this.txtNomeFluxo.getText(), 0, 0, this.txtData.getText());
                this.listFluxo.add("+------------------------+");
            }
            bd.inserirFluxoCaixa(fc);
            file.WriteFile("---------------------RESUMO-----------------------" + "\n" + "Contas a pagar: R$" + this.contasAPagar + "\n" + "Contas Pagos: R$" + this.contasPagas + 
                    "\n" + "--------------------------------------------------" + "\n" + "Contas a receber: R$" + this.contasAReceber + "\n" + "Contas recebidos: R$" + this.contasRecebidas +
                    "\n" + "--------------------------------------------------" + "\n" + "Custos: R$" + this.custosValor +  "\nSaldos: R$" + this.bancoSaldos + "\n" + 
                            "--------------------------------------------------" + "\n" + "Lucro: R$" + this.totalLucro + "\nData: " + this.txtData.getText());
        }
        } catch (IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }//GEN-LAST:event_btnGerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.List listFluxo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNomeFluxo;
    // End of variables declaration//GEN-END:variables
}
