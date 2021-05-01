package package01.exceptions;

import java.time.LocalDate;

public class AgendaOcupadaException extends Exception{
	
	public AgendaOcupadaException(LocalDate fechaInicio){
		super("En la fecha " + fechaInicio 
				+ " el trabajador seleccionado se encuentra ocupado.");
	}

}
