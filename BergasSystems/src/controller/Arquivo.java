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
 * Esta classe recebe textos e faz a escrita em arquivo, é usada para receber os
 * textos fornecidos pelos relatórios
 */

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class Arquivo implements Serializable {

    Relatorio relatorio;
    OutputStream os;
    BufferedWriter bw;

    /**
     *
     * @throws FileNotFoundException Quando está utilizandoum arquivo e
     * eventualmente ele é excluido, este construtor acusa um erro
     */
    public Arquivo() throws FileNotFoundException {
        this.os = new FileOutputStream("Relatorio.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        this.bw = new BufferedWriter(osw);
    }

    /**
     *
     * @param texto Recebe o texto que se deseja escrever no arquivo
     * @throws IOException Erros de entrada ou saída
     */
    public void WriteFile(String texto) throws IOException {

        for (int i = 0; i < texto.length(); i++) {
            bw.write((int) texto.charAt(i));
        }
        bw.write(13);
        bw.close();
    }
}
