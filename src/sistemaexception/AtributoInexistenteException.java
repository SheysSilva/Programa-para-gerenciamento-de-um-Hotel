package sistemaexception;

@SuppressWarnings("serial")
public class AtributoInexistenteException extends Exception {
	
	public AtributoInexistenteException(){
		super("Atributo Inexistente");
	}
	
	public AtributoInexistenteException(String mensagem){
		super(mensagem);
	}

}
