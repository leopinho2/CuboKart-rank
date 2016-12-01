package cubo.kart.utils;

import java.io.File;

public class Utils {

	public static int existeArquivo(String caminho) {
		if (caminho != null) {
			File file = new File(caminho);

			if (file.exists()) {
				return Constantes.CONFIRMACAO;
			}
		}
		return Constantes.NEGACAO;
	}

	public static int coverterMinutosEmMilissegundos(String tempoVolta) {
		int minuto = Integer.parseInt(tempoVolta.substring(0,1)) * 60000; //1 minuto = 60.000 milissegundos 
		int segundo = Integer.parseInt(tempoVolta.substring(2,4)) * 1000; //1 segundo = 1.000 milissegundos 
		int milissegundo = Integer.parseInt(tempoVolta.substring(5));
		return (minuto + segundo + milissegundo);
	}

	public static String coverterMilissegundosEmMinutos(int milissegundos) {
		int segundos= 0;
		int minutos = 0;
		if(milissegundos >= 1000){
			segundos =  milissegundos / 1000;
			milissegundos = milissegundos % 1000;
			if(segundos >= 60){
				minutos = segundos / 60;
				segundos = segundos % 60;
			}
		}
		return String.format( "%01d:%02d,%03d", minutos, segundos, milissegundos ) ;
	}
	
}
