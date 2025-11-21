package strategy;
import java.util.ArrayList;
import taller.Tarea;

/**
 * Interfaz que define el comportamiento para las estrategias de
 * ordenamiento de tareas dentro del sistema.
 * 
 * Cada implementación debe aplicar un criterio distinto para ordenar
 * una lista de objetos Tarea. Esto permite cambiar la forma de ordenar
 * sin modificar el código que utiliza la estrategia.
 *
 * Este patrón corresponde a Strategy, utilizado por el administrador
 * cuando elige cómo priorizar las tareas de un proyecto.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public interface PrioridadStrategy {
	
	/**
     * Ordena la lista de tareas según el criterio de la estrategia implementada.
     *
     * @param lista lista de tareas a ordenar
     */
	public void ordenar(ArrayList<Tarea> lista);
	

}
