package cubo.kart.logica;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import cubo.kart.modelo.Piloto;

public class PilotoLogicaTest {

	@Test
	public void possicoesTest() {
		Piloto um = new Piloto();
		um.setCodigo("1");
		um.setNome("um");
		um.setQuantidadeDeVoltas(3);
		um.setTempoDeProva(5);
		Piloto dois = new Piloto();
		dois.setCodigo("2");
		dois.setNome("dois");
		dois.setQuantidadeDeVoltas(2);
		dois.setTempoDeProva(4);
		Piloto tres = new Piloto();
		tres.setCodigo("3");
		tres.setNome("tres");
		tres.setQuantidadeDeVoltas(3);
		tres.setTempoDeProva(3);

		ArrayList<Piloto> listaPiloto = new ArrayList<Piloto>();
		listaPiloto.add(um);
		listaPiloto.add(dois);
		listaPiloto.add(tres);

		Piloto quatro = new Piloto();
		quatro.setCodigo("1");
		quatro.setNome("um");
		quatro.setQuantidadeDeVoltas(3);
		quatro.setTempoDeProva(5);
		Piloto cinco = new Piloto();
		cinco.setCodigo("2");
		cinco.setNome("dois");
		cinco.setQuantidadeDeVoltas(2);
		cinco.setTempoDeProva(4);
		Piloto seis = new Piloto();
		seis.setCodigo("3");
		seis.setNome("tres");
		seis.setQuantidadeDeVoltas(3);
		seis.setTempoDeProva(3);

		ArrayList<Piloto> listacorreta = new ArrayList<Piloto>();
		seis.setPosicao(1);
		quatro.setPosicao(2);
		cinco.setPosicao(3);
		listacorreta.add(seis);
		listacorreta.add(quatro);
		listacorreta.add(cinco);

		ArrayList<Piloto> listaTest = new ArrayList<Piloto>();

		listaTest = PilotoLogica.possicoes(listaPiloto);

		assertEquals(listacorreta.get(0).getCodigo(), listaTest.get(0).getCodigo());
		assertEquals(listacorreta.get(1).getCodigo(), listaTest.get(1).getCodigo());
		assertEquals(listacorreta.get(2).getCodigo(), listaTest.get(2).getCodigo());

	}

	@Test
	public void carregarDadosPilotoTest() {

		Piloto senna = new Piloto();
		senna.setCodigo("111");
		senna.setNome("A.SENNA");
		senna.setQuantidadeDeVoltas(1);
		senna.setTempoDeProva(61010);

		String[] celulas = { "23:49:08.277", "111 – A.SENNA", "1", "1:01.010", "44,275" };

		Piloto pilotoTeste = PilotoLogica.carregarDadosPiloto(celulas);

		assertEquals(pilotoTeste.getCodigo(), senna.getCodigo());
		assertEquals(pilotoTeste.getNome(), senna.getNome());
		assertEquals(pilotoTeste.getQuantidadeDeVoltas(), senna.getQuantidadeDeVoltas());
		assertEquals(pilotoTeste.getTempoDeProva(), senna.getTempoDeProva());

	}

	@Test
	public void atualizaListaPilotoTest() {

		Piloto senna = new Piloto();
		senna.setCodigo("111");
		senna.setNome("A.SENNA");
		senna.setQuantidadeDeVoltas(1);
		senna.setTempoDeProva(61010);

		Piloto prost = new Piloto();
		prost.setCodigo("222");
		prost.setNome("A.PROST");
		prost.setQuantidadeDeVoltas(1);
		prost.setTempoDeProva(61011);

		Piloto senna2 = new Piloto();
		senna2.setCodigo("111");
		senna2.setNome("A.SENNA");
		senna2.setQuantidadeDeVoltas(2);
		senna2.setTempoDeProva(61013);

		ArrayList<Piloto> listaPiloto = new ArrayList<>();
		listaPiloto.add(senna);
		listaPiloto.add(prost);

		ArrayList<Piloto> listaTest = new ArrayList<Piloto>();

		listaTest = PilotoLogica.atualizaListaPiloto(listaPiloto, senna2);

		assertEquals(senna.getNome(), listaTest.get(0).getNome());
		assertEquals(122023, listaTest.get(0).getTempoDeProva());

	}

}
