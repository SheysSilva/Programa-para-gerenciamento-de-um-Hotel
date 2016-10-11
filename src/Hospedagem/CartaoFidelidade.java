package hospedagem;

public interface CartaoFidelidade {

	public double getPorcentagem();

	public void setPorcentagem(double desconto);
	
	public double getDesconto(double cobranca);
	
	public void pagaDivida(double divida);

	public String convertePontos(int pontos);

}
