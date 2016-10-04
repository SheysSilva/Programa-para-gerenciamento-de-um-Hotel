package cartaofidelidade;

public interface CartaoFidelidade {
	public int getPontos();

	public void setPontos(int pontos);

	public double getPorcentagem();

	public void setPorcentagem(double desconto);
	
	public void adicionaPontos(double pagamento);
	
	public double getDesconto(double cobranca);
	
	public void pagaDivida(double divida);

}
