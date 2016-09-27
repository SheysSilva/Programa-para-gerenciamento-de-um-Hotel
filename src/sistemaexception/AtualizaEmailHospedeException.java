package sistemaexception;

@SuppressWarnings("serial")
public class AtualizaEmailHospedeException extends EntradaException{
	
	public AtualizaEmailHospedeException(){
		super("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");
	}
	
	public AtualizaEmailHospedeException(String mensagem){
		super(mensagem);
	}
}
