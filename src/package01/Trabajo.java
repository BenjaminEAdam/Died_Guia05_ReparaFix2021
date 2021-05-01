package package01;

import java.time.LocalDate;

public class Trabajo {
	
	//Atributos
	
	private Oficio oficio;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	//Método constructor.
	
	public Trabajo(Oficio oficio, LocalDate fechaInicio) {
		this.oficio = oficio;
		this.fechaInicio = fechaInicio;
	}
	
	//Getters y Setters.

	public Oficio getOficio() {
		return oficio;
	}
	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin() {
		this.fechaFin = LocalDate.now();
	}
	
	// Método finalizado() - Inciso 6) de la consigna.
	
	public boolean finalizado() {
		if(this.fechaFin.equals(null)) {
			return false;
		}
		else {
			return true;
		}
	}

}