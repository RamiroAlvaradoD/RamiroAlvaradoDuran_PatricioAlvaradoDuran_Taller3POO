package taller;
import java.io.FileWriter;
import java.io.IOException;

import sistema.MenuAdmin;
import sistema.Sistema;
import strategy.PrioridadStrategy;

/**
 * Representa a un usuario con rol Administrador dentro del sistema TaskForge.
 * 
 * El administrador puede gestionar proyectos y tareas, asignar estrategias de
 * prioridad y generar reportes. Todas las operaciones se ejecutan utilizando
 * la instancia única del sistema (patrón Singleton).
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class Administrador extends Usuario {

	/**
     * Constructor del administrador.
     *
     * @param username nombre de usuario
     * @param password contraseña del administrador
     */
	public Administrador(String username, String password) {
		super(username, password, "Administrador");
	}

	/**
     * Muestra el menú exclusivo para administradores.
     */
	@Override
	public void mostrarMenu() {
		MenuAdmin menu = new MenuAdmin(this);
		menu.mostrarOpciones();
		
	}
	
	/**
     * Agrega un proyecto al sistema.
     *
     * @param proyecto proyecto a agregar
     */
	public void agregarProyecto(Proyecto proyecto) {
		Sistema.getInstancia().agregarProyecto(proyecto);
	}
	
	/**
     * Elimina un proyecto del sistema según su ID.
     *
     * @param proyectoID ID del proyecto a eliminar
     */
	public void eliminarProyecto(String proyectoID) {
		Sistema.getInstancia().eliminarProyecto(proyectoID);
	}
	
	/**
     * Agrega una nueva tarea al sistema.
     *
     * @param tarea tarea a agregar
     */
	public void agregarTarea(Tarea tarea) {
		Sistema.getInstancia().agregarTarea(tarea);
	}
	
	/**
     * Elimina una tarea del sistema según su ID.
     *
     * @param tareaID ID de la tarea a eliminar
     */
	public void eliminarTarea(String tareaID) {
		Sistema.getInstancia().eliminarTarea(tareaID);
	}
	
	/**
     * Aplica una estrategia de prioridad (Strategy) para ordenar las tareas
     * de un proyecto determinado.
     *
     * @param proyecto proyecto cuyas tareas serán ordenadas
     * @param strategy estrategia de ordenamiento a aplicar
     */
	public void asignarPrioridad(Proyecto proyecto, PrioridadStrategy strategy) {
	    proyecto.ordenarTareas(strategy);
	}

	
	/**
     * Genera un archivo llamado reporte.txt que contiene todos los proyectos
     * registrados en el sistema junto con sus tareas, estados, responsables
     * y otros datos relevantes.
     */
	public void generarReporte() {
        try {
            FileWriter fw = new FileWriter("reporte.txt");

            for (Proyecto p : Sistema.getInstancia().getProyectos()) {
                fw.write("Proyecto: " + p.getNombre() + " (ID: " + p.getProyectoID() + ")\n");
                fw.write("Responsable: " + p.getResponsable() + "\n");
                fw.write("Tareas:\n");

                for (Tarea t : p.getTareas()) {
                    fw.write(
                        "  - " + t.getTareaID() +
                        " | " + t.getDescripcion() +
                        " | Estado: " + t.getEstado() +
                        " | Responsable: " + t.getResponsable() +
                        " | Complejidad: " + t.getComplejidad() +
                        " | Fecha: " + t.getFecha() +
                        "\n"
                    );
                }

                fw.write("\n");
            }

            fw.close();
            System.out.println("Reporte generado en reporte.txt");

        } catch (IOException e) {
            System.out.println("Error generando reporte: " + e.getMessage());
        }
    }

}
