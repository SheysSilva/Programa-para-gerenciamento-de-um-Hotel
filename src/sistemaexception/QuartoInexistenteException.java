package sistemaexception;

@SuppressWarnings("serial")
public class QuartoInexistenteException extends EntradaException {
	
	public QuartoInexistenteException(String mensagem){
		super(mensagem);
	}
		
	public QuartoInexistenteException(){
		super("Tipo do quarto nao existe");
	}
}
