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
    private String data;
    
    public FluxoCaixa(String nome, float credito, float debito, String data){
        this.nome = nome;
        this.credito = credito;
        this.debito = debito;
        this.data = data;
    }
    
    public String getData(){
        return this.data;
    }
    
    public String getNome() {
        return nome;
    }

    public float getCredito() {
        return credito;
    }

    public float getDebito() {
        return debito;
    }
    
}
