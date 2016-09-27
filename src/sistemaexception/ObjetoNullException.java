package sistemaexception;

@SuppressWarnings("serial")
public class ObjetoNullException extends Exception {

	public ObjetoNullException() {
		super("Exception Objeto Null");
	}

	public ObjetoNullException(String mensagem) {
		super(mensagem);
	}
}
