package controllers;

import restaurante.Restaurante;

public class RestauranteController {

	private Restaurante restaurante = new Restaurante();

	public void cadastraPrato(String nome, double preco, String especificacao) throws Exception {
		restaurante.cadastraPrato(nome, preco, especificacao);
		
	}
	
	public String consultaRestaurante(String nome, String atributo) throws Exception {
		return restaurante.consultaRestaurante(nome, atributo);
		
	}
	
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws Exception{
		restaurante.cadastraRefeicao(nome, descricao, componentes);
		
	}
	
	public void ordenaMenu(String tipoOrdenacao) throws Exception{
		restaurante.ordenaMenu(tipoOrdenacao);
	}
	
	public String consultaMenuRestaurante(){
		return restaurante.consultaMenuRestaurante();
	}
	
	public String realizaPedido(String email, String itemMenu) throws Exception{
		return restaurante.realizaPedido(email, itemMenu);
	}
	
	@Override
	public String toString(){
		return restaurante.toString();
	}
}

