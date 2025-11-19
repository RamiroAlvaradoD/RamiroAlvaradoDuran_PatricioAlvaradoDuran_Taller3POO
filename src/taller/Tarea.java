package taller;
import visitor.TareaVisitor;

public abstract class Tarea {
	protected String proyectoId;
	protected String tareaId;
	protected String descripcion;
	protected String estado;
	protected String responsable;
	protected String complejidad;
	protected String fecha;

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

	public String getProyectoId() {
		return proyectoId;
	}

	public String getTareaId() {
		return tareaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public String getResponsable() {
		return responsable;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public String getFecha() {
		return fecha;
	}
	
	public abstract void aceptar(TareaVisitor visitor);

}
