package historicocheckout;

import java.time.LocalDate;

/**
 * Classe que modela um evento de checkout.
 */
public class HistoricoCheckout {
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
    private String numeroDoQuarto;

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
    public HistoricoCheckout(String nomeDoHospede, String numeroDoQuarto, double totalPago) {
        this.dataDoCheckout = LocalDate.now();
        this.nomeDoHospede = nomeDoHospede;
        this.numeroDoQuarto = numeroDoQuarto;
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

    public String getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(String numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

}
