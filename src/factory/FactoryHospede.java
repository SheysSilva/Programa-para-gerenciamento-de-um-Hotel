package factory;

import hospedagem.Hospede;
import sistemaexception.CadastroHospedeException;

public class FactoryHospede {

	public Hospede criarHospede(String nome, String email, String anoNascimento) throws CadastroHospedeException  {
		return new Hospede(nome, email, anoNascimento);
	}
}

