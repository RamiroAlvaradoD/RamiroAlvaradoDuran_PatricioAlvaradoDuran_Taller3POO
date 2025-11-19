package taller;
import sistema.MenuColab;
import visitor.TareaVisitor;

public class Colaborador extends Usuario {

	public Colaborador(String username, String password, String rol) {
		super(username, password, "Colaborador");
	}

	@Override
	public void mostrarMenu() {
		MenuColab menu = new MenuColab(this);
		menu.mostrarOpciones();
		
	}
	
	public void verProyectos() {
		
	}
	
	public void verTareasAsignadas() {
		
	}
	
	public void actualizarEstadoTarea() {
		
	}
	
	public void ejecutarVisitor(TareaVisitor visitor ) {
		
	}

}
