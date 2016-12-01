package cubo.kart.main;

import java.util.Scanner;

import cubo.kart.logica.NegocioLogica;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		String caminhoEntrada;

		System.out.println("Digite o caminho do log: ex(c:/workspace/Corrida.log)");
		caminhoEntrada = entrada.next();

		entrada.close();

		NegocioLogica.ResultadoDaCorrida(caminhoEntrada);
		
	}

}
