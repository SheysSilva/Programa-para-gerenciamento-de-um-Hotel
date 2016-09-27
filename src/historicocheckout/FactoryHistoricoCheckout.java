package historicocheckout;

public class FactoryHistoricoCheckout {

	public HistoricoCheckout criaCheckout(String nomeDoHospede, String numeroDoQuarto, double totalPago){
		return new HistoricoCheckout(nomeDoHospede, numeroDoQuarto, totalPago);
	}
}
