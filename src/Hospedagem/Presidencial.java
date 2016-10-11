package hospedagem;

import sistemaexception.ObjetoNullException;
import sistemaexception.ValorInvalidoException;

public class Presidencial extends Quarto{
	
	private static final double PRECO = 450.0;
	
	public Presidencial(String numQuarto) throws ValorInvalidoException, ObjetoNullException {
		super(PRECO, numQuarto);
	}

	@Override
	public String getTipo() {
		return "Presidencial";
	}



}
