package package01.exceptions;

import package01.Oficio;

public class OficioNoCoincideException extends Exception{
	
	public OficioNoCoincideException(Oficio oficioTrabajo, Oficio oficioTrabajador) {
		super("Para realizar este trabajo se requiere el oficio de: " + oficioTrabajo 
				+ ". Pero el oficio del trabajador selleccionado es de: " + oficioTrabajador + ".");
	}

}
