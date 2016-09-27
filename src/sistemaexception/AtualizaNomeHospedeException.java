package sistemaexception;

@SuppressWarnings("serial")
public class AtualizaNomeHospedeException extends EntradaException{
	
	public AtualizaNomeHospedeException(){
		super("Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
	}
	
	public AtualizaNomeHospedeException(String mensagem){
		super(mensagem);
	}
}