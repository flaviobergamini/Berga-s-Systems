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
public abstract class Contas {
    private String ID;
    private float valor;
    private String nome;
    private String data;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
   
    public void criaConta(String nome, float valor, String data){
        this.nome = nome;
        this.valor = valor;
        this.data = data;
    }
    
    public String getData(){
        return this.data;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public float getValor(){
        return this.valor;
    }
    
}
