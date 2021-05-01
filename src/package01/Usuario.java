package package01;

import java.util.ArrayList;

import package01.exceptions.AgendaOcupadaException;
import package01.exceptions.AlquilerNoEntregadoException;
import package01.exceptions.OficioNoCoincideException;

public class Usuario{
	
	//Atributos
	
	private String nombre;
	private String email;
	private String nroTarjeta; //para cobrar los servicios y alquileres. La validacion de este dato es tema aparte
	private ArrayList <Contratable> contrataciones;
	
	//Método constructor
	
	public Usuario(String nombre, String email, String nroTarjeta) {
		this.nombre = nombre;
		this.email = email;
		this.nroTarjeta = nroTarjeta;
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
	public String getNroTarjeta() {
		return nroTarjeta;
	}
	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}
	
	// Métodos contratar() con sobre carga - Inciso 8) y 9) de la consigna

	public void contratar(Servicio s, String fechaInicio, boolean urgente, Trabajador trabajador) {
		
		try {
			s.contratarServicio(fechaInicio, urgente, trabajador);
			this.contrataciones.add(s);
		} catch (OficioNoCoincideException | AgendaOcupadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void contratar(Herramienta herramienta, String diaInicio, String diaFin) 
							throws AlquilerNoEntregadoException {
		
		int herramientasNoDevueltas=0;
		
		for (Contratable c: contrataciones) {
			if(c instanceof Alquiler) {
				if(((Alquiler) c).finalizado()==false) {
					herramientasNoDevueltas++;
				}
			}
		}
		
		if(herramientasNoDevueltas==2) { //Si el sistema arranca en cero nunca podria tener mas de dos
			throw new AlquilerNoEntregadoException(herramientasNoDevueltas);
		}
		else {
			Alquiler a=new Alquiler(herramienta, diaInicio, diaFin);
			this.contrataciones.add(a);
		}
	}
	
	//Método devolverHerramienta()
	
	public void devolverHerramienta(Alquiler a) {
		
		for (Contratable c: contrataciones) {
			if (c instanceof Alquiler) {
				if(c.equals(a)) {
					((Alquiler) c).setDevolucion();
					this.contrataciones.remove(c);
				}
			}
		}
	}
}