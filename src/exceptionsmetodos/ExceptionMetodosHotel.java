package exceptionsmetodos;

import sistemaexception.ChecarHospedagemException;
import sistemaexception.CheckoutException;
import sistemaexception.ChekinException;
import sistemaexception.EmailHospedeException;
import sistemaexception.IDInvalidoException;
import sistemaexception.TransacaoException;

public class ExceptionMetodosHotel extends ExceptionMetodos{
	
	public void exceptionChekin(String email, int dias, String numQuarto) throws ChekinException {
		this.exceptionEmailFormatHotel(email);
		this.exceptionDiasInvalido(dias);
		this.exceptionNumQuartoInvalido(numQuarto);
	}
	public void exceptionEmail(String email) throws ChekinException  {
		if (email == null || email.trim().isEmpty()) {
			throw new ChekinException(new ChekinException() + " " + new  EmailHospedeException() + " nao pode ser vazio.");
		}
	}
	
	public void exceptionEmailFormatHotel(String email) throws ChekinException  {
		this.exceptionEmail(email);
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new ChekinException(new ChekinException() + " " + new  EmailHospedeException() + " esta invalido.");
		}
	}
	
	public void exceptionNumQuartoInvalido(String numQuarto) throws ChekinException   {
		if (numQuarto == null || numQuarto.trim().isEmpty() || (!numQuarto.matches("^\\A[0-9a-zA-Z_]+\\Z$"))) {
			throw new ChekinException(new ChekinException() + " " + new IDInvalidoException());
		}
	}

	public void exceptionDiasInvalido(int dias) throws ChekinException   {
		if (dias < 0) {
			throw new ChekinException(new ChekinException() + " Quantidade de dias esta invalida.");
		}
	}
	
	//Checkout
	
	public void exceptionCheckout(String email, String numQuarto) throws CheckoutException {
		this.exceptionEmailFormatHotelCheckout(email);
		this.exceptionNumQuartoInvalidoCheckout(numQuarto);
	}
	public void exceptionEmailCheckout(String email) throws CheckoutException  {
		if (email == null || email.trim().isEmpty()) {
			throw new CheckoutException(new CheckoutException() + " " + new  EmailHospedeException() + " nao pode ser vazio.");
		}
	}
	
	public void exceptionEmailFormatHotelCheckout(String email) throws CheckoutException  {
		this.exceptionEmailCheckout(email);
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new CheckoutException(new CheckoutException() + " " + new  EmailHospedeException() + " esta invalido.");
		}
	}
	
	public void exceptionNumQuartoInvalidoCheckout(String numQuarto) throws CheckoutException   {
		if (numQuarto == null || numQuarto.trim().isEmpty() || (!numQuarto.matches("^\\A[0-9a-zA-Z_]+\\Z$"))) {
			throw new CheckoutException(new CheckoutException() + " " + new IDInvalidoException());
		}
	}
	
	//Transacao
	public void exceptionIndiceInvalido(int indice) throws TransacaoException {
		if (indice < 0) {
			throw new TransacaoException(new TransacaoException() + " Indice invalido.");
		}
	}
	
	//GetInfoHospedagens
	public void exceptionGetInfoHospedagens(String email) throws ChecarHospedagemException, CheckoutException  {
		this.exceptionGetInfoEmail(email);
		this.exceptionGetInfoEmailFormat(email);
	}
	
	public void exceptionGetInfoEmail(String email) throws ChecarHospedagemException  {
		if (email == null || email.trim().isEmpty()) {
			throw new ChecarHospedagemException(new ChecarHospedagemException() + " " + new EmailHospedeException() + " nao pode ser vazio.");
		}
	}
	
	public void exceptionGetInfoEmailFormat(String email) throws ChecarHospedagemException  {
		this.exceptionGetInfoEmail(email);
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new ChecarHospedagemException(new ChecarHospedagemException() + " " + new EmailHospedeException() + " esta invalido.");
		}
	}
}
