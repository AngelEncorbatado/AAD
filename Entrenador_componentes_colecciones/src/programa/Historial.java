package programa;

import java.util.Date;

public class Historial {
	private Date fecha;
	private String sesion;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((sesion == null) ? 0 : sesion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historial other = (Historial) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (sesion == null) {
			if (other.sesion != null)
				return false;
		} else if (!sesion.equals(other.sesion))
			return false;
		return true;
	}
	
}
