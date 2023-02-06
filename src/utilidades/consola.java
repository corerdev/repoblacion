package utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class consola {

	private consola() {
		
	}
	
	public static int leerAnchura() {
		int ancho = 0;
		
		do {
			
			System.out.println("Por favor, introduzca la anchura del bosque, comprendida entre 10 y 1000.");
			ancho = Entrada.entero();
		} while (ancho<10 || ancho>1000);
		return ancho;
		
	}
	
	public static int leerAltura() {
		int alto = 0;
		
		do {
			
			System.out.println("Por favor, introduzca la altura del bosque, comprendida entre 10 y 500.");
			alto = Entrada.entero();
		} while (alto<10 || alto>500);
		return alto;
		
	}
	public static int leerPoblacion() {
		int pob = 0;
		
		do {
			
			System.out.println("Por favor, introduzca la poblacion del bosque.");
			pob = Entrada.entero();
		} while (pob<=0);
		return pob;
		
	}
}
