package hospedagem;

import sistemaexception.ObjetoNullException;
import sistemaexception.ValorInvalidoException;
/**
 * 
 * @author Sheilla, Evelinne, Gustavo
 *
 */
public class Luxo extends Quarto{

	private static final double PRECO = 250.0;
	
	public Luxo(String numQuarto) throws ValorInvalidoException, ObjetoNullException {
		super(PRECO, numQuarto);
	}

	@Override
	public String getTipo() {
		return "Luxo";
	}


	

}
