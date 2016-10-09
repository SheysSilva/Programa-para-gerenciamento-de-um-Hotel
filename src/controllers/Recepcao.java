package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import Hospedagem.Estadia;
import Hospedagem.Hospede;
import Hospedagem.Quarto;
import Hospedagem.Transacao;
import exceptionsmetodos.ExceptionMetodosRecepcao;
import factory.FactoryEstadia;
import factory.FactoryHospede;
import factory.FactoryTransacao;
import sistemaexception.AtualizaCadastroException;
import sistemaexception.CadastroHospedeException;
import sistemaexception.ChekinException;
import sistemaexception.GetInfoHospedagemException;
import sistemaexception.GetInfoHospede;
import sistemaexception.HospedeInexistenteException;
import sistemaexception.ObjetoNullException;
import sistemaexception.PontosInsuficientesException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.RemocaoHospedeException;
import sistemaexception.TransacaoException;
import sistemaexception.ValorInvalidoException;


public class Recepcao {
	
	private FactoryHospede factoryHospede;
	private FactoryEstadia factoryEstadia;
	private FactoryTransacao factoryTransacao;
	private HashMap<String,Hospede> hospedes;
	private HashSet<Quarto> ocupado;
	private HashSet<Quarto> desocupado;
	private ArrayList<Transacao> historico;
	private ExceptionMetodosRecepcao exceptionRecepcao;
	
	
	public Recepcao(){
		this.factoryHospede = new FactoryHospede();
		this.factoryEstadia = new FactoryEstadia();
		this.factoryTransacao = new FactoryTransacao();
		this.hospedes = new HashMap<String,Hospede>();
		this.desocupado = new HashSet<Quarto>();
		this.ocupado = new HashSet< Quarto>();
		this.historico =  new ArrayList<Transacao> ();
		this.exceptionRecepcao = new ExceptionMetodosRecepcao();

	}
	
	public String cadastraHospede(String nome, String email, String anoNascimento) throws CadastroHospedeException  {
		this.hospedes.put(email, this.factoryHospede.criarHospede(nome, email, anoNascimento));
		return email;
	}
	
	public void removerHospede(String email) throws HospedeInexistenteException, RemocaoHospedeException {
		this.exceptionRecepcao.exceptionRemoverHospede(email);
		if(this.hospedes.containsKey(email)){
			this.hospedes.remove(email);
		} else{
			throw new HospedeInexistenteException();
		}
	}

	public Hospede buscaHospede(String email) throws HospedeInexistenteException  {
		if(this.hospedes.containsKey(email)){
			return this.hospedes.get(email);
		}else{
			throw new HospedeInexistenteException("Erro na consulta de hospede. Hospede de email " + email + " nao foi cadastrado(a).");
		}
	}
	public String atualizaCadastro(String email, String atributo, String valor) throws AtualizaCadastroException, HospedeInexistenteException  {
		String[] str = atributo.toUpperCase().split(" ");
		switch(str[0]){
			case "DATA":
				return this.atualizaCadastroData(email, valor);
			case "NOME":
				return this.atualizaCadastroNome(email, valor);
			case "EMAIL":
				return this.atualizaCadastroEmail(email, valor);
			default:
				throw new AtualizaCadastroException();
		}
	}
	private String atualizaCadastroNome(String email, String nome) throws AtualizaCadastroException, HospedeInexistenteException {
		this.buscaHospede(email).setNome(nome);
		return this.buscaHospede(email).getNome();
	}
	
	private String atualizaCadastroEmail(String email, String novoEmail) throws HospedeInexistenteException, AtualizaCadastroException {
		Hospede hospede = this.buscaHospede(email);
		hospede.setEmail(novoEmail);
		this.hospedes.remove(email);
		this.hospedes.put(hospede.getEmail(), hospede);
		return this.buscaHospede(novoEmail).getEmail();
	}
	
	private String atualizaCadastroData(String email, String data) throws AtualizaCadastroException, HospedeInexistenteException  {
		this.buscaHospede(email).setDataNascimento(data);
		return this.buscaHospede(email).getAnoNascimento();
	}
	
	public void realizaCheckin(String email, int quantDias, Quarto quarto) throws ObjetoNullException, HospedeInexistenteException, ChekinException, QuartoInexistenteException, ValorInvalidoException  {
		this.insereQuartoLista(quarto);

		if(this.desocupado.contains(quarto)){
			if(this.hospedes.containsKey(email)){
				this.buscaHospede(email).adicionaEstadia(this.criaEstadia(quarto, quantDias));
				this.ocupado.add(quarto);
				this.desocupado.remove(quarto);
				
			}else{
				throw new HospedeInexistenteException(new ChekinException() + " Hospede de email "+ email +" nao foi cadastrado(a).");
			}
		}else{
			throw new ChekinException(new ChekinException() + " Quarto " + quarto.getNumeroDoQuarto() + " ja esta ocupado.");	
		} 
	}
	
	private void insereQuartoLista(Quarto quarto) {
		if(!(this.desocupado.contains(quarto)) && !(this.ocupado.contains(quarto))){
			this.desocupado.add(quarto);	
		}
	}

