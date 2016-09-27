package sistemaexception;

@SuppressWarnings("serial")
public class AtualizaDataNascimentoHospedeFormatException extends EntradaException{

	
	public AtualizaDataNascimentoHospedeFormatException(){
		super("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");
	}
	
	public AtualizaDataNascimentoHospedeFormatException(String mensagem){
		super(mensagem);
	}
}