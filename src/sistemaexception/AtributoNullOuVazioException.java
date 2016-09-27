package sistemaexception;

@SuppressWarnings("serial")
public class AtributoNullOuVazioException extends EntradaException {

	public AtributoNullOuVazioException() {
		super("Atributo Vazio ou null");
	}

	public AtributoNullOuVazioException(String mensagem) {
		super(mensagem);
	}
}
