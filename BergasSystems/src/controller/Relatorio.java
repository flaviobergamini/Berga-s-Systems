package controller;

import java.util.Date;

/**
 * Esta Classe recebe os fluxos de caixas e gera um relatório com os valores do
 * fechamento de caixa
 */
/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class Relatorio {

    private String nome;
    private float debito;
    private float credito;
    private String data;
    private String ID;

    /**
     *
     * @param nome Recebe um nome para o fluxo de caixa para poder identifica-lo
     * @param credito Recebe o lucro se houver, caso não aja, é preenchido com 0
     * @param debito Recebe o prejuízo se houver, caso não aja, é preenchido com
     * 0
     */
    public Relatorio(String nome, float credito, float debito) {
        this.nome = nome;
        this.credito = credito;
        this.debito = debito;
    }

    /**
     *
     * @return Retorna o ID vindo da tabela do banco de dados
     */
    public String getID() {
        return ID;
    }

    /**
     *
     * @param ID Recebe o ID vindo da tabela do banco de dados pelos métodos da
     * classe BancoDeDados
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     *
     * @return Retorna o nome atribuído ao Fluxo de Caixa
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Retorna o débito de um Fluxo de Caixa
     */
    public float getDebito() {
        return debito;
    }

    /**
     *
     * @return Retorna o crédito de um Fluxo de Caixa
     */
    public float getCredito() {
        return credito;
    }

    /**
     *
     * @param data Recebe o parametro data to formato dd/mm/aaaa para
     * identificar o relatório
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return Retorna a data do Fluxo de Caixa em formato dd/mm/aaaa
     */
    public String getData() {
        return data;
    }

}
