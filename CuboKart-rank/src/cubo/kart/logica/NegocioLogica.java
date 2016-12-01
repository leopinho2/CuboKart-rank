package cubo.kart.logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import cubo.kart.modelo.Piloto;
import cubo.kart.utils.Constantes;
import cubo.kart.utils.Utils;

public class NegocioLogica {

	public static void ResultadoDaCorrida(String caminhoEntrada) {
		if (Utils.existeArquivo(caminhoEntrada) == Constantes.NEGACAO) {
			System.out.println("Arquivo não encontrado");
		} else {
			ArrayList<Piloto> listaPiloto = new ArrayList<Piloto>();

			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoEntrada));
				String linha;

				while ((linha = br.readLine()) != null) {
					String[] celulas = linha.split("	");
					if (!celulas[0].equals("Hora")) {
						
						Piloto piloto = PilotoLogica.carregarDadosPiloto(celulas);

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
					}
				}

				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			listaPiloto = PilotoLogica.possicoes(listaPiloto);
			
			
			String saida = "Posição Chegada\tCódigo Piloto\tNome Piloto\tQtde Voltas Completadas\tTempo Total de Prova\n";
			
			for (Piloto piloto2 : listaPiloto) {
				
				saida += piloto2.getPosicao() + "\t" + piloto2.getCodigo() + "\t" + piloto2.getNome() + "\t"
						+ piloto2.getQuantidadeDeVoltas() + "\t"
						+ Utils.coverterMilissegundosEmMinutos(piloto2.getTempoDeProva()) + "\n";

			}
			System.out.print(saida);
			
		}

	}


}
