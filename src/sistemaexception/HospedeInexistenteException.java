package sistemaexception;

@SuppressWarnings("serial")
public class HospedeInexistenteException extends Exception {
	public HospedeInexistenteException(String mensagem){
		super(mensagem);
	}
		
	public HospedeInexistenteException(){
		super("Hospede nao existe");
	}
}
