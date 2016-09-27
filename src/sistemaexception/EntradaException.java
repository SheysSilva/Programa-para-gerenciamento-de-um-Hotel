package sistemaexception;

@SuppressWarnings("serial")
public class EntradaException extends SistemaException {

	public EntradaException() {
		super("Exception Entrada");
	}

	public EntradaException(String mensagem) {
		super(mensagem);
	}
}
