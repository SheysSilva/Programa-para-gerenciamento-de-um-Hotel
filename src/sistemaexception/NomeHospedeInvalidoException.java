package sistemaexception;

@SuppressWarnings("serial")
public class NomeHospedeInvalidoException extends EntradaException{
	
	public NomeHospedeInvalidoException(){
		super("Erro no cadastro de Hospede. Nome do(a) hospede esta invalido.");
	}
	
	public NomeHospedeInvalidoException(String mensagem){
		super(mensagem);
	}
}
