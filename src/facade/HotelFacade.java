package facade;


import Hospedagem.Hospede;
import Hospedagem.Quarto;
import controllers.Recepcao;
import controllers.Restaurante;
import exceptionsmetodos.ExceptionMetodosHotel;
import factory.FactoryQuarto;
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
	
	private Restaurante restaurante;
	private Recepcao recepcao;
	private FactoryQuarto factoryQuarto;
	private ExceptionMetodosHotel exceptionHotel;

	
	public HotelFacade(){
		this.recepcao = new Recepcao();
		this.restaurante  = new Restaurante();
		this.exceptionHotel =  new ExceptionMetodosHotel();
		this.factoryQuarto = new FactoryQuarto();
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
}
