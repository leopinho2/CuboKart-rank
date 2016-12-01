package cubo.kart.logica;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import cubo.kart.modelo.Piloto;

public class PilotoLogicTest {

	@Test
	public void possicoesTest(){
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

		listaTest = PilotoLogic.possicoes(listaPiloto);

		
		assertEquals(listacorreta.get(0).getCodigo(), listaTest.get(0).getCodigo());
		assertEquals(listacorreta.get(1).getCodigo(), listaTest.get(1).getCodigo());
		assertEquals(listacorreta.get(2).getCodigo(), listaTest.get(2).getCodigo());
		
		
		
	}

}
