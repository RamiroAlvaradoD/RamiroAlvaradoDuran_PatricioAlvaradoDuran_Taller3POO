package visitor;
import taller.Bug;
import taller.Documentacion;
import taller.Feature;

/**
 * Interfaz del patrón Visitor aplicada a las tareas del sistema.
 * 
 * Define los métodos que permiten realizar acciones específicas según
 * el tipo concreto de tarea. Cada implementación del visitor deberá
 * decidir qué hacer cuando recibe un Bug, una Feature o una Documentacion.
 * 
 * Este patrón permite agregar nuevas operaciones sobre tareas sin
 * modificar las clases concretas que las representan.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public interface TareaVisitor {
	
    /**
     * Acción asociada a una tarea de tipo Bug.
     *
     * @param b instancia de Bug a visitar
     */
	public void visitar(Bug b);
	
	/**
     * Acción asociada a una tarea de tipo Feature.
     *
     * @param f instancia de Feature a visitar
     */
	public void visitar(Feature f);
	
	/**
     * Acción asociada a una tarea de tipo Documentacion.
     *
     * @param d instancia de Documentacion a visitar
     */
	public void visitar(Documentacion d);

}
