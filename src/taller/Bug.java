package taller;

import visitor.TareaVisitor;

public class Bug extends Tarea {

	public Bug(String proyectoId, String tareaId, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyectoId, tareaId, descripcion, estado, responsable, complejidad, fecha);
	}

	@Override
	public void aceptar(TareaVisitor visitor) {
		visitor.visitar(this);

		
	}

}
