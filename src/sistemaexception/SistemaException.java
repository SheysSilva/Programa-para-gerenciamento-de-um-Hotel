package sistemaexception;

@SuppressWarnings("serial")
public class SistemaException extends Exception{
	
	public SistemaException(){
		super("Exception Errro");
	}
	
	public SistemaException(String mensagem){
		super(mensagem);
	}
}
