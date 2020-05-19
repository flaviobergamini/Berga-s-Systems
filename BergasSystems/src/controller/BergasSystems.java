/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ContasAPagar;
import model.ContasAReceber;
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
        BancoDeDados bd = new BancoDeDados();
        boolean inserirContasAPagar = bd.inserirContasAPagar(conta);
        bd.inserirContasAReceber(contaR);
        new Tela1().setVisible(true);
    }
    
}
