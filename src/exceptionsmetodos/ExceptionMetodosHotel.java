package exceptionsmetodos;

import sistemaexception.ChecarHospedagemException;
import sistemaexception.CheckoutException;
import sistemaexception.ChekinException;
import sistemaexception.TransacaoException;

public class ExceptionMetodosHotel extends ExceptionMetodos{
	
	public void exceptionChekin(String email, int dias, String numQuarto) throws ChekinException {
		this.exceptionEmailFormatHotel(email);
		this.exceptionDiasInvalido(dias);
		this.exceptionNumQuartoInvalido(numQuarto);
	}
	public void exceptionEmail(String email) throws ChekinException  {
		if (email == null || email.trim().isEmpty()) {
			throw new ChekinException("Erro ao realizar checkin. Email do(a) hospede nao pode ser vazio.");
		}
	}
	
	public void exceptionEmailFormatHotel(String email) throws ChekinException  {
		this.exceptionEmail(email);
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new ChekinException("Erro ao realizar checkin. Email do(a) hospede esta invalido.");
		}
	}
	
	public void exceptionNumQuartoInvalido(String numQuarto) throws ChekinException   {
		if (numQuarto == null || numQuarto.trim().isEmpty() || (!numQuarto.matches("^\\A[0-9a-zA-Z_]+\\Z$"))) {
			throw new ChekinException("Erro ao realizar checkin. ID do quarto invalido, use apenas numeros ou letras.");
		}
	}

	public void exceptionDiasInvalido(int dias) throws ChekinException   {
		if (dias < 0) {
			throw new ChekinException("Erro ao realizar checkin. Quantidade de dias esta invalida.");
		}
	}
	
	//Checkout
	
	public void exceptionCheckout(String email, String numQuarto) throws CheckoutException {
		this.exceptionEmailFormatHotelCheckout(email);
		this.exceptionNumQuartoInvalidoCheckout(numQuarto);
	}
	public void exceptionEmailCheckout(String email) throws CheckoutException  {
		if (email == null || email.trim().isEmpty()) {
			throw new CheckoutException("Erro ao realizar checkout. Email do(a) hospede nao pode ser vazio.");
		}
	}
	
	public void exceptionEmailFormatHotelCheckout(String email) throws CheckoutException  {
		this.exceptionEmailCheckout(email);
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new CheckoutException("Erro ao realizar checkout. Email do(a) hospede esta invalido.");
		}
	}
	
	public void exceptionNumQuartoInvalidoCheckout(String numQuarto) throws CheckoutException   {
		if (numQuarto == null || numQuarto.trim().isEmpty() || (!numQuarto.matches("^\\A[0-9a-zA-Z_]+\\Z$"))) {
			throw new CheckoutException("Erro ao realizar checkout. ID do quarto invalido, use apenas numeros ou letras.");
		}
	}
	
	//Transacao
	public void exceptionIndiceInvalido(int indice) throws TransacaoException {
		if (indice < 0) {
			throw new TransacaoException("Erro na consulta de transacoes. Indice invalido.");
		}
	}
	
	//GetInfoHospedagens
	public void exceptionGetInfoHospedagens(String email) throws ChecarHospedagemException, CheckoutException  {
		this.exceptionGetInfoEmail(email);
		this.exceptionGetInfoEmailFormat(email);
	}
	
	public void exceptionGetInfoEmail(String email) throws ChecarHospedagemException  {
		if (email == null || email.trim().isEmpty()) {
			throw new ChecarHospedagemException("Erro ao checar hospedagem ativa. Email do(a) hospede nao pode ser vazio.");
		}
	}
	
	public void exceptionGetInfoEmailFormat(String email) throws ChecarHospedagemException  {
		this.exceptionGetInfoEmail(email);
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new ChecarHospedagemException("Erro ao checar hospedagem ativa. Email do(a) hospede. esta invalido.");
		}
	}
}
