package taller;
import java.util.ArrayList;

import strategy.PrioridadStrategy;

/**
 * Representa un proyecto dentro del sistema TaskForge.
 * 
 * Cada proyecto tiene un ID, un nombre, un responsable y una lista de tareas
 * asociadas. Permite agregar y eliminar tareas, así como ordenarlas utilizando
 * el patrón Strategy para aplicar distintos criterios de prioridad.
 *
 * Esta clase es fundamental para la organización del sistema, ya que agrupa
 * todas las tareas relacionadas a un objetivo común.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class Proyecto {
	private String proyectoID;
	private String nombre;
	private String responsable;
	private ArrayList<Tarea> tareas;
	
	/**
     * Constructor del proyecto.
     *
     * @param proyectoID ID único del proyecto
     * @param nombre nombre del proyecto
     * @param responsable persona encargada del proyecto
     */
	public Proyecto(String proyectoID, String nombre, String responsable) {
		this.proyectoID = proyectoID;
		this.nombre = nombre;
		this.responsable = responsable;
		this.tareas = new ArrayList<>();
	}

	/**
     * @return ID del proyecto
     */
	public String getProyectoID() {
		return proyectoID;
	}

	/**
     * @return nombre del proyecto
     */
	public String getNombre() {
		return nombre;
	}

	/**
     * @return responsable del proyecto
     */
	public String getResponsable() {
		return responsable;
	}

	/**
     * @return lista de tareas asociadas al proyecto
     */
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	
	/**
     * Agrega una tarea a la lista del proyecto.
     *
     * @param t tarea a agregar
     */
	public void addTarea(Tarea t) {
		tareas.add(t);
	}
	
	 /**
     * Elimina una tarea del proyecto según su ID.
     *
     * @param tareaId ID de la tarea a eliminar
     */
	public void removeTarea(String tareaId) {
		tareas.removeIf(t -> t.getTareaID().equals(tareaId));
	}
	
	/**
     * Ordena las tareas del proyecto utilizando una estrategia de prioridad.
     * 
     * Esta implementación aplica el patrón Strategy, permitiendo utilizar
     * distintos criterios de ordenamiento sin modificar la clase Proyecto.
     *
     * @param strategy estrategia de ordenamiento a aplicar
     */
	public void ordenarTareas(PrioridadStrategy strategy) {
		strategy.ordenar(tareas);
		
	}

	/**
     * Representación legible del proyecto.
     */
	@Override
	public String toString() {
		return "Proyecto [proyectoID=" + proyectoID + ", nombre=" + nombre + ", responsable=" + responsable + "]";
	}

}
