package modelo;

import java.util.Random;

public class Bosque {

	public final int MAX_ALTURA = 500, MINIMO = 10, MAX_ANCHURA = 1000, MAX_ESPECIES = 4;
	private Arbol arbolMasAlejado, arbolMasCentrado;
	private Arbol[] arboles;
	private int ancho, alto;
	private Random generador;

	public Bosque(int ancho, int alto, int poblacion) {
		
		this.setAncho(ancho);
		this.setAlto(alto);
		checkPoblacion(poblacion);
		this.arboles = new Arbol[poblacion];
		this.repoblar();

	}
	public void checkPoblacion(int poblacion) {
		if (poblacion > 2*(this.ancho+this.alto)) {
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}
		if (poblacion<1){
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
		}
	}
	
	private void repoblar() {
		Especie[] maximoEspecies = new Especie[MAX_ESPECIES];
		Especie[] pickEspecie = Especie.values();
		Especie especieT;
		boolean centinelaEspecie = false, centinelaFor = false, centinelaEspecieFor = false;
		int randomEspecie, centinelaInt = 1;

		for (int i = 0; i < this.arboles.length; i++) {

			if (centinelaEspecie == false) {
				Posicion posicionT = new Posicion(randomPosicion());

				if (i == 0) {
					randomEspecie = new Random().nextInt((pickEspecie.length) - 1);
					especieT = pickEspecie[randomEspecie];
				} else {

					do {
						randomEspecie = new Random().nextInt((pickEspecie.length) - 1);
						especieT = pickEspecie[randomEspecie];
					} while (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.CASTANO))
							|| (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.CIPRES)))
							|| (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.OLIVO)))
							|| (especieT.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ALAMO)))
							|| (especieT.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ENCINA))));

				}
				arboles[i] = new Arbol(especieT, posicionT);

				if (i == 0) {
					maximoEspecies[0] = arboles[0].getEspecie();
				} else {
					centinelaEspecieFor = false;
					for (int j = 0; j < i; j++) {
						if (arboles[j].getEspecie().equals(especieT)) {
							centinelaEspecieFor = true;
						}
					}
					if (centinelaEspecieFor == false) {
						centinelaFor = false;
						for (int k = 0; k < maximoEspecies.length && !centinelaFor; k++) {
							if (maximoEspecies[k] == null) {
								maximoEspecies[k] = arboles[i].getEspecie();
								centinelaFor = true;
								centinelaInt = centinelaInt + 1;
							}

						}

					}
					if (centinelaInt == MAX_ESPECIES) {
						centinelaEspecie = true;
					}
				}
			} else {
				Posicion posicionT = new Posicion(randomPosicion());

				do {
					randomEspecie = new Random().nextInt((maximoEspecies.length) - 1);
					especieT = maximoEspecies[randomEspecie];
				} while (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.CASTANO))
						|| (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.CIPRES)))
						|| (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.OLIVO)))
						|| (especieT.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ALAMO)))
						|| (especieT.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ENCINA))));
						/*
						|| (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.CIPRES))
						|| (especieT.equals(Especie.ALAMO) && (arboles[i - 1].getEspecie().equals(Especie.OLIVO))
						|| (especieT.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ALAMO))
						|| (especieT.equals(Especie.OLIVO) && (arboles[i - 1].getEspecie().equals(Especie.ENCINA)));*/
				arboles[i] = new Arbol(especieT, posicionT);
			}

		}

	}

	private Posicion randomPosicion() {
		Posicion randomPosicion = new Posicion((Math.random() * this.ancho - (this.ancho / 2)),
				(Math.random() * this.alto - (this.alto / 2)));
		return randomPosicion;

	}

	/*
	 * private void repoblar() {
	 * 
	 * Especie[] maximoEspecies = new Especie[MAX_ESPECIES]; Especie[] pickEspecie =
	 * Especie.values(); Especie especieT; int length = pickEspecie.length; int
	 * lengthSegundo = maximoEspecies.length; boolean centinelaEspecie = false,
	 * centinelaFor = false; boolean centinelaEspecieFor = false; int randomEspecie,
	 * centinelaInt = 0; System.out.println(length); for (int i = 0; i <
	 * this.arboles.length; i++) {
	 * 
	 * if (centinelaEspecie == false) { Posicion posicionT = new
	 * Posicion((Math.random() * this.ancho - (this.ancho / 2)), (Math.random() *
	 * this.alto - (this.alto / 2))); if (i==0) { randomEspecie = new
	 * Random().nextInt(length); } else { do { randomEspecie = new
	 * Random().nextInt(length); } while ((randomEspecie == 1 && (arboles[i -
	 * 1].getEspecie().equals(Especie.CASTANO)) || arboles[i -
	 * 1].getEspecie().equals(Especie.CIPRES) || arboles[i -
	 * 1].getEspecie().equals(Especie.OLIVO)) || (randomEspecie == 7 && (arboles[i -
	 * 1].getEspecie().equals(Especie.ALAMO) || arboles[i -
	 * 1].getEspecie().equals(Especie.ENCINA)))); } especieT =
	 * pickEspecie[randomEspecie]; arboles[i] = new Arbol(especieT, posicionT); for
	 * (int j = 0; j < i; j++) { if (arboles[j].getEspecie().equals(especieT)) {
	 * centinelaEspecieFor = true; }
	 * 
	 * } if (centinelaEspecieFor == false) { centinelaFor = false; for (int k = 0; k
	 * < maximoEspecies.length && !centinelaFor; k++) {
	 * 
	 * if (maximoEspecies[k] == null) { maximoEspecies[k] = especieT; centinelaFor =
	 * true; centinelaInt = centinelaInt + 1; } } } if (centinelaInt ==
	 * MAX_ESPECIES) { centinelaEspecie = true; }
	 * 
	 * } else { Posicion posicionT = new Posicion((Math.random() * this.ancho -
	 * (this.ancho / 2)), (Math.random() * this.alto - (this.alto / 2)));
	 * 
	 * do { randomEspecie = new Random().nextInt(lengthSegundo)+1; especieT =
	 * maximoEspecies[randomEspecie]; } while ((especieT.equals(Especie.ALAMO) &&
	 * (arboles[i - 1].getEspecie().equals(Especie.CASTANO)) || arboles[i -
	 * 1].getEspecie().equals(Especie.CIPRES) || arboles[i -
	 * 1].getEspecie().equals(Especie.OLIVO)) || (especieT.equals(Especie.OLIVO) &&
	 * (arboles[i - 1].getEspecie().equals(Especie.ALAMO) || arboles[i -
	 * 1].getEspecie().equals(Especie.ENCINA))));
	 * 
	 * arboles[i] = new Arbol(especieT, posicionT);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */
	public void realizarCalculos() {
		Posicion cero = new Posicion(0, 0);
		boolean primeraVez = false;

		for (int i = 0; i < arboles.length; i++) {
			if (arboles[i] == null) {
				throw new NullPointerException("Arbol nulo");
			} else if (primeraVez == false) {
				arbolMasAlejado = new Arbol(arboles[i]);
				arbolMasCentrado = new Arbol(arboles[i]);
				primeraVez = true;
			} else {

				if (arboles[i].getPosicion().distancia(cero) > arbolMasAlejado.getPosicion().distancia(cero)) {
					arbolMasAlejado = new Arbol(arboles[i]);
				}
				if (arboles[i].getPosicion().distancia(cero) < arbolMasCentrado.getPosicion().distancia(cero)) {
					arbolMasAlejado = new Arbol(arboles[i]);
				}

			}

		}

	}

	public Arbol[] duplicaBosque() {
		Arbol[] arbolTemporal = new Arbol[arboles.length];
		for (int i = 0; i < arboles.length; i++) {
			if (arboles[i] != null) {
				arbolTemporal[i] = new Arbol(arboles[i]);
			}
		}
		return arbolTemporal;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho < MINIMO || ancho > MAX_ANCHURA) {
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		} else {

			this.ancho = ancho;
		}
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto < MINIMO || alto > MAX_ALTURA) {
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		} else {
			this.alto = alto;
		}
	}

	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}

	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}

	@Override
	public String toString() {
		return "Bosque [arbolMasAlejado=" + arbolMasAlejado + ", arbolMasCentrado=" + arbolMasCentrado + "]";
	}

}
