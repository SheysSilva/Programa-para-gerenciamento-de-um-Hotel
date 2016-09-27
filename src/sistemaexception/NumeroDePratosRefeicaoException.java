package sistemaexception;

@SuppressWarnings("serial")
public class NumeroDePratosRefeicaoException extends Exception {

	public NumeroDePratosRefeicaoException(){
		super("A refeição Completa, precisa ter no minimo 3 ou 4 pratos");
	}
	
	public NumeroDePratosRefeicaoException(String mensagem){
		super(mensagem);
	}
}
