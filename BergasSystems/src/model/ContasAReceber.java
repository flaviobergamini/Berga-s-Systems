/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author fhmbe
 */
public class ContasAReceber extends Contas{
    private float contasReceber;
    private float contasRecebidas;
    
    public ContasAReceber(String nome, float contasReceber, float contasRecebidas){
        this.contasReceber = contasReceber;
        this.contasRecebidas = contasRecebidas;
        this.criaConta(nome, 0);
    }
    
    public ContasAReceber(String nome, float contasReceber, float contasRecebidas, float valor){
        this.contasReceber = contasReceber;
        this.contasRecebidas = contasRecebidas;
        this.criaConta(nome, valor);
    }

    public float getContasReceber() {
        return contasReceber;
    }

    public float getContasRecebidas() {
        return contasRecebidas;
    }
    
    public String getData(){
        return this.getData();
    }

}
