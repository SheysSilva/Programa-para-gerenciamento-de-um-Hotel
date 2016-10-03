package recepcao;

import historicocheckout.FactoryHistoricoCheckout;
import historicocheckout.HistoricoCheckout;
import hospede.FactoryHospede;
import hospede.Hospede;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import quartos.Quarto;
import sistemaexception.AtualizaDataNascimentoHospedeFormatException;
import sistemaexception.AtualizaDataNascimentoNullException;
import sistemaexception.AtualizaEmailHospedeException;
import sistemaexception.AtualizaNomeHospedeException;
import sistemaexception.DataNascimentoNullException;
import sistemaexception.EmailHospedeException;
import sistemaexception.FormatoDataException;
import sistemaexception.HospedeInexistenteException;
import sistemaexception.MenorDeIdadeException;
import sistemaexception.NomeHospedeException;
import sistemaexception.NomeHospedeInvalidoException;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.ValorInvalidoException;
import estadia.Estadia;
import estadia.FactoryEstadia;


public class Recepcao {
	
	private FactoryHospede factoryHospede;
	private FactoryEstadia factoryEstadia;
	private FactoryHistoricoCheckout factoryCheckout;
	private HashMap<String,Hospede> hospedes;
	private HashMap<String, Quarto> quartos;
	private ArrayList<HistoricoCheckout> historico;

	
	public Recepcao(){
		this.factoryHospede = new FactoryHospede();
		this.factoryEstadia = new FactoryEstadia();
		this.factoryCheckout = new FactoryHistoricoCheckout();
		this.hospedes = new HashMap<String,Hospede>();
		this.historico =  new ArrayList<HistoricoCheckout> ();

	}
	
	public String cadastraHospede(String nome, String email, String anoNascimento) throws NomeHospedeInvalidoException, NomeHospedeException, EmailHospedeException, FormatoDataException, DataNascimentoNullException, MenorDeIdadeException, ParseException {
		this.hospedes.put(email, this.factoryHospede.criarHospede(nome, email, anoNascimento));
		return email;
	}
	
	public void removerHospede(String email) throws HospedeInexistenteException {
		if(this.hospedes.containsKey(email)){
			this.hospedes.remove(email);
		} else{
			throw new HospedeInexistenteException();
		}
	}

	public Hospede buscaHospede(String email) throws HospedeInexistenteException {
		if(this.hospedes.containsKey(email)){
			return this.hospedes.get(email);
		}else{
			throw new HospedeInexistenteException();
		}
	}

	public String atualizaCadastroNome(String email, String nome) throws AtualizaNomeHospedeException, HospedeInexistenteException{
		this.buscaHospede(email).setNome(nome);
		return this.buscaHospede(email).getNome();
		
	}
	
	public String atualizaCadastroEmail(String email, String novoEmail) throws AtualizaEmailHospedeException, HospedeInexistenteException{
		this.buscaHospede(email).setEmail(novoEmail);
		return this.buscaHospede(email).getEmail();
	}
	
	public String atualizaCadastroData(String email, String data) throws AtualizaDataNascimentoHospedeFormatException, DataNascimentoNullException, AtualizaDataNascimentoNullException, ParseException, HospedeInexistenteException{
		this.buscaHospede(email).setDataNascimento(data);
		return this.buscaHospede(email).getAnoNascimento();
	}
	
	public void realizaCheckin(String email, int quantDias, Quarto quarto) throws HospedeInexistenteException, ValorInvalidoException, ObjetoNullException, QuartoInexistenteException {
		if(this.hospedes.containsKey(email)){
			if(this.quartos.get(quarto.getNumeroDoQuarto()).isEstadoQuarto()){
				this.buscaHospede(email).adicionaEstadia(this.criaEstadia(quarto, quantDias));
			}
		}
	}
	
	public String checkout(String email, double pagamento) throws ValorInvalidoException, HospedeInexistenteException{
		
		double totalPago = 0;
		
		if(this.hospedes.containsKey(email)) {
			for(Estadia estadia: this.buscaHospede(email).getEstadias()) {
				totalPago += estadia.getValorTotal();
				estadia.getQuarto().setEstadoQuarto(false);
				this.buscaHospede(email).removeEstadia(estadia, pagamento);
				HistoricoCheckout checkout = this.factoryCheckout.criaCheckout(buscaHospede(email).getNome(), estadia.getQuarto().getNumeroDoQuarto(), estadia.getValorTotal());
				this.historico.add(checkout);
			}
		}
		return "Total Pago: " + totalPago;
	}
	
	public void removeHospede(String email){
		
	}
	public String getInfoHospedagem(String email, String atributo) throws HospedeInexistenteException {
		String retorno = null;
		switch(atributo) {
			case "Hospedagens ativas":
				retorno = this.getHospedagensAtivas(email);
			case "Quarto":
				retorno = this.getQuarto(email);
			case "Total":
				retorno = this.getTotalPago(email);
		}
		return retorno;
	}

	private String getQuarto(String email) throws HospedeInexistenteException {
		Hospede hospede = buscaHospede(email);
		for(Estadia estadia: hospede.getEstadias())
			return estadia.getQuarto().getNumeroDoQuarto();
		return null;
	}

	private String getTotalPago(String email) throws HospedeInexistenteException {
		Hospede hospede = buscaHospede(email);
		return "R$: " + String.valueOf(hospede.getDebito());
	}

	private String getHospedagensAtivas(String email) throws HospedeInexistenteException {
		Hospede hospede = buscaHospede(email);
		return String.valueOf(hospede.getEstadias().size());
	}
	
	private Estadia criaEstadia(Quarto quarto, int quantDias) throws ValorInvalidoException, QuartoInexistenteException, ObjetoNullException{
		return this.factoryEstadia.criaEstadia(quarto, quantDias);
	}
}
