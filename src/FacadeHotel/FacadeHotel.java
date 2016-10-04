package FacadeHotel;

import java.text.ParseException;

import controller.HotelController;
import hospede.Hospede;
import sistemaexception.AtualizaCadastroException;
import sistemaexception.AtualizaDataNascimentoHospedeFormatException;
import sistemaexception.AtualizaDataNascimentoNullException;
import sistemaexception.AtualizaEmailHospedeException;
import sistemaexception.AtualizaMenorDeIdadeException;
import sistemaexception.AtualizaNomeHospedeException;
import sistemaexception.DataNascimentoNullException;
import sistemaexception.EmailHospedeException;
import sistemaexception.FormatoDataException;
import sistemaexception.GetInfoException;
import sistemaexception.HospedeInexistenteException;
import sistemaexception.MenorDeIdadeException;
import sistemaexception.NomeHospedeException;
import sistemaexception.NomeHospedeInvalidoException;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.QuartoInvalidoException;
import sistemaexception.TransacaoException;
import sistemaexception.ValorInvalidoException;

public class FacadeHotel {
	
	private HotelController hotel;
	
	public FacadeHotel(){
		this.hotel = new HotelController();
	}
	
	public void iniciaSistema(){
	}
	
	public String cadastraHospede(String nome, String email, String anoNascimento) throws NomeHospedeInvalidoException, NomeHospedeException, EmailHospedeException, FormatoDataException, DataNascimentoNullException, MenorDeIdadeException, ParseException {
		return this.hotel.cadastraHospede(nome, email, anoNascimento);
	}
	
	public void removeHospede(String email) throws HospedeInexistenteException {
		this.hotel.removeHospede(email);
	}
	
	public Hospede buscaHospede(String email) throws HospedeInexistenteException{
		return this.hotel.buscaHospede(email);
	}
	
	public void getInfoHospedagem(String email, String Hospedagem) throws HospedeInexistenteException {
		this.hotel.getInfoHospedagem(email, Hospedagem);
		
	}
	
	public void realizaCheckin(String email, int quantDias, String numQuarto, String tipo) throws ValorInvalidoException, QuartoInexistenteException, HospedeInexistenteException, ObjetoNullException, QuartoInvalidoException, Exception {
		this.hotel.realizaCheckin(email, quantDias, numQuarto, tipo);
		
	}

	public String realizaCheckout(String email, String numQuarto) throws ValorInvalidoException, HospedeInexistenteException, QuartoInvalidoException, EmailHospedeException, ObjetoNullException {
		return this.hotel.realizarCheckout(email, numQuarto);	
	}
	
	public String consultaTransacoes(String tipo) throws TransacaoException {
		return this.hotel.consultaTransacoes(tipo);
	}
	
	public String consultaTransacoes(String tipo, int indice) throws ValorInvalidoException, TransacaoException {
		return this.hotel.consultaTransacoes(tipo, indice);
	}
	
	public String atualizaCadastro(String email, String atributo, String valor) throws AtualizaDataNascimentoHospedeFormatException, DataNascimentoNullException, AtualizaDataNascimentoNullException, AtualizaNomeHospedeException, AtualizaEmailHospedeException, ParseException, HospedeInexistenteException, AtualizaCadastroException, AtualizaMenorDeIdadeException {
		return this.hotel.atualizaCadastro(email, atributo, valor);
		
	}
	
	public void cadastraPrato(String nome, double preco, String especificacao) throws Exception {
		this.hotel.cadastraPrato(nome, preco, especificacao);
		
	}
	
	public String consultaRestaurante(String nome, String atributo) throws Exception {
		return this.hotel.consultaRestaurante(nome, atributo);
		
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception{
		this.hotel.cadastraRefeicao(nome, descricao, componentes);
		
	}
	public String getInfoHospede(String email, String atributo) throws HospedeInexistenteException, GetInfoException {
		return this.hotel.getInfoHospede(email, atributo);
	}
	
	public void fechaSistema(){
	}
}



