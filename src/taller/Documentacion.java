package taller;

import visitor.TareaVisitor;

/**
 * Representa una tarea de tipo Documentacion dentro del sistema TaskForge.
 *
 * Hereda todos los atributos y comportamientos de la clase Tarea, y define
 * su comportamiento particular para el patrón Visitor.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class Documentacion extends Tarea{

	/**
     * Constructor de una tarea de documentación.
     *
     * @param proyectoId   ID del proyecto al que pertenece la tarea
     * @param tareaId      ID único de la tarea
     * @param descripcion  contenido descriptivo
     * @param estado       estado actual de la tarea
     * @param responsable  usuario responsable
     * @param complejidad  nivel de complejidad
     * @param fecha        fecha de creación
     */
	public Documentacion(String proyectoId, String tareaId, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyectoId, tareaId, descripcion, estado, responsable, complejidad, fecha);
	}

	/**
     * Acepta un visitor y llama la operación específica para tareas
     * de documentación.
     *
     * @param visitor implementación de TareaVisitor
     */
	@Override
	public void aceptar(TareaVisitor visitor) {
		visitor.visitar(this);
		
	}

}
