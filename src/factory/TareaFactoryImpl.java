package factory;

import taller.Tarea;
import taller.Bug;
import taller.Feature;
import taller.Documentacion;


/**
* Implementación de la interfaz TareaFactory.
* Se encarga de crear instancias de tareas según el tipo especificado
* en el parámetro "tipo".
*
* Utiliza un switch para determinar si debe crear un Bug, Feature
* o Documentacion. Si el tipo no coincide con ninguno de los válidos,
* lanza una excepción.
*
* Esta clase permite centralizar la lógica de creación de tareas y
* evita repetición de código en otras partes del sistema.
*
* @author Ramiro Alvarado - Patricio Alvarado
*/
public class TareaFactoryImpl implements TareaFactory {
	
	
	/**
	* Crea una nueva tarea según el tipo proporcionado.
	*
	* @param tipo tipo de tarea a crear
	* @param proyectoID ID del proyecto al que pertenece
	* @param tareaID ID único de la tarea
	* @param descripcion descripción de la tarea
	* @param estado estado inicial de la tarea
	* @param responsable usuario responsable
	* @param complejidad nivel de complejidad
	* @param fecha fecha de creación
	* @return una instancia de la tarea correspondiente
	* @throws IllegalArgumentException si el tipo no es válido
	*/
	public Tarea crearTarea(String tipo, String proyectoID, String tareaID, String descripcion,
			String estado, String responsable, String complejidad, String fecha) {
		switch (tipo.toLowerCase()) {
		case "bug": return new Bug(proyectoID, tareaID, descripcion, estado, responsable, complejidad, fecha);
		
		case "feature": return new Feature(proyectoID, tareaID, descripcion, estado, responsable, complejidad, fecha);
		
		case "documentacion": return new Documentacion(proyectoID, tareaID, descripcion, estado,
				responsable, complejidad, fecha);
		default: throw new IllegalArgumentException("Tipo de tarea Invalido");
		}
		
	}
}
