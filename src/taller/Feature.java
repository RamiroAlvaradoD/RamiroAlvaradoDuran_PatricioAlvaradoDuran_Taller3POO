package taller;

import visitor.TareaVisitor;

public class Feature extends Tarea {

	public Feature(String proyectoId, String tareaId, String descripcion, String estado, String responsable,
			String complejidad, String fecha) {
		super(proyectoId, tareaId, descripcion, estado, responsable, complejidad, fecha);
	}

	@Override
	public void aceptar(TareaVisitor visitor) {
		//completar mas tarde con el metodo en la clase visitor
		
	}

}
