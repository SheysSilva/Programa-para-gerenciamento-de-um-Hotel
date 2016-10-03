package sistemaexception;

@SuppressWarnings("serial")
public class QuartoInvalidoException extends Exception {

	public QuartoInvalidoException(){
		super("Erro ao realizar checkin. Quarto 1A ja esta ocupado.");
	}
	
	public QuartoInvalidoException(String mensagem){
		super(mensagem);
	}
}
