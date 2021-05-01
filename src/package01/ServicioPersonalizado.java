package package01;

public class ServicioPersonalizado extends Servicio {
	
	//Atributos
	
	private double costoManoDeObra;
	private double costoDeMateriales;
	private double costoDeTransporte;
	
	//Constructor
	
	public ServicioPersonalizado(String nombre, Oficio oficio) {
		super(nombre, oficio);
	}
	
	//Getters y Setters.

	public double getCostoManoDeObra() {
		return costoManoDeObra;
	}
	public void setCostoManoDeObra(double costoManoDeObra) {
		this.costoManoDeObra = costoManoDeObra;
	}
	public double getCostoDeMateriales() {
		return costoDeMateriales;
	}
	public void setCostoDeMateriales(double costoDeMateriales) {
		this.costoDeMateriales = costoDeMateriales;
	}
	public double getCostoDeTransporte() {
		return costoDeTransporte;
	}
	public void setCostoDeTransporte(double costoDeTransporte) {
		this.costoDeTransporte = costoDeTransporte;
	}
	
	//Implementacion del método calcularCosto() - Inciso 4 de la consigna

	@Override
	public double calcularCosto() {
		if(this.trabajo.finalizado()) {
			if (this.urgente) {
				double costoParcial = this.costoManoDeObra
						+this.costoDeMateriales
						+this.costoDeTransporte;
				return costoParcial + costoParcial*0.5;
			}
			else {
				return this.costoManoDeObra
						+this.costoDeMateriales
						+this.costoDeTransporte;
			}
		}
		else {
			System.out.println("Este servicio está terminado, por lo que no tiene un costo final");
			return 0;
		}
	}
}