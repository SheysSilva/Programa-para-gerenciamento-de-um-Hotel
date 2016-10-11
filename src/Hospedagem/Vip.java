package hospedagem;

public class Vip implements CartaoFidelidade{
	
	private double porcentagem;
	
	public Vip(){
		this.porcentagem = 0.85;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public double aplicaDesconto(double cobranca) {
		int adicional = 0;
		if(cobranca >= 100){
			adicional = ((int) (cobranca / 100)) * 10;	
		}
		return cobranca * this.getPorcentagem() + adicional;
	}


	@Override
	public String convertePontos(int pontos) {
		double total = (pontos/10) * 0.5;
		total += pontos * 0.7;
		return String.format("R$%.2f", total);
	}
	

	

	
	
	
	
}
