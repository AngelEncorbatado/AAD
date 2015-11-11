package casting;

public class Principal {

	public static void main(String[] args) {
		
		Object[] listado = new Object[5];
		
		Persona p = new Persona("Manolo",25);
		Trabajador t = new Trabajador("232324","Pepe",30);
		
		listado[0] = t;
		Persona p2 = (Persona) listado[0];
		
		System.out.println("He recuperado "+p2.getNombre());
		

	}

}
