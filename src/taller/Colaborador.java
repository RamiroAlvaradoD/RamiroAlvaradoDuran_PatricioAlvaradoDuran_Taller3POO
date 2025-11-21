package taller;
import sistema.MenuColab;
import sistema.Sistema;
import visitor.TareaVisitor;

/**
 * Representa a un usuario con rol Colaborador dentro del sistema TaskForge.
 * 
 * El colaborador puede ver proyectos, ver sus tareas asignadas, actualizar
 * estados de tareas y ejecutar acciones definidas mediante el patrón Visitor.
 * 
 * Esta clase utiliza la instancia única del sistema para obtener y modificar
 * la información necesaria.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class Colaborador extends Usuario {
	

	/**
     * Constructor del colaborador.
     *
     * @param username nombre de usuario
     * @param password contraseña del colaborador
     */
	public Colaborador(String username, String password) {
		super(username, password, "Colaborador");
	}

	/**
     * Muestra el menú exclusivo para colaboradores.
     */
	@Override
	public void mostrarMenu() {
		MenuColab menu = new MenuColab(this);
		menu.mostrarOpciones();
		
	}
	
	/**
     * Muestra todos los proyectos disponibles en el sistema.
     */
	public void verProyectos() {
		for (Proyecto p : Sistema.getInstancia().getProyectos()) {
			System.out.println(p);
		}
	}
	
	/**
     * Muestra las tareas asignadas al colaborador.
     */
	public void verTareasAsignadas() {
		String usuario = getUsername();
		for (Tarea t : Sistema.getInstancia().getTareas()) {
			if (t.getResponsable().equals(usuario)) {
			System.out.println(t);
			}
		}
	}
	
	/**
     * Actualiza el estado de una tarea si pertenece al colaborador.
     *
     * @param tareaID ID de la tarea a modificar
     * @param nuevoEstado nuevo estado a establecer
     */
	public void actualizarEstadoTarea(String tareaID, String nuevoEstado) {
		Tarea t =  Sistema.getInstancia().buscarTarea(tareaID);
		if (t !=null && t.getResponsable().equals(getUsername())) {
			t.estado = nuevoEstado;
			System.out.println("Estado Actualizado");
		}
		else {
			System.out.println("No tienes permiso o la tarea no existe");
		}
	}
	
	/**
     * Ejecuta un visitor sobre todas las tareas asignadas al colaborador.
     *
     * @param visitor implementación de TareaVisitor a ejecutar
     */
	public void ejecutarVisitor(TareaVisitor visitor ) {
		for (Tarea t :Sistema.getInstancia().getTareas()) {
			if (t.getResponsable().equals(getUsername())) {
				t.aceptar(visitor);
			}
		}
	}

}
