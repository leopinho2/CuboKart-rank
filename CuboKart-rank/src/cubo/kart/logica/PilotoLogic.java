package cubo.kart.logica;

import java.util.ArrayList;

import cubo.kart.modelo.Piloto;

public class PilotoLogic {

	public static ArrayList<Piloto> possicoes(ArrayList<Piloto> listaPiloto) {
		ArrayList<Piloto> listaNova = new ArrayList<Piloto>();
		int posicao = 1;
		while (listaPiloto.size() > 0) {
			

			Piloto piloto = listaPiloto.get(0);
			for (int i = 1; i < listaPiloto.size(); i++) {
				if (i != listaPiloto.size()) {
					if (listaPiloto.get(i).getQuantidadeDeVoltas() >= piloto.getQuantidadeDeVoltas()
							&& listaPiloto.get(i).getTempoDeProva() < piloto.getTempoDeProva()) {
						piloto = listaPiloto.get(i);
					}
				}else{
					piloto.setPosicao(posicao);
					
				}
			}

			piloto.setPosicao(posicao);

			listaNova.add(piloto);
			listaPiloto.remove(piloto);
			posicao += 1;
		}
		return listaNova;
	}

}
