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
	public String convertePontos(int pontos) {
		double total = (pontos/10) * 0.2;
		total += pontos * 0.3;
		return  String.format("R$%.2f", total);
	}

	
	
	
	
}
