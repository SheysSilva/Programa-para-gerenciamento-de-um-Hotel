package sistemaexception;

@SuppressWarnings("serial")
public class FormatoDataException extends EntradaException{
	
	public FormatoDataException(){
		super("Erro no cadastro de Hospede. Formato de data invalido.");
	}
	
	public FormatoDataException(String mensagem){
		super(mensagem);
	}
}
