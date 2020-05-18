/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author fhmbe
 */
public class FluxoCaixa {
    private String nome;
    private float credito;
    private float debito;
    
    public FluxoCaixa(String nome, float credito, float debito){
        this.nome = nome;
        this.credito = credito;
        this.debito = debito;
    }
}
