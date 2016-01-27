package programa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario {
	
	private int id;
	private String nombre;
	private DatosKM datoskm;
	
	private List<Historial> historial = new ArrayList<Historial>();
	
	public Usuario(){
		setDatoskm(new DatosKM());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DatosKM getDatoskm() {
		return datoskm;
	}
	public void setDatoskm(DatosKM datoskm) {
		this.datoskm = datoskm;
		datoskm.setUsuario(this);
	}
	public List<Historial> getHistorial() {
		return historial;
	}
	public void setHistorial(List<Historial> historial) {
		this.historial = historial;
	}
	public void addHistorial(Historial historial){
		historial.setUsuario(this);
		this.historial.add(historial);
	}
	

}
