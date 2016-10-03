package quartos;

import exceptionsmetodos.ExceptionMetodosQuarto;
import sistemaexception.ObjetoNullException;
import sistemaexception.ValorInvalidoException;

public abstract class Quarto implements Quartos{

	private double valorQuarto;
	private String numeroDoQuarto;
	private ExceptionMetodosQuarto exception;
	
	public Quarto(double valorQuarto, String numQuarto) throws ValorInvalidoException, ObjetoNullException{
		this.exception = new ExceptionMetodosQuarto();
		this.exception.exceptionValorDouble(valorQuarto);
		this.exception.exceptionStringVazia(numQuarto);
		
		this.valorQuarto = valorQuarto;
		this.numeroDoQuarto = numQuarto;
		
	}
	public String getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	
	public double getValorQuarto() {
		return valorQuarto;
	}

	public abstract String getTipo();

	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDoQuarto == null) ? 0 : numeroDoQuarto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorQuarto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Quarto){
			Quarto quarto = (Quarto) obj;
			if(quarto.getValorQuarto() == this.getValorQuarto() && quarto.getNumeroDoQuarto().equals(this.getNumeroDoQuarto())){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Quarto " + this.getTipo() + ":" + 
				"\nValor do quarto = " + this.getValorQuarto() +
				"\nNumero do quarto: " + this.getNumeroDoQuarto();
	}

}