package sistemaexception;

@SuppressWarnings("serial")
public class ValorInvalidoException extends Exception {
	
	public ValorInvalidoException(){
		super("Valor invalido Exception.");
	}
	
	public ValorInvalidoException(String mensagem){
		super(mensagem);
	}
}
