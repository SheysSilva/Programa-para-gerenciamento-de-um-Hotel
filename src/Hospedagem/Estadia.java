package hospedagem;

import exceptionsmetodos.ExceptionMetodosEstadia;
import sistemaexception.ObjetoNullException;
import sistemaexception.QuartoInexistenteException;
import sistemaexception.ValorInvalidoException;
/**
 * 
 * @author Sheilla, Evelinne, Gustavo
 *
 */
public class Estadia {
	private Quarto quarto;
	private int dias;
	private ExceptionMetodosEstadia exception;
	
	public Estadia(Quarto quarto, int quantDias) throws ValorInvalidoException, QuartoInexistenteException, ObjetoNullException{
		this.exception = new ExceptionMetodosEstadia();
		this.exception.exceptionQuarto(quarto);
		this.exception.exceptionDias(quantDias);
		this.quarto = quarto;
		this.dias = quantDias;
	}

	/**
	 * 
	 * @return
	 */
	public Quarto getQuarto() {
		return this.quarto;
	}

	/**
	 * 
	 * @return
	 */
	public int getDias() {
		return this.dias;
	}

	/**
	 * 
	 * @param dias
	 * @throws ValorInvalidoException
	 */
	public void setDias(int dias) throws ValorInvalidoException {
		this.exception.exceptionDias(dias);
		this.dias = dias;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getValorDiariaQuarto(){
		return this.quarto.getValorQuarto();
	}
	
	/**
	 * 
	 * @return
	 */
	public double getValorTotal() {
		return this.getValorDiariaQuarto() * this.getDias();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quarto == null) ? 0 : quarto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Estadia){
			Estadia estadia = (Estadia)obj;
			if(estadia.getQuarto().equals(this.getQuarto())){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString(){
		return "Quarto: " + this.quarto.toString() +
				"\nDias: " + this.dias;
	}
}