	public String realizacheckout(String email, String numquarto) throws HospedeInexistenteException {
		double totalPago = 0;
		
		if(this.hospedes.containsKey(email)) {
			this.buscaHospede(email).getEstadias();;
			Iterator<Estadia> iterator =this.buscaHospede(email).getEstadias().iterator();
			while(iterator.hasNext()) {
				Estadia estadia = iterator.next();
				if(estadia.getQuarto().getNumeroDoQuarto().equals(numquarto)){
					totalPago += estadia.getValorTotal();
					Transacao checkout = this.factoryTransacao.criaCheckout(buscaHospede(email).getNome(), estadia.getQuarto().getNumeroDoQuarto(), estadia.getValorTotal());
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
	
	public String consultaTransacoes(String tipo) throws TransacaoException  {
		switch(tipo.trim().toUpperCase()){
			case "TOTAL":
				return this.transacaoTotal();
			case "QUANTIDADE":
				return this.transacaoQuantidade();
			case "NOME":
				return this.transacaoNome();
			default:
				throw new TransacaoException();
		}	
	}
	
	private String transacaoTotal(){
		double total = 0;
		for(Transacao checkout: this.historico){
			total += checkout.getTotalPago();
		}
		
		return String.format("R$%.2f", total);
	}
	
	private String transacaoQuantidade(){
		return String.valueOf(this.historico.size()) ;
		
	}
	private String transacaoNome(){
		String nomes = "";
		for(int i = 0; i < this.historico.size() -1; i++){
			nomes = nomes + this.historico.get(i).getNomeDoHospede() + ";";
		}
		nomes = nomes + this.historico.get(this.historico.size() - 1).getNomeDoHospede();
		return nomes;
	}
	
	public String consultaTransacoes(String tipo, int indice) throws TransacaoException {
		switch(tipo.trim().toUpperCase()){
		case "TOTAL":
			return this.transacaoTotal(indice);
		case "NOME":
			return this.transacaoNome(indice);
		default:
			throw new TransacaoException();
		}
	}
	private String transacaoTotal(int indice){
		return String.format("R$%.2f", this.historico.get(indice).getTotalPago());
	}
	
	private String transacaoNome(int indice){
		return this.historico.get(indice).getNomeDoHospede();
	}
	
	private Estadia criaEstadia(Quarto quarto, int quantDias) throws QuartoInexistenteException, ValorInvalidoException, ObjetoNullException {
		return this.factoryEstadia.criaEstadia(quarto, quantDias);
	}
	
	private String getInfoQuarto(String email) throws HospedeInexistenteException   {
		String str = "";
		int i = 0;
		for(Estadia estadia: buscaHospede(email).getEstadias()){
			if(i < buscaHospede(email).getEstadias().size() -1){
				i += 1;
				str = str + estadia.getQuarto().getNumeroDoQuarto() + "," ;
			}else{
				str =  str + estadia.getQuarto().getNumeroDoQuarto();
			}
		}
		return str;
	}
	
	private String getInfoTotalPago(String email) throws HospedeInexistenteException {
		double total = 0;
		for(Estadia estadia: buscaHospede(email).getEstadias()){
			total = total + estadia.getValorTotal();
		}
		return  String.format("R$%.2f", total);
	}

	private String getInfoHospedagensAtivas(String email) throws HospedeInexistenteException  {
		return String.valueOf(buscaHospede(email).getEstadias().size());
	}
	
	public String getInfoHospedagem(String email, String atributo) throws HospedeInexistenteException, GetInfoHospedagemException {	
		String[] str = atributo.toUpperCase().split(" ");
		switch(str[0]){
			case "HOSPEDAGENS":
				return this.getInfoHospedagensAtivas(email);
			case "QUARTO":
				return this.getInfoQuarto(email);
			case "TOTAL":
				return this.getInfoTotalPago(email);
			default:
				throw new GetInfoHospedagemException();
		}
		
	}
	
	public String getInfoHospede(String email, String atributo) throws GetInfoHospede, HospedeInexistenteException   {
		String[] str = atributo.toUpperCase().split(" ");
		switch(str[0]){
			case "DATA":
				return this.getInfoHospedeDataNascimento(email);
			case "NOME":
				return this.getInfoHospedeNome(email);
			case "EMAIL":
				return this.getInfoHospedeEmail(email);
			default:
				throw new GetInfoHospede(new GetInfoHospede() + " Hospede de " + email + " nao foi cadastrado(a).");
		}
	}
	
	public String convertePontos(String email, int pontos) throws HospedeInexistenteException, PontosInsuficientesException  {
		if(this.buscaHospede(email).verificaPontos(pontos)){
			this.buscaHospede(email).setPontos(this.buscaHospede(email).getPontos() - pontos);
			return this.buscaHospede(email).getCartao().convertePontos(pontos);
		}else{
			throw new PontosInsuficientesException();
		}
	}
	
	private String getInfoHospedeNome(String email) throws HospedeInexistenteException{
		return this.buscaHospede(email).getNome();
		
	}
	
	private String getInfoHospedeEmail(String email) throws HospedeInexistenteException {
		return this.buscaHospede(email).getEmail();
		
	}
	
	private String getInfoHospedeDataNascimento(String email) throws HospedeInexistenteException   {
		return this.buscaHospede(email).getAnoNascimento();
	}
	
	
	@Override
	public String toString(){
		String retorno = "Cadastro de Hospedes: " + this.hospedes.size() + " hospedes registrados";
		int i = 0;
		for(String chave: this.hospedes.keySet()){
			retorno += "\n==> Hospede " + i+1 +":" + 
					"\n" + this.hospedes.get(chave).toString() + "\n";
		}
		
		return retorno;
	}
	
}
