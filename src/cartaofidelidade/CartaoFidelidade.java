package cartaofidelidade;

import exceptionsmetodos.ExceptionMetodosCartaoFidelidade;
import sistemaexception.ValorInvalidoException;

public class CartaoFidelidade {
	
	private double desconto;
	private double gastosHospedes;
	private ExceptionMetodosCartaoFidelidade exceptions;
	
	public CartaoFidelidade(){
		this.desconto = 0;
		this.gastosHospedes = 0;
		this.exceptions = new ExceptionMetodosCartaoFidelidade();
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) throws ValorInvalidoException {
		this.exceptions.exceptionValorDouble(desconto);
		this.desconto = desconto;
	}

	public double getGastosHospedes() {
		return gastosHospedes;
	}

	private void setGastosHospedes(double gastosHospedes) throws ValorInvalidoException {
		this.exceptions.exceptionValorDouble(gastosHospedes);
		this.gastosHospedes = gastosHospedes;
	}
	
	public void desconto() throws ValorInvalidoException{
		this.setDesconto(this.getGastosHospedes() - this.desconto);
	}
	
	public void controleGastos(double novoGasto) throws ValorInvalidoException{
		this.setGastosHospedes(novoGasto + this.getGastosHospedes());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(desconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gastosHospedes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CartaoFidelidade){
			CartaoFidelidade cartao = (CartaoFidelidade)obj;
			if(this.getDesconto() ==  cartao.getDesconto() && this.getGastosHospedes() == cartao.getGastosHospedes()){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString(){
		return "Cartao Fidelidade:" +
				"\nDesconto: " + this.getDesconto() +
				"\nGastos do Hospede: " + this.getGastosHospedes();
	}
	
}
