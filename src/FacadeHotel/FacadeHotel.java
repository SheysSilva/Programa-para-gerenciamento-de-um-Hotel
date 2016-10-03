package FacadeHotel;

import java.text.ParseException;

import controller.HotelController;
import hospede.Hospede;
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
	
	public void realizaCheckin(String email, int quantDias, String numQuarto, String tipo) throws Exception{
		this.hotel.realizaCheckin(email, quantDias, numQuarto, tipo);
		
	}

	public String realizarCheckout(String email, double pagamento) throws ValorInvalidoException, HospedeInexistenteException {
		return this.hotel.realizarCheckout(email, pagamento);	
	}
	
	public String atualizaCadastro(String email, String atributo, String valor) throws AtualizaDataNascimentoHospedeFormatException, DataNascimentoNullException, AtualizaDataNascimentoNullException, AtualizaNomeHospedeException, AtualizaEmailHospedeException, ParseException, HospedeInexistenteException, AtualizaCadastroException {
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
	
	public void ordenaMenu(String tipoOrdenacao) throws Exception{
		hotel.ordenaMenu(tipoOrdenacao);
	}
	
	public String consultaMenuRestaurante(){
		return hotel.consultaMenuRestaurante();
	}
	
	public String realizaPedido(String email, String itemMenu) throws Exception{
		return hotel.realizaPedido(email, itemMenu);
	}

	public void fechaSistema(){
	}
}



