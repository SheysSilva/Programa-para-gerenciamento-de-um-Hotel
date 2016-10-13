package hospedagem;

public class Premium implements CartaoFidelidade{

	private double porcentagem;
	
	public Premium(){
	
		this.porcentagem = 0.9;
	}
	
	@Override
	public double getPorcentagem() {
		return porcentagem;
	}

	@Override
	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	@Override
	public double aplicaDesconto(double cobranca) {
		return cobranca * this.getPorcentagem();
	}
	
	@Override
	public int pontos(double cobranca) {
		int total = (int) (cobranca * 0.7);
		if(cobranca > 100){
			total += cobranca/10;
		}
		return total;
	}
	
	@Override
	public String convertePontos(int pontos) {
		double total = (pontos/10) * 0.2;
		total += pontos * 0.3;
		return  String.format("R$%.2f", total);
	}

	

	
	
	
	
}
