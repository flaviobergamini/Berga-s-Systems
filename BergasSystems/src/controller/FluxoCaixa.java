package controller;

/**
 * Esta classe recebe os valores já calculados pelas telas e organiza todo o
 * fechamento de caixa
 */

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class FluxoCaixa {

    private String ID;
    private String nome;
    private float credito;
    private float debito;
    private String data;

    /**
     *
     * @param nome Recebe um nome para o fluxo de caixa para poder identifica-lo
     * @param credito Recebe o lucro se houver, caso não aja, é preenchido com 0
     * @param debito Recebe o prejuízo se houver, caso não aja, é preenchido com
     * 0
     * @param data Recebe a data em formato dd/mm/aaaa para poder identifica-lo
     */
    public FluxoCaixa(String nome, float credito, float debito, String data) {
        this.nome = nome;
        this.credito = credito;
        this.debito = debito;
        this.data = data;
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
     * @return Retorna a data do Fluxo de Caixa em formato dd/mm/aaaa
     */
    public String getData() {
        return this.data;
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
     * @return Retorna o crédito de um Fluxo de Caixa
     */
    public float getCredito() {
        return credito;
    }

    /**
     *
     * @return Retorna o débito de um Fluxo de Caixa
     */
    public float getDebito() {
        return debito;
    }

}
