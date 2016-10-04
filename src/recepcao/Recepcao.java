package recepcao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import estadia.Estadia;
import estadia.FactoryEstadia;
import historicocheckout.FactoryHistoricoCheckout;
import historicocheckout.Transacao;
import hospede.FactoryHospede;
import hospede.Hospede;
import quartos.Quarto;
import sistemaexception.AtualizaDataNascimentoHospedeFormatException;
import sistemaexception.AtualizaDataNascimentoNullException;
import sistemaexception.AtualizaEmailHospedeException;
import sistemaexception.AtualizaMenorDeIdadeException;
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
import sistemaexception.QuartoInvalidoException;
import sistemaexception.ValorInvalidoException;


public class Recepcao {
	
	private FactoryHospede factoryHospede;
	private FactoryEstadia factoryEstadia;
	private FactoryHistoricoCheckout factoryCheckout;
	private HashMap<String,Hospede> hospedes;
	private HashSet<Quarto> ocupado;
	private HashSet<Quarto> desocupado;
	private ArrayList<Transacao> historico;
	
	
	public Recepcao(){
		this.factoryHospede = new FactoryHospede();
		this.factoryEstadia = new FactoryEstadia();
		this.factoryCheckout = new FactoryHistoricoCheckout();
		this.hospedes = new HashMap<String,Hospede>();
		this.desocupado = new HashSet<Quarto>();
		this.ocupado = new HashSet< Quarto>();
		this.historico =  new ArrayList<Transacao> ();
		

	}
	
	public String cadastraHospede(String nome, String email, String anoNascimento) throws NomeHospedeInvalidoException, NomeHospedeException, EmailHospedeException, FormatoDataException, DataNascimentoNullException, MenorDeIdadeException, ParseException {
		this.hospedes.put(email, this.factoryHospede.criarHospede(nome, email, anoNascimento));
		return email;
	}
	
