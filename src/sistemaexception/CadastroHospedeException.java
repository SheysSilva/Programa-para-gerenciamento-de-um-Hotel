package sistemaexception;

@SuppressWarnings("serial")
public class CadastroHospedeException extends EntradaException{

	public CadastroHospedeException(){
		super("Erro no cadastro de Hospede.");
	}
	
	public CadastroHospedeException(String mensagem){
		super(mensagem);
	}
}
