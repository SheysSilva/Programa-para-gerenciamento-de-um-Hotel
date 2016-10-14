package hospedagem;

public class Padrao implements CartaoFidelidade{
	
	private double porcentagem;
	
	public Padrao(){
		this.porcentagem = 0;
	}

	@Override
	public double getPorcentagem() {
		return porcentagem;
	}

	@Override
	public void setPorcentagem(double desconto) {
		this.porcentagem = desconto;
	}

	@Override
	public double aplicaDesconto(double cobranca) {
		return cobranca + cobranca * this.getPorcentagem();
	}
	
	@Override
	public int pontos(double cobranca){
		return (int) (cobranca * 0.9);
	}

	@Override
	public String convertePontos(int pontos) {
		return String.format("R$%.2f",  (pontos * 0.1));
	}

	@Override
	public String getTipo() {
		return "PADRAO";
	}

	
}
