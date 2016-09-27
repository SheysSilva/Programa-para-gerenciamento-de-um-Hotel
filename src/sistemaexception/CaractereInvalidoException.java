package sistemaexception;

@SuppressWarnings("serial")
public class CaractereInvalidoException extends EntradaException {

	public CaractereInvalidoException() {
		super("Cactere Invalido");
	}

	public CaractereInvalidoException(String mensagem) {
		super(mensagem);
	}
}
