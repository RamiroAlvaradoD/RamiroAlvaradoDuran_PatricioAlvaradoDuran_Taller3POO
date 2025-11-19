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
	
	public void guardarDatos() {
		
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
	
	public void agregarProyecto(Proyecto p) {
		proyectos.add(p);
	}
	
	public void eliminarProyecto(String proyectoID) {
		proyectos.removeIf(p -> p.getProyectoID().equals(proyectoID));
		
	}
	
	public Proyecto buscarProyecto(String proyectoID) {
		for (Proyecto p: proyectos) {
			if (p.getProyectoID().equals(proyectoID)) {
				return p;
			}
		}
		return null;
	}
	
	public void agregarTarea(Tarea t) {
		tareas.add(t);
	}
	
	public void eliminarTarea(String TareaID) {
		tareas.removeIf(t -> t.getTareaId().equals(TareaID));
	}
	
	public Tarea buscarTarea(String tareaID) {
		for (Tarea t: tareas) {
			if (t.getTareaId().equals(tareaID)) {
				return t;
			}
		}
		return null;
	}
	
	public ArrayList<Tarea> getTareasPorProyecto(String proyectoID) {
		ArrayList<Tarea> lista = new ArrayList<>();
		for (Tarea t: tareas) {
			if (t.getProyectoId().equals(proyectoID)) {
				lista.add(t);
			}
		}
		return lista;
	}
	
	
	


}
