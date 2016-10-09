package sistemaexception;

@SuppressWarnings("serial")
public class EmailHospedeException extends EntradaException{
	
	public EmailHospedeException(){
		super("Email do(a) hospede");
	}
	
	public EmailHospedeException(String mensagem){
		super(mensagem);
	}
}
