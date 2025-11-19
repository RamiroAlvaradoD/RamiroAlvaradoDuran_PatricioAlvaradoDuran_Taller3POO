package taller;
import java.util.ArrayList;

import strategy.PrioridadStrategy;

public class Proyecto {
	private String proyectoID;
	private String nombre;
	private String responsable;
	private ArrayList<Tarea> tareas;
	
	public Proyecto(String proyectoID, String nombre, String responsable) {
		this.proyectoID = proyectoID;
		this.nombre = nombre;
		this.responsable = responsable;
		this.tareas = new ArrayList<>();
	}

	public String getProyectoID() {
		return proyectoID;
	}

	public String getNombre() {
		return nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	
	public void addTarea(Tarea t) {
		tareas.add(t);
	}
	
	public void removeTarea(String tareaId) {
		tareas.removeIf(t -> t.getTareaId().equals(tareaId));
	}
	
	//Strategy
	public void ordenarTareas(PrioridadStrategy strategy) {
		strategy.ordenar(tareas);
		
	}

	@Override
	public String toString() {
		return "Proyecto [proyectoID=" + proyectoID + ", nombre=" + nombre + ", responsable=" + responsable + "]";
	}

}
