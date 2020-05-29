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
public class ExtratoBancario {
    private String ID;
    private String nome;
    private float entrada;
    
    public ExtratoBancario(String nome, float entrada){
        this.nome = nome;
        this.entrada = entrada;
    }

    public String getNome() {
        return nome;
    }

    public float getEntrada() {
        return entrada;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
}
