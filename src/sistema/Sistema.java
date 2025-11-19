package sistema;
import java.util.ArrayList;
import taller.Usuario;
import taller.Proyecto;
import taller.Tarea;

public class Sistema {   
	private static Sistema instancia;
	
	private ArrayList<Usuario> usuarios;
	private ArrayList<Proyecto> proyectos;
	private ArrayList<Tarea> tareas;
	
	private Sistema() {
		usuarios = new ArrayList<>();
		proyectos = new ArrayList<>();
		tareas = new ArrayList<>();
	}
	
	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}
	
	public void cargarDatos() {
		//Pendiente implementacion

	}
	
	public Usuario login(String username, String password) {
		//Pendiente implementacion
		return null;
	}
	
	public ArrayList<Proyecto> getProyectos(){
		return proyectos;
	}
	
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}


}
