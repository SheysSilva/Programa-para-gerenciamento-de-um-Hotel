package controller;


import java.text.ParseException;
import java.util.HashMap;

import hospede.Hospede;
import quartos.FactoryQuarto;
import quartos.Quarto;
import recepcao.Recepcao;
import restaurante.Restaurante;
import sistemaexception.AtualizaCadastroException;
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
import sistemaexception.ValorInvalidoException;



public class HotelController {
	
	private Restaurante restaurante;
	
	private Recepcao recepcao;
	private HashMap<String, Quarto> quartos;

	
	public HotelController(){
		this.recepcao = new Recepcao();
		this.quartos = new HashMap<String, Quarto>();
		this.restaurante  = new Restaurante();
	}
	
	private Quarto criaQuarto(String tipoQuarto, String numQuarto) throws Exception{
		FactoryQuarto factory = new FactoryQuarto();
		Quarto quarto = factory.criaQuarto(tipoQuarto, numQuarto);
		this.quartos.put(numQuarto, quarto);
		return quarto;
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
	
	public void realizaCheckin(String email, int quantDias, String numQuarto, String tipo) throws Exception{
		this.recepcao.realizaCheckin(email, quantDias, this.criaQuarto(tipo, numQuarto));
	}
	
	public String realizarCheckout(String email, double pagamento) throws HospedeInexistenteException, ValorInvalidoException {
       return this.recepcao.checkout(email, pagamento);
    }

	public String atualizaCadastro(String email, String atributo, String valor) throws AtualizaDataNascimentoHospedeFormatException, DataNascimentoNullException, AtualizaDataNascimentoNullException, ParseException, HospedeInexistenteException, AtualizaNomeHospedeException, AtualizaEmailHospedeException, AtualizaCadastroException{
		switch(atributo.toUpperCase().trim()){
		case "DATADENASCIMENTO":
			return this.recepcao.atualizaCadastroData(email, valor);
		case "NOME":
			return this.recepcao.atualizaCadastroNome(email, valor);
		case "EMAIL":
			return this.recepcao.atualizaCadastroEmail(email, valor);
		default:
			throw new AtualizaCadastroException();
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
	
	public void ordenaMenu(String tipoOrdenacao) throws Exception{
		restaurante.ordenaMenu(tipoOrdenacao);
	}
	
	public String consultaMenuRestaurante(){
		return restaurante.consultaMenuRestaurante();
	}

}
