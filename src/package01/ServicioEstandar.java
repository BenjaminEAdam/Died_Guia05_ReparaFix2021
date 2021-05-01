package package01;

//Enum que define los tipos de servicios estandar disponibles.

enum serviciosEstandar {Reparación,Mantenimiento,Instalación}

public class ServicioEstandar extends Servicio {
	
	//Atributos
	
	private serviciosEstandar tipoDeServicio;
	private double precioEstandar;
	
	//Método constructor
	
	public ServicioEstandar(String nombre, Oficio oficio, serviciosEstandar tipoDeServicio, double precioEstandar) {
		super(nombre, oficio);
		this.tipoDeServicio=tipoDeServicio;
		this.precioEstandar = precioEstandar;
	}
	
	//Getters y Setters.

	public double getPrecioEstandar() {
		return precioEstandar;
	}
	public serviciosEstandar getTipoDeServicio() {
		return tipoDeServicio;
	}
	public void setTipoDeServicio(serviciosEstandar tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}
	public void setPrecioEstandar(double precioEstandar) {
		this.precioEstandar = precioEstandar;
	}
	
	//Implementacion del método calcularCosto() - Inciso 4 de la consigna

	@Override
	public double calcularCosto() {
		if(this.trabajador.equals(null)) {
			System.out.println("Este servicio no fue contratado, por lo que no tiene un costo final");
			return 0;
		}
		else {
			if(this.urgente) {
				double costoParcial = precioEstandar + (precioEstandar * (trabajador.getPorcentajeComision() / 100));
				return costoParcial + costoParcial*0.5;
			}
			else {
				return precioEstandar + (precioEstandar * (trabajador.getPorcentajeComision() / 100));
			}
		}
	}
}