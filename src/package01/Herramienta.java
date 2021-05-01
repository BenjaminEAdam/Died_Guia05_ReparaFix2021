package package01;

public class Herramienta {
	
	private String nombre;
	private double costoPorDia;
	
	public Herramienta(String nombre, double costoPorDia) {
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCostoPorDia() {
		return costoPorDia;
	}
	public void setCostoPorDia(double costoPorDia) {
		this.costoPorDia = costoPorDia;
	}
	
}
