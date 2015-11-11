package casting;

public class Trabajador extends Persona {
	
	String segsocial;
	
	Trabajador(){		
	}
	
	Trabajador(String num, String nombre, int edad){
		super(nombre,edad);
		segsocial=num;
	}
	
	public String getSegsocial() {
		return segsocial;
	}

	public void setSegsocial(String segsocial) {
		this.segsocial = segsocial;
	}

}
