package sistemaexception;

@SuppressWarnings("serial")
public class FormatoDataException extends EntradaException{
	
	public FormatoDataException(){
		super("Formato de data invalido.");
	}
	
	public FormatoDataException(String mensagem){
		super(mensagem);
	}
}
