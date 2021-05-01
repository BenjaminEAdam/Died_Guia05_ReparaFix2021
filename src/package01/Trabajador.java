package package01;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import package01.exceptions.AgendaOcupadaException;
import package01.exceptions.OficioNoCoincideException;

public class Trabajador {
	
	//Atributos
	
	private ArrayList <Trabajo> trabajos;
	private String nombre;
	private String email;
	private Oficio oficio;
	private double costoPorHora;
	private double porcentajeComision;
	
	//Método constructor
	
	public Trabajador(String nombre, String email, Oficio oficio, double costoPorHora, double porcentajeComision) {
		this.nombre = nombre;
		this.email = email;
		this.oficio = oficio;
		this.costoPorHora = costoPorHora;
		this.porcentajeComision = porcentajeComision;
	}
	
	//Getters y Setters.
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	public double getCostoPorHora() {
		return costoPorHora;
	}
	public void setCostoPorHora(double costoPorHora) {
		this.costoPorHora = costoPorHora;
	}
	public double getPorcentajeComision() {
		return porcentajeComision;
	}
	public void setPorcentajeComision(double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}
	
	//Métodos de finalización de un trabajo y por lo tanto tambien del servicio asociado a él.
	//Tenemos dos lógicas diferentes, una para los servicios personalizados y otra para los estándar.
	
	public void finalizarServicioPersonalizado(ServicioPersonalizado s, double costoDeMateriales, double costoDeTransporte) {
		s.setCostoDeMateriales(costoDeMateriales);
		s.setCostoDeTransporte(costoDeTransporte);
		s.getTrabajo().setFechaFin();
		double costoManoDeObra = this.costoPorHora * 4 * // todos los trabajadores trabajan cuatro horas al dia en un servicio (ver consideraciones)
				ChronoUnit.DAYS.between(s.getTrabajo().getFechaInicio(), s.getTrabajo().getFechaFin());
		s.setCostoManoDeObra(costoManoDeObra);
	}
	
	public void finalizarServicioEstandar(ServicioEstandar s) {
		s.getTrabajo().setFechaFin();	
	}
	
	//Método agregarTrabajo() - Inciso 7) de la consigna
	
	public void agregarTrabajo(Trabajo trabajo) 
			throws OficioNoCoincideException, AgendaOcupadaException{
		boolean agendaOcupada = false;
		if (trabajo.getOficio() != this.oficio) {
			throw new OficioNoCoincideException(trabajo.getOficio(), this.oficio);
		}
		for (Trabajo t: this.trabajos) {
			if (t.getFechaInicio().equals(trabajo.getFechaInicio())){
				agendaOcupada=true;
			}
		}
		if (agendaOcupada) {
			throw new AgendaOcupadaException(trabajo.getFechaInicio());
		}
		this.trabajos.add(trabajo);
		System.out.println("Trabajo agregado coorectamente a: "
							+ this.nombre + ".");
	}

}
