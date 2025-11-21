package sistema;

import java.util.ArrayList;

import archivos.ArchivoProyectos;
import archivos.ArchivoTareas;
import archivos.ArchivoUsuarios;
import taller.Usuario;
import taller.Proyecto;
import taller.Tarea;

/**
* Sistema central de la aplicación.
* 
* Implementa el patrón Singleton, asegurando que solo exista una única instancia
* global encargada de gestionar:
* 
* Usuarios
* Proyectos
* Tareas
* 
* Además coordina la carga y guardado de datos mediante las clases de
* persistencia, así como la búsqueda y manipulación de entidades.
* 
*
* @author Ramiro Alvarado - Patricio Alvarado
*/
public class Sistema {   
	
	/** Instancia única del sistema (Singleton). */
	private static Sistema instancia;
	
	/** Lista de usuarios cargados desde archivo. */
	private ArrayList<Usuario> usuarios;
	
	/** Lista de proyectos administrados por el sistema. */
	private ArrayList<Proyecto> proyectos;
	
	/** Lista general de tareas. */
	private ArrayList<Tarea> tareas;
	
	/**
	* Constructor privado para el patrón Singleton.
	* Inicializa las listas de usuarios, proyectos y tareas.
	*/
	private Sistema() {
		usuarios = new ArrayList<>();
		proyectos = new ArrayList<>();
		tareas = new ArrayList<>();
	}
	
	/**
	* Devuelve la única instancia del sistema.
	* Si no existe, la crea.
	*
	* @return instancia única del sistema
	*/
	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}
	
	/**
	* Carga usuarios, proyectos y tareas desde archivos.
	* Luego asocia cada tarea con su proyecto correspondiente.
	*/
	public void cargarDatos() {

	    ArchivoUsuarios au = new ArchivoUsuarios();
	    ArchivoProyectos ap = new ArchivoProyectos();
	    ArchivoTareas at = new ArchivoTareas();

	  
	    this.usuarios = au.leer();

	    this.proyectos = ap.leer();

	    this.tareas = at.leer();

	    for (Proyecto p : proyectos) {
	        for (Tarea t : tareas) {
	            if (t.getProyectoID().equals(p.getProyectoID())) {
	                p.addTarea(t); 
	            }
	        }
	    }

	    System.out.println("Datos cargados correctamente.");
	}

	
	/**
	* Guarda usuarios, proyectos y tareas en sus respectivos archivos.
	*/
	public void guardarDatos() {

	    ArchivoUsuarios au = new ArchivoUsuarios();
	    ArchivoProyectos ap = new ArchivoProyectos();
	    ArchivoTareas at = new ArchivoTareas();

	    au.escribir(usuarios);
	    ap.escribir(proyectos);
	    at.escribir(tareas);

	    System.out.println("Datos guardados correctamente.");
	}

	/**
	* Intenta autenticar un usuario según su username y contraseña.
	*
	* @param username nombre de usuario ingresado
	* @param password contraseña ingresada
	* @return el usuario autenticado o null si las credenciales no coinciden
	*/
	public Usuario login(String username, String password) {
		for (Usuario u: usuarios) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	/**
	* @return la lista de proyectos del sistema
	*/
	public ArrayList<Proyecto> getProyectos(){
		return proyectos;
	}
	
	
	/**
	* @return la lista de todas las tareas del sistema
	*/
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	
	/**
	* Agrega un nuevo proyecto a la lista.
	*
	* @param p proyecto a agregar
	*/
	public void agregarProyecto(Proyecto p) {
		proyectos.add(p);
	}
	
	/**
	* Elimina un proyecto según su ID.
	*
	* @param proyectoID ID del proyecto a eliminar
	*/
	public void eliminarProyecto(String proyectoID) {
		proyectos.removeIf(p -> p.getProyectoID().equals(proyectoID));
		
	}
	
	/**
	* Busca un proyecto por su ID.
	*
	* @param proyectoID ID del proyecto a buscar
	* @return el proyecto encontrado o null si no existe
	*/
	public Proyecto buscarProyecto(String proyectoID) {
		for (Proyecto p: proyectos) {
			if (p.getProyectoID().equals(proyectoID)) {
				return p;
			}
		}
		return null;
	}
	
	/**
	* Agrega una nueva tarea al sistema.
	*
	* @param t tarea a agregar
	*/
	public void agregarTarea(Tarea t) {
		tareas.add(t);
	}
	
	/**
	* Elimina una tarea según su ID.
	*
	* @param tareaID ID de la tarea a eliminar
	*/
	public void eliminarTarea(String TareaID) {
		tareas.removeIf(t -> t.getTareaID().equals(TareaID));
	}
	
	/**
	* Busca una tarea por su ID.
	*
	* @param tareaID ID de la tarea buscada
	* @return tarea encontrada o null si no existe
	*/
	public Tarea buscarTarea(String tareaID) {
		for (Tarea t: tareas) {
			if (t.getTareaID().equals(tareaID)) {
				return t;
			}
		}
		return null;
	}
	
	/**
	* Devuelve todas las tareas asociadas a un proyecto.
	*
	* @param proyectoID ID del proyecto
	* @return lista de tareas del proyecto
	*/
	public ArrayList<Tarea> getTareasPorProyecto(String proyectoID) {
		ArrayList<Tarea> lista = new ArrayList<>();
		for (Tarea t: tareas) {
			if (t.getProyectoID().equals(proyectoID)) {
				lista.add(t);
			}
		}
		return lista;
	}
	
	
	


}
