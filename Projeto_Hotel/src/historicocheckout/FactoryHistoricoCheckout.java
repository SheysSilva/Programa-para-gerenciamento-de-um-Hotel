package historicocheckout;

public class FactoryHistoricoCheckout {

	public Transacao criaCheckout(String nomeDoHospede, String numeroDoQuarto, double totalPago){
		return new Transacao(nomeDoHospede, numeroDoQuarto, totalPago);
	}
}
