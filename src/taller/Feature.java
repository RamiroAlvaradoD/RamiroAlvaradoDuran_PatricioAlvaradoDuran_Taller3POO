package taller;

import visitor.TareaVisitor;

/**
 * Representa una tarea de tipo Feature dentro del sistema TaskForge.
 * 
 * Hereda todos los atributos y comportamientos de Tarea y solamente
 * redefine el método aceptar para operar correctamente con el patrón Visitor.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class Feature extends Tarea {
	
	/**
     * Constructor de una tarea Feature.
     *
     * @param proyectoId   ID del proyecto al que pertenece
     * @param tareaId      ID único de la tarea
     * @param descripcion  descripción de la funcionalidad
     * @param estado       estado actual
     * @param responsable  usuario responsable de implementarla
     * @param complejidad  nivel de complejidad
     * @param fecha        fecha de creación
     */
	public Feature(String proyectoId, String tareaId, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyectoId, tareaId, descripcion, estado, responsable, complejidad, fecha);
	}

	/**
     * Acepta un visitor y ejecuta la acción correspondiente para Features.
     *
     * @param visitor implementación de TareaVisitor
     */
	@Override
	public void aceptar(TareaVisitor visitor) {
		visitor.visitar(this);
		
	}

}
