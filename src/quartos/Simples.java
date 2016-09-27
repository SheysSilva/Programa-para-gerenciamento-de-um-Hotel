package quartos;

import sistemaexception.ObjetoNullException;
import sistemaexception.ValorInvalidoException;

public class Simples extends Quarto{

	private static final double PRECO = 100.0;
	
	public Simples(String numQuarto) throws ValorInvalidoException, ObjetoNullException{
		super(PRECO, numQuarto);
	}

	@Override
	public String getTipo() {
		return "Simples";
	}
}
