package exceptionsmetodos;

import sistemaexception.ObjetoNullException;
import sistemaexception.ValorInvalidoException;

public class ExceptionMetodos {
	
	public ExceptionMetodos(){	
	}

	public void exceptionValorDouble(double valor) throws ValorInvalidoException {
		if (valor < 0) {
			throw new ValorInvalidoException("Exception valor double negativo");
		}
	}

	public void exceptionStringVazia(String str) throws ObjetoNullException {
		if (str == null || str.trim().isEmpty()) {
			throw new ObjetoNullException("Exception palavra vazia ou null");
		}
	}

	public void exceptionObjetoNull(Object objeto) throws ObjetoNullException {
		if (objeto == null) {
			throw new ObjetoNullException();
		}
	}
	
	public void exceptionValorInt(int valor) throws ValorInvalidoException {
		if (valor < 0) {
			throw new ValorInvalidoException("Exception valor inteiro negativo");
		}
	}
}
