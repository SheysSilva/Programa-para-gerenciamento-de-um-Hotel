package Hospedagem;

public class Premium implements CartaoFidelidade{

	private double porcentagem;
	
	public Premium(){
	
		this.porcentagem = 0.9;
	}


	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public double aplicaDesconto(double cobranca) {
		return cobranca * this.getPorcentagem();
	}

	@Override
	public void pagaDivida(double divida) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getDesconto(double cobranca) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
}
