package hospedagem;

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


	@Override
	public String convertePontos(int pontos) {
		double total = (pontos/10) * 0.2;
		total += pontos * 0.3;
		return "R$2.f" + total;
	}

	
	
	
	
}
