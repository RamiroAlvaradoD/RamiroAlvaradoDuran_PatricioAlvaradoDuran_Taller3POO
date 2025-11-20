package factory;

import taller.Tarea;
import taller.Bug;
import taller.Feature;
import taller.Documentacion;

public class TareaFactoryImpl implements TareaFactory {

	public Tarea crearTarea(String tipo, String proyectoID, String tareaID, String descripcion,
			String estado, String responsable, String complejidad, String fecha) {
		switch (tipo.toLowerCase()) {
		case "bug": return new Bug(proyectoID, tareaID, descripcion, estado, responsable, complejidad, fecha);
		
		case "feature": return new Feature(proyectoID, tareaID, descripcion, estado, responsable, complejidad, fecha);
		
		case "documentacion": return new Documentacion(proyectoID, tareaID, descripcion, estado,
				responsable, complejidad, fecha);
		default: throw new IllegalArgumentException("Tipo de tarea Invalido");
		}
		
	}
}
