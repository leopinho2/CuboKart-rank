package cubo.kart.logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

						listaPiloto = PilotoLogica.atualizaListaPiloto(listaPiloto, piloto);
					}
				}

				br.close();
			} catch (IOException e) {
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
