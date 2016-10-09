package exceptionsmetodos;

import sistemaexception.RemocaoHospedeException;

public class ExceptionMetodosRecepcao extends ExceptionMetodos{

	public void exceptionRemoverHospede(String email) throws RemocaoHospedeException {
		if (email == null || email.trim().isEmpty()) {
				throw new RemocaoHospedeException(new RemocaoHospedeException() + " Formato de email invalido." );
			}
		
		if(!(email.matches("^\\A[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+.[a-zA-Z]+\\z$"))){
			throw new RemocaoHospedeException(new RemocaoHospedeException() + " Formato de email invalido." );
		}
	}

}
