package cartaofidelidade;

public class Padrao implements CartaoFidelidade{
	private int pontos;
	private double porcentagem;
	
	public Padrao(){
		this.pontos = 0;
		this.porcentagem = 0;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double desconto) {
		this.porcentagem = desconto;
	}
	
	@Override
	public void adicionaPontos(double pagamento){
		this.setPontos((int) (this.getPontos() + pagamento * 0.1));
	}

	@Override
	public double aplicaDesconto(double cobranca) {
		return cobranca + cobranca * this.getPorcentagem();
	}

	@Override
	public void pagaDivida(double divida) {
		
		
	}


	
}
