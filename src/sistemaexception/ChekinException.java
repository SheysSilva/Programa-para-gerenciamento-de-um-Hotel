package sistemaexception;

@SuppressWarnings("serial")
public class ChekinException extends EntradaException{
	public ChekinException() {
		super("Erro ao realizar checkin.");
	}

	public ChekinException(String mensagem) {
		super(mensagem);
	}
}
