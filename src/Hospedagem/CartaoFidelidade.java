package hospedagem;

public interface CartaoFidelidade {
	/**
	 * 
	 * @return
	 */
	public double getPorcentagem();

	/**
	 * 
	 * @param desconto
	 */
	public void setPorcentagem(double desconto);

	/**
	 * 
	 * @param cobranca
	 * @return
	 */
	public double aplicaDesconto(double cobranca);
	
	/**
	 * 
	 * @param pontos
	 * @return
	 */
	public String convertePontos(int pontos);
	/**
	 * 
	 * @param cobranca
	 * @return
	 */
	public int pontos(double cobranca);
	
	/**
	 * 
	 * @return
	 */
	public String getTipo();
}
