package factory;

import Hospedagem.Transacao;

public class FactoryTransacao {

	public Transacao criaCheckout(String nomeDoHospede, String numeroDoQuarto, double totalPago){
		return new Transacao(nomeDoHospede, numeroDoQuarto, totalPago);
	}
}
