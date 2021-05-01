package package01;

public class Consideraciones {
	
	/*

	 En esta clase dejo escritas las consideraciones que  tuve en cuenta al resolver el trabajo practico.

Los oficios fueron definidos de tipo enum para mantener cierta consistencia en los datos.
por ejemplo un mismo oficio puede tener varios nombres (alba�il, alba�ileria, construccion, etc)
al ser de tipo enum ya est� predefinido con anterioridad.

Desde el punto de vista del usuario los oficios, trabajadores, servicios y herrramientas ya est�n creados 
cuando comienza a interactuar con el sistema. No deberia poder crearlos ni modificarlos, de eso se encarga 
el administrador del sistema.

SERVICIOS:
Cuando un usuario desea contratar un servicio, se le pedir� que seleccione uno de los servicios ya creados.
Estos servicios tendr�n nombre, oficio y tipo de servicio al cual pertenecen. (estand�r o personalizado). 
Los est�ndar adem�s ser�n de Reparaci�n, Mantenimiento o Instalaci�n y tendr�n un precio estand�r asociado.
Una vez seleccionado el servicio los usuarios podran elegir una fecha de inicio (yyyy-MM-dd) para dar comienzo 
al servicio, un trabajador que les realice el trabajo y si lo desean de forma urgente o no.
Con estos par�metros se crea el trabajo que brindar� el servicio al usuario.
Luego se le intenta asignar dicho trabajo al trabajador escogido por el usuario, si esto resulta imposible por 
las causas descriptas en la consigna del trabajo pr�ctico entonces se lanzan exepciones y el servicio no es 
contratado, es decir no es agregado a la lista de contratables del usuario. De lo contrario el trabajo, el 
trabajador y el atributo urgente son seteados al servicio elegido y el servicio es agregado a la lista 
de contratables del usuario.

ALQUILERES
A diferencia de los servicios, los alquileres son creados reci�n al momento que el usuario desea alquilar una
herramienta, para esto debe seleccionar una herramienta (creada con anterioridad), un dia de inicio (yyyy-MM-dd) 
y un dia de fin (yyyy-MM-dd) cuando se debe devolver la herramienta. (no se capturan los errores de ingresar mal 
la fecha) Si el usuario ya tiene dos herramientas alquiladas, el alquiler no es creado y tampoco agregado a la 
lista de contratables del usuario y el flujo del programa es manejado por la exception correspondiente. 
De lo contrario el alquiler es creado y a�adido a la lista de contratables del usuario.

Un trabajador solo trabaja 4 horas por dia en un trabajo (ni m�s ni menos). Por que si solo estamos validando 
que un trabajador no pueda comenzar dos trabajos el mismo d�a, puede pasar que comienze hoy un trabajo de tres 
dias y ma�ana se le asigna otro trabajo, y al d�a siguiente otro (llegando a doce horas por d�a) y esto puede 
ser peor. La verdad est� muy verde el tema. Por simplicidad para los c�lculos tom� esta decision. 

Cuando un trabajador finaliza un trabajo no lo elimino de su lista de trabajos, de esta forma se puede obtener 
un historial de trabajos.

En los servicios personalizados cambi� el "costo presupuestado" por "costo de mano de obra".

No cree ning�n m�todo que abarque la siguiente l�gica del enunciado "Al finalizar el mes autom�ticamente 
ReparaFix le debitar� de la tarjeta del usuario el monto de los servicios contratados en ese mes."

La clase App (m�todo main) fue usada para hacer pruebas parciales pero decid� eliminarla para la entrega final 
del trabajo. Pero si considera necesario puedo acomodarla bien y crear cierto flujo de interaccion y un men� 
de navegacion y subirlo a github.
	 
	 */

}
