package sistemaexception;

@SuppressWarnings("serial")
public class ValorInvalidoException extends EntradaException {

	public ValorInvalidoException() {
		super("Exception Valor Invalido");
	}

	public ValorInvalidoException(String mensagem) {
		super(mensagem);
	}
}
