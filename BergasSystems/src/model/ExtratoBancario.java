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
    private String nome;
    private float entrada;
    private float saida;
    
    public ExtratoBancario(String nome, float entrada, float saida){
        this.nome = nome;
        this.entrada = entrada;
        this.saida = saida;
    }
}
