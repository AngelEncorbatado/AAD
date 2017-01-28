
public class Direccion {
	
	private int id;
	private String calle;
	private String poblacion;
	private int cp;
	private Empresa empresa;
	
	public Direccion(String c, String p, int cp){
		calle=c;
		poblacion=p;
		this.cp=cp;
	}
	
	public Direccion() {
		
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
