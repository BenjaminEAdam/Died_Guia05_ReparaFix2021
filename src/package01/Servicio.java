package package01;

import java.time.LocalDate;

import package01.exceptions.AgendaOcupadaException;
import package01.exceptions.OficioNoCoincideException;


public abstract class Servicio implements Contratable{
	
	//Atributos
	
	protected String nombre;
	protected Oficio oficio;
	protected boolean urgente;
	protected Trabajo trabajo;
	protected Trabajador trabajador;

	//Método constructor
	
	public Servicio(String nombre, Oficio oficio) {
		this.nombre=nombre;
		this.oficio=oficio;
	}
	
	//Getters y Setters.

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	
	public boolean isUrgente() {
		return urgente;
	}
	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}
	public Trabajo getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	//Método contratarServicio() - Para resolver la implementación 
	//de contratar() del Usuario - Inciso 8) de la consigna.
	
	public void contratarServicio(String fechaInicio, boolean urgente, Trabajador trabajador) 
			throws OficioNoCoincideException, AgendaOcupadaException{
		
		LocalDate fechaDeInicio=LocalDate.parse(fechaInicio);
		
		Trabajo t=new Trabajo(this.oficio, fechaDeInicio);
		
		trabajador.agregarTrabajo(t);
		
		this.setUrgente(urgente);
		this.setTrabajo(t);
		this.setTrabajador(trabajador);
		
	}
	
	//Método abstracto
	
	public abstract double calcularCosto();

}
