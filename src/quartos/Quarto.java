package quartos;

import exceptionsmetodos.ExceptionMetodosQuarto;
import sistemaexception.ObjetoNullException;
import sistemaexception.ValorInvalidoException;

public abstract class Quarto implements Quartos{

	private boolean estadoQuarto;
	private double valorQuarto;
	private String numeroDoQuarto;
	private ExceptionMetodosQuarto exception;
	
	public Quarto(double valorQuarto, String numQuarto) throws ValorInvalidoException, ObjetoNullException{
		this.exception = new ExceptionMetodosQuarto();
		this.exception.exceptionValorDouble(valorQuarto);
		this.exception.exceptionStringVazia(numQuarto);
		
		this.valorQuarto = valorQuarto;
		this.estadoQuarto = false;
		this.numeroDoQuarto = numQuarto;
		
	}
	public String getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	
	public boolean isEstadoQuarto() {
		return estadoQuarto;
	}
	
	public void setEstadoQuarto(boolean estado) {
		this.estadoQuarto = estado;
	}
	
	public double getValorQuarto() {
		return valorQuarto;
	}

	public abstract String getTipo();

	@Override
	public int hashCode() {
		return getNumeroDoQuarto().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Quarto){
			Quarto quarto = (Quarto) obj;
			if(quarto.getValorQuarto() == this.getValorQuarto()){
				return true;
			}
		}
		return false;
	}
		
	@Override
	public String toString(){
		return "Quarto " + this.getTipo() + ":" + 
				"\nValor do quarto = " + this.getValorQuarto() +
				"\nEstado do quarto = " + this.isEstadoQuarto();
	}

}