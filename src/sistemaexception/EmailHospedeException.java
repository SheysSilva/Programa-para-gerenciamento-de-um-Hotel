package sistemaexception;

@SuppressWarnings("serial")
public class EmailHospedeException extends EntradaException{
	
	public EmailHospedeException(){
		super("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
	}
	
	public EmailHospedeException(String mensagem){
		super(mensagem);
	}
}
