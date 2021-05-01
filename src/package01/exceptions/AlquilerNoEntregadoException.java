package package01.exceptions;

public class AlquilerNoEntregadoException extends Exception{
	
	public AlquilerNoEntregadoException(int cantHerrNoDevueltas) {
		super("No puedes alquilar una nueva herramienta porque tienes " 
				+ cantHerrNoDevueltas + " herramientas sin devolver.");
	}

}
