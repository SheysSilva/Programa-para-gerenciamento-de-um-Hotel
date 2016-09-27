package estadia;

import quartos.Quarto;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.ValorInvalidoException;

public class FactoryEstadia {
	
	public Estadia criaEstadia(Quarto quarto, int quantDias) throws ValorInvalidoException, QuartoInexistenteException, ObjetoNullException{
		return new Estadia(quarto, quantDias);
	}
}
