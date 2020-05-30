package model;


/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class ContasAReceber extends Contas {

    private float contasReceber;
    private float contasRecebidas;

    /**
     *
     * @param nome Recebe um nome para a conta para poder identifica-la
     * @param contasReceber Recebe um valor a ser pago pelo cliente, ou recebe 0
     * caso ela já tenha sido paga
     * @param contasRecebidas Recebe um valor indicando que foi paga, ou recebe
     * 0 caso ela ainda não foi paga
     * @param data Recebe a data em formato dd/mm/aaaa em que essa conta foi
     * gerada
     */
    public ContasAReceber(String nome, float contasReceber, float contasRecebidas, String data) {
        this.contasReceber = contasReceber;
        this.contasRecebidas = contasRecebidas;
        this.criaConta(nome, 0, data);
    }
    
     /**
     *
     * @return Retorna o valor da conta a ser recebida
     */
    public float getContasReceber() {
        return contasReceber;
    }
    
    /**
     *
     * @return retorna o valor da conta recebida
     */
    public float getContasRecebidas() {
        return contasRecebidas;
    }
}
