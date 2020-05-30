package model;

/**
 * Esta classe recebe os bancos cadastrados junto com seus saldos e nome para
 * identificação
 */
/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class ExtratoBancario {

    private String ID;
    private String nome;
    private float entrada;

    /**
     *
     * @param nome Recebe o nome do banco a qual o saldo da conta bancária se
     * refere
     * @param entrada Recebe o saldo da conta bancária
     */
    public ExtratoBancario(String nome, float entrada) {
        this.nome = nome;
        this.entrada = entrada;
    }

    /**
     *
     * @return Retorna o nome do banco
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Retorna o saldo da conta bancária
     */
    public float getEntrada() {
        return entrada;
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

}
