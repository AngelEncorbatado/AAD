import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private int id;
	private String fecha;
	private List<Item> item;
	private Empresa empresa;
	
	public Pedido(String fecha) {
		this.fecha=fecha;
		item = new ArrayList<Item>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
