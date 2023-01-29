package modelo;
 
public enum Especie {
	ALAMO("Alamo"), ENCINA("Encina"), CASTANO("Castano"), CIPRES("Cipres"), PINO("Pino"), ROBLE("Roble"), OLIVO("Olivo");
	
	String cadenaAMostrar;
	
	private Especie(String cadenaAMostrar) {
		
		this.cadenaAMostrar = cadenaAMostrar;
		
	}
	
	@Override
	public String toString() {

		return cadenaAMostrar;

	}
	
}


