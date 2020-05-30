package model;

/**
 *
 * @author Flávio Henrique Madureira Bergamini - estudante de Engenharia da
 * Computação no Inatel
 */
public class ContasAPagar extends Contas {

    private float contasPagar;
    private float contasPagas;

    /**
     *
     * @param nome Recebe um nome para a conta para poder identifica-la
     * @param contasPagar Recebe um valor a ser pago, ou recebe 0 caso ela já
     * tenha sido paga
     * @param contasPagas Recebe um valor indicando que foi paga, ou recebe 0
     * caso ela ainda não foi paga
     * @param data Recebe a data em formato dd/mm/aaaa em que essa conta foi
     * gerada
     */
    public ContasAPagar(String nome, float contasPagar, float contasPagas, String data) {
        this.contasPagar = contasPagar;
        this.contasPagas = contasPagas;
        this.criaConta(nome, 0, data);
    }

    /**
     *
     * @return Retorna o valor da conta a ser paga
     */
    public float getContasPagar() {
        return contasPagar;
    }

    /**
     *
     * @return retorna o valor da conta paga
     */
    public float getContasPagas() {
        return contasPagas;
    }
}