	public void removerHospede(String email) throws HospedeInexistenteException {
		if (email == null || email.trim().isEmpty()) {
				throw new HospedeInexistenteException("Erro na remocao do Hospede. Formato de email invalido.");
			}
		
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
				throw new HospedeInexistenteException("Erro na remocao do Hospede. Formato de email invalido.");
		}
		

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
			throw new HospedeInexistenteException("Erro na consulta de hospede. Hospede de email " + email + " nao foi cadastrado(a).");
		}
	}

	public String atualizaCadastroNome(String email, String nome) throws AtualizaNomeHospedeException, HospedeInexistenteException{
		this.buscaHospede(email).setNome(nome);
		return this.buscaHospede(email).getNome();
	}
	
	public String atualizaCadastroEmail(String email, String novoEmail) throws AtualizaEmailHospedeException, HospedeInexistenteException{
		Hospede hospede = this.buscaHospede(email);
		hospede.setEmail(novoEmail);
		this.hospedes.remove(email);
		this.hospedes.put(hospede.getEmail(), hospede);
		return this.buscaHospede(novoEmail).getEmail();
	}
	
	public String atualizaCadastroData(String email, String data) throws AtualizaDataNascimentoNullException, AtualizaDataNascimentoHospedeFormatException, AtualizaMenorDeIdadeException, HospedeInexistenteException {
		this.buscaHospede(email).setDataNascimento(data);
		return this.buscaHospede(email).getAnoNascimento();
	}
	
	public void realizaCheckin(String email, int quantDias, Quarto quarto) throws QuartoInexistenteException, ValorInvalidoException, ObjetoNullException, HospedeInexistenteException, QuartoInvalidoException  {
		this.insereQuartoLista(quarto);

		if(this.desocupado.contains(quarto)){
			if(this.hospedes.containsKey(email)){
				this.buscaHospede(email).adicionaEstadia(this.criaEstadia(quarto, quantDias));
				this.ocupado.add(quarto);
				this.desocupado.remove(quarto);
				
			}else{
				throw new HospedeInexistenteException("Erro ao realizar checkin. Hospede de email "+ email +" nao foi cadastrado(a).");
			}
		}else{
			throw new QuartoInvalidoException("Erro ao realizar checkin. Quarto " + quarto.getNumeroDoQuarto() + " ja esta ocupado.");	
		}
	}
	
	private void insereQuartoLista(Quarto quarto) throws QuartoInexistenteException, ValorInvalidoException, ObjetoNullException  {
		if(!(this.desocupado.contains(quarto)) && !(this.ocupado.contains(quarto))){
			this.desocupado.add(quarto);	
		}
	}

	public String realizacheckout(String email, String numquarto) throws ValorInvalidoException, HospedeInexistenteException, QuartoInvalidoException{
		
		double totalPago = 0;
		
		if(this.hospedes.containsKey(email)) {
			this.buscaHospede(email).getEstadias();;
			Iterator<Estadia> iterator =this.buscaHospede(email).getEstadias().iterator();
			while(iterator.hasNext()) {
				Estadia estadia = iterator.next();
				if(estadia.getQuarto().getNumeroDoQuarto().equals(numquarto)){
					totalPago += estadia.getValorTotal();
					Transacao checkout = this.factoryCheckout.criaCheckout(buscaHospede(email).getNome(), estadia.getQuarto().getNumeroDoQuarto(), estadia.getValorTotal());
					this.historico.add(checkout);
					this.desocupado.add(estadia.getQuarto());
					this.ocupado.remove(estadia.getQuarto());
					iterator.remove();	
					}
				}
		}else{
			throw new HospedeInexistenteException();
		}
		return String.format("R$%.2f", totalPago);
	}
	
	public String getInfoHospedeNome(String email) throws HospedeInexistenteException{
		return this.buscaHospede(email).getNome();
		
	}
	
	public String getInfoHospedeEmail(String email) throws HospedeInexistenteException{
		return this.buscaHospede(email).getEmail();
		
	}
	
	public String getInfoHospedeDataNascimento(String email) throws HospedeInexistenteException{
		return this.buscaHospede(email).getAnoNascimento();
	}
	
	public String transacaoTotal(){
		double total = 0;
		for(Transacao checkout: this.historico){
			total += checkout.getTotalPago();
		}
		
		return String.format("R$%.2f", total);
	}
	
	public String transacaoQuantidade(){
		return String.valueOf(this.historico.size()) ;
		
	}
	public String transacaoNome(){
		String nomes = "";
		for(int i = 0; i < this.historico.size() -1; i++){
			nomes = nomes + this.historico.get(i).getNomeDoHospede() + ";";
		}
		nomes = nomes + this.historico.get(this.historico.size() - 1).getNomeDoHospede();
		return nomes;
	}
	
	public String transacaoTotal(int indice){
		double total = this.historico.get(indice).getTotalPago();
		return String.format("R$%.2f", total);
	}
	
	public String transacaoNome(int indice){
		return this.historico.get(indice).getNomeDoHospede();
	}
	public void removeHospede(String email){
		
	}
	

	public String getQuarto(String email) throws HospedeInexistenteException {
		Hospede hospede = buscaHospede(email);
		for(Estadia estadia: hospede.getEstadias())
			return estadia.getQuarto().getNumeroDoQuarto();
		return null;
	}

	public String getTotalPago(String email) throws HospedeInexistenteException {
		Hospede hospede = buscaHospede(email);
		return "R$: " + String.valueOf(hospede.getDebito());
	}

	public String getHospedagensAtivas(String email) throws HospedeInexistenteException {
		Hospede hospede = buscaHospede(email);
		return String.valueOf(hospede.getEstadias().size());
	}
	
	private Estadia criaEstadia(Quarto quarto, int quantDias) throws ValorInvalidoException, QuartoInexistenteException, ObjetoNullException{
		return this.factoryEstadia.criaEstadia(quarto, quantDias);
	}

	
}
