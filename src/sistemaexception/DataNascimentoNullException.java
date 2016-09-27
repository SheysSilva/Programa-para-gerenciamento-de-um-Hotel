package sistemaexception;

@SuppressWarnings("serial")
public class DataNascimentoNullException extends EntradaException{

	public DataNascimentoNullException(){
		super("Erro no cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
	}
	
	public DataNascimentoNullException(String mensagem){
		super(mensagem);
	}
}
