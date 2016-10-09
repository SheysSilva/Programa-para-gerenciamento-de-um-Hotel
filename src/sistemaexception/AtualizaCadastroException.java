package sistemaexception;

@SuppressWarnings("serial")
public class AtualizaCadastroException extends EntradaException {
	
	public AtualizaCadastroException(){
		super("Erro na atualizacao do cadastro de Hospede.");
	}
	
	public AtualizaCadastroException(String mensagem){
		super(mensagem);
	}

}
