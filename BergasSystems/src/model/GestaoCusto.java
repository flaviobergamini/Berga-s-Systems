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
public class GestaoCusto {
    private String ID;
    private String nome;
    private float valor;
    
    public GestaoCusto(String nome, float valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
}
