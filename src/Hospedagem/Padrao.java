package hospedagem;

public class Padrao implements CartaoFidelidade{
	
	private double porcentagem;
	
	public Padrao(){
		this.porcentagem = 0;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double desconto) {
		this.porcentagem = desconto;
	}
	
	
	public double aplicaDesconto(double cobranca) {
		return cobranca + cobranca * this.getPorcentagem();
	}

	@Override
	public String convertePontos(int pontos) {
		return String.format("R$%.2f",  (pontos * 0.1));
	}

	
}
