package strategy;
import taller.Tarea;
import java.util.ArrayList;

/**
 * Estrategia de ordenamiento basada en la fecha de creación de las tareas.
 * 
 * Ordena la lista comparando los valores retornados por getFecha(), los cuales
 * deben estar en formato YYYY/MM/DD para garantizar un orden correcto.
 *
 * Esta clase forma parte del patrón Strategy utilizado para permitir al
 * administrador ordenar las tareas según distintos criterios.
 * 
 * Mientras más antigua la fecha, más arriba quedará la tarea en la lista.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class PrioridadFecha implements PrioridadStrategy {
	
	/**
     * Ordena la lista de tareas según sus fechas.
     *
     * @param lista lista de tareas que será ordenada por fecha
     */
	@Override 
	public void ordenar(ArrayList <Tarea> lista) {
		lista.sort((t1, t2) -> t1.getFecha().compareTo(t2.getFecha()));
		
	}

}
