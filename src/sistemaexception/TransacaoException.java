package sistemaexception;

@SuppressWarnings("serial")
public class TransacaoException extends Exception {

	public TransacaoException(){
		super("Erro na consulta de transacoes");
	}
	
	public TransacaoException(String mensagem){
		super(mensagem);
	}
}
