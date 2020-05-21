 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ContasAPagar;
import model.ContasAReceber;
import model.ExtratoBancario;
import model.GestaoCusto;
import view.Tela1;

/**
 *
 * @author fhmbe
 */
public class BergasSystems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ContasAPagar conta = new ContasAPagar("Inatel", 3000.00f, 0);
        ContasAReceber contaR = new ContasAReceber("Inatel", 0, 200f);
        ExtratoBancario ex = new ExtratoBancario("Nubank", 10000, 3.5f);
        GestaoCusto gc = new GestaoCusto("energia", 37.70f);
        FluxoCaixa fc = new FluxoCaixa("teste", 300, 7);
        Relatorio rl = new Relatorio("teste", 300, 7);
        
        BancoDeDados bd = new BancoDeDados();
        boolean inserirContasAPagar = bd.inserirContasAPagar(conta);
        bd.inserirContasAReceber(contaR);
        bd.inserirFluxoCaixa(fc);
        bd.inserirExtrato(ex);
        bd.inserirGestaoCusto(gc);
        bd.inserirRelatorio(rl);
        
        bd.atualizarContasPagar(1, "Inatelkk", 100 ,3);
        bd.atualizarContasReceber(1, "Inatelkk", 100 ,8);
        bd.atualizarExtrato(1, "gfgn", 345, 654);
        bd.atualizarGestaoCusto(1, "hdgshfg", 2345);
        bd.atualizarRelatorio(1, "fndfgj", 2345678, 87654);
        bd.atualizarfluxo(2, "fhdfhdsf", 345678, 543234);
        
        bd.deletarFluxo(2);
        bd.deletarContaPagar(1);
        bd.deletarContaReceber(1);
        bd.deletarExtrato(1);
        bd.deletarGestaoCusto(1);
        bd.deletarRelatorio(1);
        
        bd.buscarFluxoDeCaixa();
        bd.buscarContasAPagar();
        bd.buscarContasAReceber();
        bd.buscarExtrato();
        bd.buscarGestaoDeCusto();
        bd.buscarRelatorio();
        new Tela1().setVisible(true);
    }
    
}
