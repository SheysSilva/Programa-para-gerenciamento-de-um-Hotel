package facade;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import controllers.Recepcao;
import controllers.RestauranteController;
import exceptionsmetodos.ExceptionMetodosHotel;
import factory.FactoryQuarto;
import hospedagem.Hospede;
import hospedagem.Quarto;
import sistemaexception.AtualizaCadastroException;
import sistemaexception.CadastroHospedeException;
import sistemaexception.ChecarHospedagemException;
import sistemaexception.CheckoutException;
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


public class HotelFacade {
	
	private RestauranteController restaurante;
	private Recepcao recepcao;
	private FactoryQuarto factoryQuarto;
	private ExceptionMetodosHotel exceptionHotel;

	
	public HotelFacade(){
		this.recepcao = new Recepcao();
		this.restaurante  = new RestauranteController();
		this.exceptionHotel =  new ExceptionMetodosHotel();
		this.factoryQuarto = new FactoryQuarto();
	}
	
	public void iniciaSistema(){
	}
	
	private Quarto criaQuarto(String tipoQuarto, String numQuarto) throws QuartoInexistenteException, ValorInvalidoException, ObjetoNullException {
		return this.factoryQuarto.criaQuarto(tipoQuarto, numQuarto);
	}
	
	public String cadastraHospede(String nome, String email, String anoNascimento) throws CadastroHospedeException  {
		return this.recepcao.cadastraHospede(nome, email, anoNascimento);
	}
	
	public void removeHospede(String email) throws RemocaoHospedeException, HospedeInexistenteException{
		this.recepcao.removerHospede(email);
	}
	
	public Hospede buscaHospede(String email) throws HospedeInexistenteException   {
		return this.recepcao.buscaHospede(email);
	}
		
	public void getInfoHospedagem(String email, String Hospedagem) throws ChecarHospedagemException, CheckoutException, HospedeInexistenteException, GetInfoHospedagemException  {
		this.exceptionHotel.exceptionGetInfoHospedagens(email);
		this.recepcao.getInfoHospedagem(email, Hospedagem);
	}
	public String getInfoHospede(String email, String atributo) throws GetInfoHospede, HospedeInexistenteException {
		return this.recepcao.getInfoHospede(email, atributo);
	}
	
	public void realizaCheckin(String email, int quantDias, String numQuarto, String tipo) throws ChekinException, QuartoInexistenteException, ObjetoNullException, HospedeInexistenteException, ValorInvalidoException {
		this.exceptionHotel.exceptionChekin(email, quantDias, numQuarto);
		this.recepcao.realizaCheckin(email, quantDias,this.criaQuarto(tipo, numQuarto));
	}
	
	public String realizarCheckout(String email, String numQuarto) throws CheckoutException, HospedeInexistenteException  {
		this.exceptionHotel.exceptionCheckout(email, numQuarto);
		return this.recepcao.realizacheckout(email, numQuarto);
    }

	public String atualizaCadastro(String email, String atributo, String valor) throws AtualizaCadastroException, HospedeInexistenteException {
		return this.recepcao.atualizaCadastro(email, atributo, valor);
	}
	
	public String consultaTransacoes(String tipo) throws TransacaoException {
		return this.recepcao.consultaTransacoes(tipo);
	}
	
	public String consultaTransacoes(String tipo, int indice) throws TransacaoException  {
		this.exceptionHotel.exceptionIndiceInvalido(indice);
		return this.consultaTransacoes(tipo, indice);
	}
	
	public void cadastraPrato(String nome, double preco, String especificacao) throws Exception  {
		restaurante.cadastraPrato(nome, preco, especificacao);
	}
	
	public String consultaRestaurante(String nome, String atributo) throws Exception{
		return restaurante.consultaRestaurante(nome, atributo);
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception{
		restaurante.cadastraRefeicao(nome, descricao, componentes);
	}
	
	public void ordenaMenu(String tipoOrdenacao) throws Exception{
		restaurante.ordenaMenu(tipoOrdenacao);
	}
	
	public String consultaMenuRestaurante(){
		return restaurante.consultaMenuRestaurante();
	}
	
	public String realizaPedido(String email, String itemMenu) throws Exception{
		return restaurante.realizaPedido(email, itemMenu);
	}
	
	public String convertePontos(String email, int pontos) throws HospedeInexistenteException, PontosInsuficientesException {
		return recepcao.convertePontos(email, pontos);
	}
	
	
	@Override
	public String toString(){
		return  "======================================================" 
				+ "\n" + this.recepcao.toStringCadastro() + "\n"
				+ "======================================================"
				+ "\n" + this.restaurante.toString() + "\n"
				+ "======================================================"
				+ "\n" + this.recepcao.toStringTransacao();
	
	}
	
	public void fechaSistema() throws IOException{
		//Diretorio
		File diretorio = new File("historico");
		diretorio.mkdir();
		
		//Criando arquivo txt
		File hospede = new File("historico/cad_hospedes.txt");
		hospede.createNewFile();
		
		File restaurante = new File("historico/cad_restaurante.txt");
		restaurante.createNewFile();
		
		File transacao = new File("historico/cad_transacoes.txt");
		transacao.createNewFile();
		
		File principal = new File("historico/hotel_principal.txt");
		principal.createNewFile();
		
		//File
		FileWriter escreve_hospede = new FileWriter(hospede);
		
		FileWriter escreve_restaurante = new FileWriter(restaurante);
		
		FileWriter escreve_transacao = new FileWriter(transacao);
		
		FileWriter escreve_principal = new FileWriter(principal);
		
		//Buffer
		BufferedWriter buffer_hospede =  new BufferedWriter(escreve_hospede);
		buffer_hospede.write(this.recepcao.toStringCadastro());
		
		BufferedWriter buffer_restaurante =  new BufferedWriter(escreve_restaurante);
		buffer_restaurante.write(this.restaurante.toString());
		
		BufferedWriter buffer_transacao =  new BufferedWriter(escreve_transacao);
		buffer_transacao.write(this.recepcao.toStringTransacao());
		
		BufferedWriter buffer_principal =  new BufferedWriter(escreve_principal);
		buffer_principal.write(this.recepcao.toString());
		
		//Fechando
		buffer_hospede.close();
		buffer_restaurante.close();
		buffer_transacao.close();
		buffer_principal.close();
		
		escreve_hospede.close();
		escreve_restaurante.close();
		escreve_transacao.close();
		escreve_principal.close();
		
		
	}
}
