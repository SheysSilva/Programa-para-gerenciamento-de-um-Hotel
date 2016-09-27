package restaurante;

import java.util.ArrayList;

public class FactoryDeRefeicao {
	public Refeicao CriaRefeicao(String nome, String descricao, ArrayList<String> componentes) throws Exception{
		Refeicao refeicao = new Refeicao(nome, descricao, componentes);
		return refeicao;
	}
}
