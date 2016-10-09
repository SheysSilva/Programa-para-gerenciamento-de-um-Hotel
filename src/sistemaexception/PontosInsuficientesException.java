package sistemaexception;

@SuppressWarnings("serial")
public class PontosInsuficientesException extends Exception {

	public PontosInsuficientesException(){
		super("Erro nos pontos");
	}
	
	public PontosInsuficientesException(String mensagem){
		super(mensagem);
	}
}
