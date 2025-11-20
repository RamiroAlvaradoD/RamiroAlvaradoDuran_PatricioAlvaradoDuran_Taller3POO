package taller;
import sistema.MenuAdmin;
import sistema.Sistema;
import strategy.PrioridadStrategy;

public class Administrador extends Usuario {

	public Administrador(String username, String password) {
		super(username, password, "Administrador");
	}

	@Override
	public void mostrarMenu() {
		MenuAdmin menu = new MenuAdmin(this);
		menu.mostrarOpciones();
		
	}
	
	public void agregarProyecto(Proyecto proyecto) {
		Sistema.getInstancia().agregarProyecto(proyecto);
	}
	
	public void eliminarProyecto(String proyectoID) {
		Sistema.getInstancia().eliminarProyecto(proyectoID);
	}
	
	public void agregarTarea(Tarea tarea) {
		Sistema.getInstancia().agregarTarea(tarea);
	}
	
	public void eliminarTarea(String tareaID) {
		Sistema.getInstancia().eliminarTarea(tareaID);
	}
	
	public void asignarPrioridad(Proyecto proyecto, PrioridadStrategy strategy) {
	    proyecto.ordenarTareas(strategy);
	}

	
	public void generarReporte() {
		for (Proyecto p : Sistema.getInstancia().getProyectos()) {
			System.out.println(p);
			for (Tarea t: p.getTareas()) {
				System.out.println("- " +t.getDescripcion());
			}
		}
	}

}
