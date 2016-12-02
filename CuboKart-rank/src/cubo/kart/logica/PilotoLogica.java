package cubo.kart.logica;

import java.util.ArrayList;

import cubo.kart.modelo.Piloto;
import cubo.kart.utils.Utils;

public class PilotoLogica {

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

	public static Piloto carregarDadosPiloto(String[] celulas) {
		Piloto piloto = new Piloto();

		String codigoNome = celulas[1];
		String[] codigoNomeSeparados = codigoNome.split(" – ");
		piloto.setCodigo(codigoNomeSeparados[0]);
		piloto.setNome(codigoNomeSeparados[1]);

		int numeroVolta = Integer.parseInt(celulas[2]);
		piloto.setQuantidadeDeVoltas(numeroVolta);

		String tempoVolta = celulas[3];
		int tempoVoltaMilissegundos = Utils.coverterMinutosEmMilissegundos(tempoVolta);
		piloto.setTempoDeProva(tempoVoltaMilissegundos);
		return piloto;
	}
	
	public static ArrayList<Piloto> atualizaListaPiloto(ArrayList<Piloto> listaPiloto, Piloto piloto) {
		if (listaPiloto.size() >= 1) {
			boolean existe = false;
			// procurar na lista o piloto atualizar a informacao
			// ou adiconar o piloto
			for (int i = 0; i < listaPiloto.size(); i++) {

				if (listaPiloto.get(i).getCodigo().equals(piloto.getCodigo())) {
					// atualiza volta
					listaPiloto.get(i).setQuantidadeDeVoltas(piloto.getQuantidadeDeVoltas());
					// atualiza tempo de prova
					int novoTempo = listaPiloto.get(i).getTempoDeProva() + piloto.getTempoDeProva();
					listaPiloto.get(i).setTempoDeProva(novoTempo);

					existe = true;
					break;
				}
			}
			if (!existe) {
				listaPiloto.add(piloto);
			}
		} else {
			listaPiloto.add(piloto);
		}
		
		return listaPiloto;
	}

}
