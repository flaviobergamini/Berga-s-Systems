/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fhmbe
 */
public class ContasAPagar extends Contas{
    private float contasPagar;
    private float contasPagas;
    
    public ContasAPagar(String nome, float contasPagar, float contasPagas){
        this.contasPagar = contasPagar;
        this.contasPagas = contasPagas;
        this.criaConta(nome, 0);
    }

    public float getContasPagar() {
        return contasPagar;
    }

    public float getContasPagas() {
        return contasPagas;
    }
    
    public String getData(){
        return this.getData();
    }
}
