package hospedetestes;

import java.text.ParseException;

import org.junit.Test;

import hospede.Hospede;
import sistemaexception.DataNascimentoNullException;
import sistemaexception.EmailHospedeException;
import sistemaexception.FormatoDataException;
import sistemaexception.MenorDeIdadeException;
import sistemaexception.NomeHospedeException;
import sistemaexception.NomeHospedeInvalidoException;

public class TestesHospede {
	

	@Test
	public void test() throws NomeHospedeInvalidoException, NomeHospedeException, EmailHospedeException, FormatoDataException, DataNascimentoNullException, MenorDeIdadeException, ParseException {
		Hospede hospede = new Hospede("Sven Gudmr Svenson", "sven@sverige.se", "10/02/1996");
	}

}
