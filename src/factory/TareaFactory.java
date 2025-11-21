package factory;

import taller.Tarea;

public interface TareaFactory {
    Tarea crearTarea(String tipo, String proyectoID, String tareaID, String descripcion,
                     String estado, String responsable, String complejidad, String fecha);
}
