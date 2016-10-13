package hospedagem;

public interface CartaoFidelidade {

	public double getPorcentagem();

	public void setPorcentagem(double desconto);

	public double aplicaDesconto(double cobranca);
	
	public String convertePontos(int pontos);

	public int pontos(double cobranca);
}
