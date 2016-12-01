package cubo.kart.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import cubo.kart.logica.NegocioLogica;

public class UtilsTest {
	
	@Test
	public void existeArquivoTest(){
		
		Object object = new Object();

		object = Utils.existeArquivo(null);

		assertEquals(Constantes.NEGACAO, object);
		
		object = Utils.existeArquivo("c:/workspace/Corrida.log");

		assertEquals(Constantes.CONFIRMACAO, object);
		
		object = Utils.existeArquivo("caminho errado");

		assertEquals(Constantes.NEGACAO, object);
		
		
	}
	
	@Test
	public void coverterMinutosEmMilissegundosTest() {
		
		Object object = new Object();

		object = Utils.coverterMinutosEmMilissegundos("1:01,010");

		assertEquals(61010, object);
		
	}
	
	@Test
	public void coverterMilissegundosEmMinutosTest() {
		
		Object object = new Object();

		object = Utils.coverterMilissegundosEmMinutos(61010);

		assertEquals("1:01,010", object);
		

		object = Utils.coverterMilissegundosEmMinutos(10);

		assertEquals("0:00,010", object);

		
	}
}
