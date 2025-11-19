package taller;
import sistema.MenuAdmin;
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
	
	public void agregarProyecto() {
		
	}
	
	public void eliminarProyecto() {
		
	}
	
	public void agregarTarea() {
		
	}
	
	public void eliminarTarea() {
		
	}
	
	public void asignarPrioridad(Proyecto proyecto, PrioridadStrategy strategy) {
	    proyecto.ordenarTareas(strategy);
	}

	
	public void generarReporte() {
		
	}

}
