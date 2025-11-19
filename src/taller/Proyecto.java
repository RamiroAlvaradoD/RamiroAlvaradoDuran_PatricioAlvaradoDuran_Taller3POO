package taller;
import java.util.ArrayList;

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

}
