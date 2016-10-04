package cartaofidelidade;

public class Vip implements CartaoFidelidade{
	private int pontos;
	private double porcentagem;
	
	public Vip(){
		this.pontos = 0;
		this.porcentagem = 0.85;
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

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	@Override
	public void adicionaPontos(double pagamento){
		this.setPontos((int) (this.getPontos() + pagamento * 0.5));
	}

	public double aplicaDesconto(double cobranca) {
		int adicional = 0;
		if(cobranca >= 100){
			adicional = ((int) (cobranca / 100)) * 10;	
		}
		return cobranca * this.getPorcentagem() + adicional;
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
