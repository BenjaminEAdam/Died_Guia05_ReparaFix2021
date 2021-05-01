package package01;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Contratable{
	
	//Atributos
	
	private Herramienta herramienta;
	private LocalDate diaInicio;
	private LocalDate diaFin;
	private LocalDate diaDevolucion;
	
	//Método constructor
	
	public Alquiler (Herramienta herramienta, String diaInicio, String diaFin) {
		this.diaInicio= LocalDate.parse(diaInicio);
		this.herramienta = herramienta;
		this.diaFin = LocalDate.parse(diaFin);
	}
	
	//Getters y Setters.
	
	public Herramienta getHerramienta() {
		return herramienta;
	}
	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}
	public LocalDate getDiaInicio() {
		return diaInicio;
	}
	public void setDiaInicio(LocalDate diaInicio) {
		this.diaInicio = diaInicio;
	}
	public LocalDate getDiaFin() {
		return diaFin;
	}
	public void setDiaFin(LocalDate diaFin) {
		this.diaFin = diaFin;
	}
	public LocalDate getDiaDevolucion() {
		return diaDevolucion;
	}
	public void setDevolucion() {
		this.diaDevolucion=LocalDate.now();
	}
	
	//Método enMora() - Inciso 5) b) de la consigna
	
	public boolean enMora() {
		if (this.diaDevolucion.equals(null)) {
			if(LocalDate.now().isAfter(this.diaFin)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(this.diaDevolucion.isAfter(this.diaFin)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	// Método finalizado() - Inciso 6) de la consigna.
	
	public boolean finalizado() {
		if(this.diaDevolucion.equals(null)) {
			return false;
		}
		else {
			return true;
		}	
	}
	
	//Implementacion del método calcularCosto() - Inciso 5 de la consigna

	@Override
	public double calcularCosto() {
		if(diaDevolucion.equals(null)) {
			return this.herramienta.getCostoPorDia()*
					(ChronoUnit.DAYS.between(diaInicio, LocalDate.now()));		
		}
		else {
			return this.herramienta.getCostoPorDia()*
					(ChronoUnit.DAYS.between(diaInicio, diaDevolucion));
		}
	}
}
