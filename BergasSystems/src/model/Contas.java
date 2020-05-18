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
    private String data;
    private String nome;
    
    public Contas(){
        id += 1;
        Date data = new Date();
        this.data = data.toString();
        id_cont = id;
    }
    
    public String getData(){
        return this.data;
    }
}
