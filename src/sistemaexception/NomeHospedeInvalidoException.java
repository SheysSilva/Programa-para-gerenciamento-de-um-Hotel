package sistemaexception;

@SuppressWarnings("serial")
public class NomeHospedeInvalidoException extends EntradaException{
	
	public NomeHospedeInvalidoException(){
		super("Nome do(a) hospede esta invalido.");
	}
	
	public NomeHospedeInvalidoException(String mensagem){
		super(mensagem);
	}
}
