package restaurante;

import java.util.Comparator;

public class PrecoComparator implements Comparator<ItensDoCardapio>{

	@Override
	public int compare(ItensDoCardapio item, ItensDoCardapio outroItem) {
		if (item.getPreco() > outroItem.getPreco()){
			return 1;
		} else if (item.getPreco() < outroItem.getPreco()){
			return -1;
		}
		return 0;
	}

}
