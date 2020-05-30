/*
 * Recebe todos os gastos básicos para o funcionamento de um estabelecimento, exemplo: agua, energia
 */
package model;

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class GestaoCusto {
    private String ID;
    private String nome;
    private float valor;
    
    /**
     * 
     * @param nome Recebe o nome do custo
     * @param valor Recebe o valor do custo
     */
    public GestaoCusto(String nome, float valor){
        this.nome = nome;
        this.valor = valor;
    }
    
    /**
     * 
     * @return Retorna o nome do custo
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * 
     * @return Retorna o valor do custo
     */
    public float getValor() {
        return valor;
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
