package taller;
import sistema.MenuColab;
import sistema.Sistema;
import visitor.TareaVisitor;

public class Colaborador extends Usuario {

	public Colaborador(String username, String password) {
		super(username, password, "Colaborador");
	}

	@Override
	public void mostrarMenu() {
		MenuColab menu = new MenuColab(this);
		menu.mostrarOpciones();
		
	}
	
	public void verProyectos() {
		for (Proyecto p : Sistema.getInstancia().getProyectos()) {
			System.out.println(p);
		}
	}
	
	public void verTareasAsignadas() {
		String usuario = getUsername();
		for (Tarea t : Sistema.getInstancia().getTareas()) {
			if (t.getResponsable().equals(usuario));
			System.out.println(t);
		}
	}
	
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
	
	public void ejecutarVisitor(TareaVisitor visitor ) {
		for (Tarea t :Sistema.getInstancia().getTareas()) {
			if (t.getResponsable().equals(getUsername())) {
				t.aceptar(visitor);
			}
		}
	}

}
