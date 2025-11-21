package taller;

import visitor.TareaVisitor;

/**
 * Clase abstracta que representa una tarea dentro del sistema TaskForge.
 * 
 * Una tarea posee información común como ID de proyecto, ID de tarea,
 * descripción, estado, responsable, complejidad y fecha. Las subclases
 * concretas (Bug, Feature y Documentacion) definen comportamientos específicos,
 * incluyendo su tratamiento mediante el patrón Visitor.
 *
 * Esta clase modela el concepto general de una tarea y permite aplicar
 * polimorfismo en el sistema.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public abstract class Tarea {
	protected String proyectoId;
	protected String tareaId;
	protected String descripcion;
	protected String estado;
	protected String responsable;
	protected String complejidad;
	protected String fecha;

	/**
	 * Constructor base para cualquier tipo de tarea.
	 *
	 * @param proyectoId  ID del proyecto al que pertenece la tarea
	 * @param tareaId     ID único de la tarea
	 * @param descripcion descripción de la tarea
	 * @param estado      estado actual de la tarea
	 * @param responsable usuario responsable
	 * @param complejidad nivel de complejidad asignado
	 * @param fecha       fecha de creación en formato YYYY/MM/DD
	 */
	public Tarea(String proyectoId, String tareaId, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {

		this.proyectoId = proyectoId;
		this.tareaId = tareaId;
		this.descripcion = descripcion;
		this.estado = estado;
		this.responsable = responsable;
		this.complejidad = complejidad;
		this.fecha = fecha;
	}

	/** @return ID del proyecto asociado */
	public String getProyectoID() {
		return proyectoId;
	}

	/** @return ID único de la tarea */

	public String getTareaID() {
		return tareaId;
	}

	/** @return descripción de la tarea */

	public String getDescripcion() {
		return descripcion;
	}

	/** @return estado actual de la tarea */

	public String getEstado() {
		return estado;
	}

	/** @return nombre del usuario responsable */

	public String getResponsable() {
		return responsable;
	}

	/** @return nivel de complejidad */

	public String getComplejidad() {
		return complejidad;
	}

	/** @return fecha de creación de la tarea */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Método del patrón Visitor que permite aplicar una acción específica según el
	 * tipo concreto de la tarea.
	 *
	 * @param visitor visitor que ejecutará la operación correspondiente
	 */
	public abstract void aceptar(TareaVisitor visitor);

	@Override
	public String toString() {
		return "Tarea [proyectoId=" + proyectoId + ", tareaId=" + tareaId + ", descripcion=" + descripcion + ", estado="
				+ estado + ", responsable=" + responsable + ", complejidad=" + complejidad + ", fecha=" + fecha + "]";
	}

}
