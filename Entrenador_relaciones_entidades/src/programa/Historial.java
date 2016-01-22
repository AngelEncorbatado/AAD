package programa;

import java.util.Date;

public class Historial {
	private Date fecha;
	private String sesion;
	private int id;
	private Usuario usuario;
	
	public Historial(){
		
	}
	
	public Historial(Date fecha, String sesion) {
		super();
		this.fecha = fecha;
		this.sesion = sesion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getSesion() {
		return sesion;
	}
	public void setSesion(String sesion) {
		this.sesion = sesion;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
