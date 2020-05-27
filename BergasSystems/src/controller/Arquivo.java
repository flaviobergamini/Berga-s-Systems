/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fhmbe
 */
public class Arquivo implements Serializable {
    Relatorio relatorio;
    OutputStream os;
    BufferedWriter bw;

    public Arquivo() throws FileNotFoundException {
        this.os = new FileOutputStream("Relatorio.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        this.bw = new BufferedWriter(osw);
    }
    
    public void WriteFile(String texto) throws IOException{
       
        for (int i = 0; i < texto.length(); i++) {
            bw.write((int) texto.charAt(i));
        }
        bw.write(13);
        bw.close();
    }
}
