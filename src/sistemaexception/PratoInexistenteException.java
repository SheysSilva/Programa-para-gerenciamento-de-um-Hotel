package sistemaexception;

@SuppressWarnings("serial")
public class PratoInexistenteException extends Exception {
	
	public PratoInexistenteException(){
		super("Prato Inexistente");
	}
	
	public PratoInexistenteException(String mensagem){
		super(mensagem);
	}

}
