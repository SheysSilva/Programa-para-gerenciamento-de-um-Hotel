package exceptionsmetodos;

import hospedagem.Quarto;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.ValorInvalidoException;

public class ExceptionMetodosEstadia extends ExceptionMetodos{

	public void  exceptionDias(int dias) throws ValorInvalidoException{
		if(dias <= 0){
			throw new ValorInvalidoException("Exception os dias nao podem ser zero ou negativo");
		}
	}
	
	public void exceptionQuarto(Object objeto) throws ObjetoNullException, QuartoInexistenteException {
		if (objeto == null) {
			throw new ObjetoNullException();
			
		} else {
			if(!(objeto instanceof Quarto)){
				throw new QuartoInexistenteException();
			}
		}
		
	}
	
	
}

