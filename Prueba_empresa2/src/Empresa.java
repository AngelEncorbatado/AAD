import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private String cif;
	private String nombre;
	private int empleados;
	private Direccion direccion;
	private List<Pedido> pedido;
	
	public Empresa(String nombre, String cif, Integer empleados) {
		this.nombre=nombre;
		this.cif=cif;
		this.empleados=empleados;
		this.direccion = new Direccion();
		this.direccion.setEmpresa(this);
		this.setPedido(new ArrayList<Pedido>());
	}
	
	public Empresa(){}
	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEmpleados() {
		return empleados;
	}
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
		
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	public void addPedido(Pedido pedido){
		pedido.setEmpresa(this);
		this.pedido.add(pedido);
	}

}
