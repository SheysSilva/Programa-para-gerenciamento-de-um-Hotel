package sistemaexception;

@SuppressWarnings("serial")
public class LogicaException extends SistemaException {

	public LogicaException() {
		super("Exception Logica");
	}

	public LogicaException(String mensagem) {
		super(mensagem);
	}

}
