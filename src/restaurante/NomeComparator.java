package restaurante;

import java.util.Comparator;

public class NomeComparator implements Comparator<ItensDoCardapio>{

	@Override
	public int compare(ItensDoCardapio item, ItensDoCardapio outroItem) {
		return item.getNome().compareTo(outroItem.getNome());
	}
}
