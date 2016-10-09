package sistemaexception;

@SuppressWarnings("serial")
public class CheckoutException extends EntradaException{
	
	public CheckoutException() {
		super("Erro ao realizar checkout.");
	}

	public CheckoutException(String mensagem) {
		super(mensagem);
	}
}
