package factory;

import taller.Tarea;

/**
* Interfaz que define el contrato para la creación de tareas.
* Las implementaciones de esta interfaz deben encargarse de instanciar
* el tipo correcto de Tarea (Bug, Feature o Documentacion) según el
* valor entregado en el parámetro "tipo".
*
* Este patrón corresponde a Factory, permitiendo centralizar la lógica
* de creación de objetos y evitar el uso de múltiples condiciones en el resto del sistema.
*
* @author Ramiro Alvarado - Patricio Alvarado
*/
public interface TareaFactory {
	
	/**
	* Crea una tarea según el tipo especificado.
	*
	* @param tipo tipo de tarea (Bug, Feature, Documentacion)
	* @param proyectoID ID del proyecto al que pertenece
	* @param tareaID ID único de la tarea
	* @param descripcion texto descriptivo de la tarea
	* @param estado estado inicial de la tarea
	* @param responsable usuario responsable de la tarea
	* @param complejidad nivel de complejidad
	* @param fecha fecha de creación en formato YYYY/MM/DD
	* @return la tarea creada
	*/
    Tarea crearTarea(String tipo, String proyectoID, String tareaID, String descripcion,
                     String estado, String responsable, String complejidad, String fecha);
}
