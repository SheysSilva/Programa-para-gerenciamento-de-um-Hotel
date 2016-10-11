package hospedagem;

import java.time.LocalDate;

/**
 * Classe que modela um evento de checkout.
 */
public class Transacao {
    /**
     * Data em que o checkout foi realizado. Essa data sempre será a data da criação do objeto.
     */
    private LocalDate dataDoCheckout;

    /**
     * Nome do hóspede que realizou checkout.
     */
    private String nomeDoHospede;

    /**
     * Número do quarto relacionado à estadia do hospede.
     */
    private String descricao;

    /**
     * Total pago pelo hospede ao realizar o checkout.
     */
    private double totalPago;

    /**
     * Construtor do objeto que representa um checkout
     * @param nomeDoHospede Nome do hóspede realizando checkout
     * @param numeroDoQuarto Número do quarto em que o hospede estava
     * @param totalPago
     */
    public Transacao(String nomeDoHospede, String numeroDoQuarto, double totalPago) {
        this.dataDoCheckout = LocalDate.now();
        this.nomeDoHospede = nomeDoHospede;
        this.descricao = numeroDoQuarto;
        this.totalPago = totalPago;
    }

    public LocalDate getDataDoCheckout() {
        return dataDoCheckout;
    }

    public void setDataDoCheckout(LocalDate dataDoCheckout) {
        this.dataDoCheckout = dataDoCheckout;
    }

    public String getNomeDoHospede() {
        return nomeDoHospede;
    }

    public void setNomeDoHospede(String nomeDoHospede) {
        this.nomeDoHospede = nomeDoHospede;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

}
