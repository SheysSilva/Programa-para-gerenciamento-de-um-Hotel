package facade;


import java.text.ParseException;

import Hospedagem.Hospede;
import Hospedagem.Quarto;
import controllers.Recepcao;
import controllers.Restaurante;
import exceptionsmetodos.ExceptionMetodosHotel;
import factory.FactoryQuarto;
import sistemaexception.AtualizaCadastroException;
import sistemaexception.AtualizaDataNascimentoHospedeFormatException;
import sistemaexception.AtualizaDataNascimentoNullException;
import sistemaexception.AtualizaEmailHospedeException;
import sistemaexception.AtualizaMenorDeIdadeException;
import sistemaexception.AtualizaNomeHospedeException;
import sistemaexception.DataNascimentoNullException;
import sistemaexception.EmailHospedeException;
import sistemaexception.FormatoDataException;
import sistemaexception.GetInfoHospedagemException;
import sistemaexception.GetInfoHospede;
import sistemaexception.HospedeInexistenteException;
import sistemaexception.MenorDeIdadeException;
import sistemaexception.NomeHospedeException;
import sistemaexception.NomeHospedeInvalidoException;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.QuartoInvalidoException;
import sistemaexception.TransacaoException;
import sistemaexception.ValorInvalidoException;
import sistemaexception.pontosInsuficientesException;



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
	
	private Quarto criaQuarto(String tipoQuarto, String numQuarto) throws QuartoInexistenteException, ValorInvalidoException, ObjetoNullException{
		return this.factoryQuarto.criaQuarto(tipoQuarto, numQuarto);
	}
	
	public String cadastraHospede(String nome, String email, String anoNascimento) throws NomeHospedeInvalidoException, NomeHospedeException, EmailHospedeException, FormatoDataException, DataNascimentoNullException, MenorDeIdadeException, ParseException{
		return this.recepcao.cadastraHospede(nome, email, anoNascimento);
	}
	
	public void removeHospede(String email) throws HospedeInexistenteException {
		this.recepcao.removerHospede(email);
	}
	
	public Hospede buscaHospede(String email) throws HospedeInexistenteException{
		return this.recepcao.buscaHospede(email);
	}
		
	public void getInfoHospedagem(String email, String Hospedagem) throws HospedeInexistenteException, GetInfoHospedagemException, EmailHospedeException{
		this.exceptionHotel.exceptionGetInfoHospedagens(email);
		this.recepcao.getInfoHospedagem(email, Hospedagem);
	}
	public String getInfoHospede(String email, String atributo) throws HospedeInexistenteException, GetInfoHospede {
		return this.recepcao.getInfoHospede(email, atributo);
	}
	
	public void realizaCheckin(String email, int quantDias, String numQuarto, String tipo) throws QuartoInexistenteException, ValorInvalidoException, ObjetoNullException, HospedeInexistenteException, QuartoInvalidoException, EmailHospedeException {
		this.exceptionHotel.exceptionChekin(email, quantDias, numQuarto);
		this.recepcao.realizaCheckin(email, quantDias,this.criaQuarto(tipo, numQuarto));
	}
	
	public String realizarCheckout(String email, String numQuarto) throws HospedeInexistenteException, ValorInvalidoException, QuartoInvalidoException, EmailHospedeException, ObjetoNullException {
		this.exceptionHotel.exceptionCheckout(email, numQuarto);
		return this.recepcao.realizacheckout(email, numQuarto);
    }

	public String atualizaCadastro(String email, String atributo, String valor) throws AtualizaDataNascimentoNullException, AtualizaDataNascimentoHospedeFormatException, AtualizaMenorDeIdadeException, HospedeInexistenteException, AtualizaNomeHospedeException, AtualizaEmailHospedeException, AtualizaCadastroException{
		return this.recepcao.atualizaCadastro(email, atributo, valor);
	}
	
	public String consultaTransacoes(String tipo) throws TransacaoException {
		return this.recepcao.consultaTransacoes(tipo);
	}
	
	public String consultaTransacoes(String tipo, int indice) throws TransacaoException, ValorInvalidoException {
		this.exceptionHotel.exceptionIndiceInvalido(indice);
		return this.consultaTransacoes(tipo, indice);
	}
	
	public void cadastraPrato(String nome, double preco, String especificacao) throws Exception{
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
	
	public String convertePontos(String email, int pontos) throws HospedeInexistenteException, pontosInsuficientesException{
		return recepcao.convertePontos(email, pontos);
	}
}
