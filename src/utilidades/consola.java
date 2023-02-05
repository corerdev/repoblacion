package utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class consola {

	private consola() {
		
	}
	
	public int leerAnchura() {
		int ancho = 0;
		
		do {
			
			System.out.println("Por favor, introduzca la anchura del bosque.");
			ancho = Entrada.entero();
		} while (ancho<10 || ancho>1000);
		return ancho;
		
	}
	
	public int leerAltura() {
		int alto = 0;
		
		do {
			
			System.out.println("Por favor, introduzca la altura del bosque.");
			alto = Entrada.entero();
		} while (alto<10 || alto>1000);
		return alto;
		
	}
	public int leerPoblacion() {
		int pob = 0;
		
		do {
			
			System.out.println("Por favor, introduzca la poblacion del bosque.");
			pob = Entrada.entero();
		} while (pob<=0);
		return pob;
		
	}
}
