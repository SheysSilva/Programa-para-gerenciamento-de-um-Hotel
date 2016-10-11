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
	public void pagaDivida(double divida) {
		
	}

	@Override
	public double getDesconto(double cobranca) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String convertePontos(int pontos) {
		return "R$2.f" + (pontos * 0.1);
	}

	
}
