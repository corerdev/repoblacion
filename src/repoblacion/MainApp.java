package repoblacion;
import modelo.Bosque;
import utilidades.consola;

public class MainApp {
	
	private static Bosque bosque;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			bosque = new Bosque(consola.leerAnchura(), consola.leerAltura(), consola.leerPoblacion());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		 catch (NullPointerException e){
			 System.out.println(e.getMessage());
		 }
		
		if (bosque!=null) {
			try {
				bosque.realizarCalculos();
				} catch (NullPointerException e){
					 System.out.println(e.getMessage());
				}
		System.out.println(bosque.toString());
		}
	}

}
