package sistemaexception;

@SuppressWarnings("serial")
public class IDInvalidoException extends EntradaException{
	
	public IDInvalidoException() {
		super("ID do quarto invalido, use apenas numeros ou letras.");
	}

	public IDInvalidoException(String mensagem) {
		super(mensagem);
	}
}
