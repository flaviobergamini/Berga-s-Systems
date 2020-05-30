package model;

import java.util.Date;

/**
 * Esta classe é responsável por gerar as contas, ela é a extensão para as
 * classes ContasAPagar e ContasAReceber
 */
/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public abstract class Contas {

    private String ID;
    private float valor;
    private String nome;
    private String data;

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
     * @param nome Recebe um nome para a conta para poder identifica-la
     * @param valor Recebe o valor dessa conta
     * @param data Recebe a data em formato dd/mm/aaaa em que essa conta foi
     * gerada
     */
    public void criaConta(String nome, float valor, String data) {
        this.nome = nome;
        this.valor = valor;
        this.data = data;
    }

    /**
     *
     * @return Retorna a data da conta em formato dd/mm/aaaa
     */
    public String getData() {
        return this.data;
    }

    /**
     *
     * @return Retorna o nome da conta
     */
    public String getNome() {
        return this.nome;
    }

    /**
     *
     * @return Retorna o valor da conta
     */
    public float getValor() {
        return this.valor;
    }

}
