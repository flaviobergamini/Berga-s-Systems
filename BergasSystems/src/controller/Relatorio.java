/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;

/**
 *
 * @author fhmbe
 */
public class Relatorio {
    private String nome;
    private float debito;
    private float credito;
    private String data;
    Date dataUp = new Date();
    
    public Relatorio(String nome, float credito, float debito){
        this.nome = nome;
        this.credito = credito;
        this.debito = debito;
        this.data = dataUp.toString();
    }
}
