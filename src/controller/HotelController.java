package controller;


import java.text.ParseException;

import exceptionsmetodos.ExceptionMetodosHotel;
import hospede.Hospede;
import quartos.FactoryQuarto;
import quartos.Quarto;
import recepcao.Recepcao;
import restaurante.Restaurante;
import sistemaexception.AtualizaCadastroException;
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
import sistemaexception.TransacaoException;
import sistemaexception.ValorInvalidoException;



public class HotelController {
	
	private Restaurante restaurante;
	private Recepcao recepcao;
	private FactoryQuarto factoryQuarto;
	private ExceptionMetodosHotel exceptionHotel;

	
	public HotelController(){
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
		
	public void getInfoHospedagem(String email, String Hospedagem) throws HospedeInexistenteException{
		this.recepcao.getInfoHospedagem(email, Hospedagem);
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
		String[] str = atributo.toUpperCase().trim().split(" ");
		switch(str[0]){
			case "DATA":
				return this.recepcao.atualizaCadastroData(email, valor);
			case "NOME":
				return this.recepcao.atualizaCadastroNome(email, valor);
			case "EMAIL":
				return this.recepcao.atualizaCadastroEmail(email, valor);
			default:
				throw new AtualizaCadastroException();
		}
	}
	
	public String consultaTransacoes(String tipo) throws TransacaoException {
		switch(tipo.trim().toUpperCase()){
			case "TOTAL":
				return this.recepcao.transacaoTotal();
			case "QUANTIDADE":
				return this.recepcao.transacaoQuantidade();
			case "NOME":
				return this.recepcao.transacaoNome();
			default:
				throw new TransacaoException();
		}
		
	}
	
	public String consultaTransacoes(String tipo, int indice) throws TransacaoException, ValorInvalidoException {
		this.exceptionHotel.exceptionIndiceInvalido(indice);
		switch(tipo.trim().toUpperCase()){
		case "TOTAL":
			return this.recepcao.transacaoTotal(indice);
		case "NOME":
			return this.recepcao.transacaoNome(indice);
		default:
			throw new TransacaoException();
		}
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

}
