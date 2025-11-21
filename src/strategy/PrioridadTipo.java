package strategy;
import java.util.ArrayList;
import taller.Tarea;

/**
 * Estrategia de ordenamiento basada en el tipo de tarea.
 * 
 * El orden se determina comparando el nombre simple de la clase
 * (Bug, Feature o Documentacion). Esto permite agrupar las tareas
 * por tipo según el orden lexicográfico de sus nombres.
 * 
 * Esta clase forma parte del patrón Strategy implementado para el
 * sistema de prioridades del administrador.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class PrioridadTipo implements PrioridadStrategy {

	/**
     * Ordena la lista de tareas comparando los nombres de sus clases.
     *
     * @param lista lista de tareas que será ordenada por tipo
     */
	@Override
	public void ordenar(ArrayList<Tarea> lista) {
		lista.sort((t1, t2) -> t1.getClass().getSimpleName().compareTo(t2.getClass().getSimpleName()));
		
		
	}

}
