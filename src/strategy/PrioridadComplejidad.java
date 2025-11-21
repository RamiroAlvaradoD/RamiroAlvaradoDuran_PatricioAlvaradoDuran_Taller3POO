package strategy;

import java.util.ArrayList;

import taller.Tarea;

/**
 * Estrategia de ordenamiento basada en la complejidad de las tareas.
 * 
 * Ordena la lista recibida según el valor de complejidad, utilizando
 * el método compareTo() del String retornado por getComplejidad().
 * 
 * Esta estrategia forma parte del patrón Strategy implementado 
 * para permitir diferentes formas de ordenar las tareas de un proyecto.
 *
 * Complejidades típicas: "Alta", "Media", "Baja".
 * El comportamiento exacto depende del orden lexicográfico.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class PrioridadComplejidad implements PrioridadStrategy {

	
	/**
     * Ordena una lista de tareas según su complejidad.
     *
     * @param lista lista de tareas a ordenar
     */
	@Override
	public void ordenar(ArrayList<Tarea> lista) {
		lista.sort((t1, t2) -> t1.getComplejidad().compareTo(t2.getComplejidad()));
		
	}

}
