package exceptionsmetodos;

import sistemaexception.EmailHospedeException;
import sistemaexception.ObjetoNullException;
import sistemaexception.ValorInvalidoException;

public class ExceptionMetodosHotel extends ExceptionMetodos{
	
	public void exceptionChekin(String email, int dias, String numQuarto) throws EmailHospedeException, ValorInvalidoException, ObjetoNullException{
		this.exceptionEmailFormatHotel(email);
		this.exceptionDiasInvalido(dias);
		this.exceptionNumQuartoInvalido(numQuarto);
	}
	public void exceptionEmail(String email) throws EmailHospedeException{
		if (email == null || email.trim().isEmpty()) {
			throw new EmailHospedeException("Erro ao realizar checkin. Email do(a) hospede nao pode ser vazio.");
		}
	}
	
	public void exceptionEmailFormatHotel(String email) throws EmailHospedeException{
		this.exceptionEmail(email);
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new EmailHospedeException("Erro ao realizar checkin. Email do(a) hospede esta invalido.");
		}
	}
	
	public void exceptionNumQuartoInvalido(String numQuarto) throws ObjetoNullException {
		if (numQuarto == null || numQuarto.trim().isEmpty() || (!numQuarto.matches("^\\A[0-9a-zA-Z_]+\\Z$"))) {
			throw new ObjetoNullException("Erro ao realizar checkin. ID do quarto invalido, use apenas numeros ou letras.");
		}
	}

	public void exceptionDiasInvalido(int dias) throws ValorInvalidoException {
		if (dias < 0) {
			throw new ValorInvalidoException("Erro ao realizar checkin. Quantidade de dias esta invalida.");
		}
	}
}
