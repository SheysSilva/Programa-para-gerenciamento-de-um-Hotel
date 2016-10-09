package sistemaexception;

@SuppressWarnings("serial")
public class NomeHospedeException extends EntradaException{
	
	public NomeHospedeException(){
		super("Nome do(a) hospede nao pode ser vazio.");
	}
	
	public NomeHospedeException(String mensagem){
		super(mensagem);
	}
}
