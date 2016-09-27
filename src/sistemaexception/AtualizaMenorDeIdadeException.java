package sistemaexception;

@SuppressWarnings("serial")
public class AtualizaMenorDeIdadeException extends EntradaException{
	
	public AtualizaMenorDeIdadeException(){
		super("Erro na atualizacao do cadastro de Hospede. A idade do(a) hospede deve ser maior que 18 anos.");
	}
	public AtualizaMenorDeIdadeException(String mensagem){
		super(mensagem);
	}
}
