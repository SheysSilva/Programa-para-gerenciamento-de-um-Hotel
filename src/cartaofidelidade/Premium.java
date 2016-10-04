package cartaofidelidade;

public class Premium implements CartaoFidelidade{
	private int pontos;
	private double porcentagem;
	
	public Premium(){
		this.pontos = 0;
		this.porcentagem = 0.9;
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
		int adicional = 0;
		if(pagamento > 100){
			adicional = ((int) (pagamento / 100)) * 10;
		}
		this.setPontos((int) (this.getPontos() + (pagamento * 0.3) + adicional));
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
