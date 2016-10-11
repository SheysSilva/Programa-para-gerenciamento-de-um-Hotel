package factory;


import hospedagem.Luxo;
import hospedagem.Presidencial;
import hospedagem.Quarto;
import hospedagem.Simples;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.ValorInvalidoException;

public class FactoryQuarto {

	public Quarto criaQuarto(String tipo, String numQuarto)throws QuartoInexistenteException, ValorInvalidoException, ObjetoNullException{
		switch(tipo.toUpperCase()){
			case "SIMPLES":
				return new Simples(numQuarto);
			
			case "LUXO": 
				return new Luxo(numQuarto);
			
			case "PRESIDENCIAL":
				return new Presidencial(numQuarto);
				
			default:
				throw new QuartoInexistenteException("Erro ao realizar checkin. Tipo de quarto invalido.");
		}
	}

}
