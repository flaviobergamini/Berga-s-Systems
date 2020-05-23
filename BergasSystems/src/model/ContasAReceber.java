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
    
    public ContasAReceber(String nome, float contasReceber, float contasRecebidas, String data){
        this.contasReceber = contasReceber;
        this.contasRecebidas = contasRecebidas;
        this.criaConta(nome, 0, data);
    }

    public float getContasReceber() {
        return contasReceber;
    }

    public float getContasRecebidas() {
        return contasRecebidas;
    }
}
