package exceptionsmetodos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sistemaexception.AtualizaDataNascimentoHospedeFormatException;
import sistemaexception.AtualizaDataNascimentoNullException;
import sistemaexception.AtualizaEmailHospedeException;
import sistemaexception.AtualizaMenorDeIdadeException;
import sistemaexception.AtualizaNomeHospedeException;
import sistemaexception.DataNascimentoNullException;
import sistemaexception.EmailHospedeException;
import sistemaexception.FormatoDataException;
import sistemaexception.MenorDeIdadeException;
import sistemaexception.NomeHospedeException;
import sistemaexception.NomeHospedeInvalidoException;

public class ExceptionMetodosHospede extends ExceptionMetodos{

	public void exceptionEntrada(String nome, String email, String dataNascimento) throws NomeHospedeInvalidoException, NomeHospedeException, EmailHospedeException, FormatoDataException, DataNascimentoNullException, MenorDeIdadeException, ParseException {
		this.exceptionNomeHospedeInvalido(nome);
		this.exceptionEmailHospede(email);
		this.exceptionEmailFormat(email);
		this.exceptionMenorDeIdade(dataNascimento);

	}

	//Cadastro
	//Nome
	public void exceptionNomeHospede(String nome) throws NomeHospedeException{
		if(nome == null || nome.trim().isEmpty()) {
			throw new NomeHospedeException();
		}
	}

	public void exceptionNomeHospedeInvalido(String nome) throws NomeHospedeInvalidoException, NomeHospedeException{
		this.exceptionNomeHospede(nome);
		String[] str = nome.split(" ");
		for(int i = 0; i < str.length; i ++){
			if(!(str[i].matches("^\\A[a-zA-Z]*\\z$"))){
				throw new NomeHospedeInvalidoException();
			}
		}
	}

	//Email
	public void exceptionEmailHospede(String email) throws EmailHospedeException{
		if (email == null || email.trim().isEmpty()) {
			throw new EmailHospedeException();
		}
	}

	public void exceptionEmailFormat(String email) throws EmailHospedeException{
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new EmailHospedeException("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
	}


//DataNascimento
private void exceptionDataNascimentoHospedeNull(String dataNascimento) throws DataNascimentoNullException{
	if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
		throw new DataNascimentoNullException();
	}
}

private void exceptionDataNascimentoHospedeFormat(String dataNascimento) throws ParseException, FormatoDataException, DataNascimentoNullException{
	this.exceptionDataNascimentoHospedeNull(dataNascimento);
	String letras = "^\\d{2}/\\d{2}/\\d{4}$";
	if(!(dataNascimento.matches(letras))){
		throw new FormatoDataException();
	}
}
@SuppressWarnings("deprecation")
public void exceptionMenorDeIdade(String dataNascimento) throws FormatoDataException, DataNascimentoNullException, ParseException, MenorDeIdadeException {
	this.exceptionDataNascimentoHospedeFormat(dataNascimento);
	String[] str = dataNascimento.split("/");
	if((Calendar.YEAR - Integer.parseInt(str[2])) < 18){
		throw new MenorDeIdadeException();
	}
}

//Atualizacao dos Dados
public void exceptionAtualizaNomeHospede(String nome) throws AtualizaNomeHospedeException{
	if (nome == null || nome.trim().isEmpty()) {
		throw new AtualizaNomeHospedeException();
	}
}

public void exceptionAtualizaEmailHospede(String email) throws AtualizaEmailHospedeException{
	if (email == null || email.trim().isEmpty()) {
		throw new AtualizaEmailHospedeException();
	}
}

public void exceptionAtualizaDataNascimentoHospede(String dataNascimento) throws AtualizaDataNascimentoNullException{
	if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
		throw new AtualizaDataNascimentoNullException();
	}
}

public void exceptionAtualizaDataNascimentoHospedeFormat(String dataNascimento) throws ParseException, AtualizaDataNascimentoHospedeFormatException, DataNascimentoNullException{
	this.exceptionDataNascimentoHospedeNull(dataNascimento);
	String letras = "0123456789/";
	if(!(dataNascimento.contains(letras))){
		throw new AtualizaDataNascimentoHospedeFormatException();
	}
}

public void exceptionAtualizaMenorDeIdade(String dataNascimento) throws ParseException, FormatoDataException, DataNascimentoNullException, AtualizaMenorDeIdadeException {
	this.exceptionDataNascimentoHospedeFormat(dataNascimento);
	String[] str = dataNascimento.split("/");
	if((Calendar.YEAR - Integer.parseInt(str[2])) < 18){
		throw new AtualizaMenorDeIdadeException();
	}
}



}



