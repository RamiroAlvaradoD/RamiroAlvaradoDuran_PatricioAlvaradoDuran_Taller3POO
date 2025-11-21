package taller;

import visitor.TareaVisitor;

/**
 * Representa una tarea de tipo Bug dentro del sistema TaskForge.
 * 
 * Esta clase hereda todos los atributos y comportamientos de
 * Tarea, diferenciándose únicamente por su tipo para efectos del patrón Visitor.
 *
 * El método aceptar permite aplicar una acción específica definida por un
 * TareaVisitor, delegando la operación al método visitar(Bug).
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class Bug extends Tarea {
	

	/**
     * Constructor del Bug.
     *
     * @param proyectoId   ID del proyecto al que pertenece
     * @param tareaId      ID único de la tarea
     * @param descripcion  descripción del bug
     * @param estado       estado actual del bug
     * @param responsable  usuario asignado a resolverlo
     * @param complejidad  nivel de complejidad del bug
     * @param fecha        fecha de creación de la tarea
     */
	public Bug(String proyectoId, String tareaId, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyectoId, tareaId, descripcion, estado, responsable, complejidad, fecha);
	}

	/**
     * Acepta al visitor y le permite ejecutar su acción específica para Bugs.
     *
     * @param visitor objeto que implementa TareaVisitor
     */
	@Override
	public void aceptar(TareaVisitor visitor) {
		visitor.visitar(this);

		
	}

}
