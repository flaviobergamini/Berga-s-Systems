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
    private static int id;
    private int id_cont;
    
    private float valor;
    private String datas;
    private String nome;
    Date data = new Date();
    public Contas(){
        id += 1;
        this.datas = data.toString();
        id_cont = id;
    }
    public void criaConta(String nome, float valor){
        this.nome = nome;
        this.valor = valor;
    }
    public String getData(){
        return this.datas;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public float getValor(){
        return this.valor;
    }
}
