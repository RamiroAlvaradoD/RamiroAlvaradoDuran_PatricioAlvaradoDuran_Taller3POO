package sistema;

import java.util.Scanner;

import taller.Colaborador;
import visitor.VisitorAccionesTareas;
import visitor.TareaVisitor;
/**
 * Menú interactivo para usuarios con rol de Colaborador.
 * 
 * Permite realizar las operaciones autorizadas para un colaborador dentro
 * del sistema TaskForge, incluyendo:
 * 
 *   Visualizar proyectos disponibles
 *   Listar tareas asignadas al colaborador
 *   Actualizar el estado de una tarea asignada
 *   Aplicar el patrón Visitor sobre una tarea
 * 
 * 
 * Este menú hace uso del Singleton Sistema para obtener y modificar la
 * información almacenada.
 * 
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class MenuColab {
	
	/** Colaborador que utiliza el menú */
	private Colaborador colab;

	/**
     * Constructor del menú del colaborador.
     * 
     * @param colab colaborador autenticado
     */
	public MenuColab(Colaborador colab) {
		this.colab = colab;
	}

	/**
     * Muestra el menú y permite al colaborador realizar acciones tales como:
     * 
     *   Ver proyectos
     *  Ver tareas asignadas
     *   Actualizar el estado de una tarea
     *   Aplicar el patrón Visitor a una tarea
     * 
     * 
     * El ciclo continúa hasta que se seleccione la opción 0.
     */
	public void mostrarOpciones() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("\n--- MENÚ ADMINISTRADOR ---");
			System.out.println("1. Ver Proyectos");
			System.out.println("2. Ver tareas asignadas");
			System.out.println("3. Actualizar estado de tarea");
			System.out.println("4. Ejecutar visitor");
			System.out.println("0. Salir");
			System.out.print("Ingrese opcion: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				colab.verProyectos();
				break;
			case 2:
				colab.verTareasAsignadas();
				break;
			case 3:
				System.out.print("ID de la tarea: ");
				String tareaID = sc.nextLine();
				System.out.print("Nuevo estado: ");
				String estado = sc.nextLine();
				colab.actualizarEstadoTarea(tareaID, estado);
				break;
			case 4:
				TareaVisitor visitor = new VisitorAccionesTareas();
				colab.ejecutarVisitor(visitor);
				break;

			}
		} while (opcion != 0);

	}
}
