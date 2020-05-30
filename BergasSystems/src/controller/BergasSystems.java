package controller;

import view.Tela1;

/**
 *
 * A proposta desse trabalho é uma aplicação simples de um sistema financeiro
 * para pequenas empresas e pode inclusive ser utilisado para uso pessoal para
 * poder mellhor ornanizar as contas domésticas. Este é um projeto final para as
 * disciplinas de Programação Orientada a Objetos e Banco de Dados
 */
/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 *
 */
public class BergasSystems {

    /**
     *
     * Método principal, onde inicia a interface gráfica chamando a primeira
     * tela. Esta tela cujo nome é Tela1, se encontra no pacote view deste
     * projeto.
     *
     */
    public static void main(String[] args) {

        new Tela1().setVisible(true);
    }

}
