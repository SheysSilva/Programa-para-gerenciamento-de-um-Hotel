package sistemaexception;

@SuppressWarnings("serial")
public class AtualizaDataNascimentoNullException extends EntradaException{
	
	public AtualizaDataNascimentoNullException(){
		super("Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
	}
	
	public AtualizaDataNascimentoNullException(String mensagem){
		super(mensagem);
	}
}
