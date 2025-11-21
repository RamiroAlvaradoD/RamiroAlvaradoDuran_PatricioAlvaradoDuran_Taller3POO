package sistema;

import java.util.Scanner;

import javax.swing.RepaintManager;

import factory.TareaFactory;
import factory.TareaFactoryImpl;
import strategy.PrioridadComplejidad;
import strategy.PrioridadFecha;
import strategy.PrioridadStrategy;
import strategy.PrioridadTipo;
import taller.Administrador;
import taller.Proyecto;
import taller.Tarea;

/**
 * Menú exclusivo para usuarios con rol Administrador.
 * 
 * Permite realizar todas las operaciones administrativas del sistema:
 * 
 *   Ver proyectos
 *   Agregar y eliminar proyectos
 *   Ver tareas asociadas a un proyecto
 *   Agregar y eliminar tareas
 *   Ordenar tareas mediante estrategia Strategy
 *   Generar reporte del sistema
 * 
 * 
 * Este menú utiliza la instancia única (Singleton) del sistema para
 * realizar las operaciones centrales.
 * 
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class MenuAdmin {

	/** Referencia al administrador autenticado */
	private Administrador admin;

	/**
     * Constructor que recibe al administrador que utilizará el menú.
     *
     * @param admin administrador autenticado
     */
	public MenuAdmin(Administrador admin) {
		this.admin = admin;
	}

	
	 /**
     * Muestra el menú de opciones para el administrador y gestiona
     * las operaciones correspondientes según la opción ingresada.
     * 
     * Las operaciones incluyen: gestión de proyectos, gestión de tareas,
     * aplicación del patrón Strategy para ordenar tareas y generación 
     * de reportes.
     */
	public void mostrarOpciones() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("\n--- MENÚ ADMINISTRADOR ---");
			System.out.println("1. Ver Proyectos");
			System.out.println("2. Agregar proyecto");
			System.out.println("3. Eliminar proyecto");
			System.out.println("4. Ver tareas de un proyecto");
			System.out.println("5. Agregar tarea");
			System.out.println("6. Eliminar tarea");
			System.out.println("7. Ordenar tareas de un proyecto");
			System.out.println("8. Generar reporte");
			System.out.println("0. Salir");
			System.out.print("Ingrese opcion: ");
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1:
				for (Proyecto p : Sistema.getInstancia().getProyectos()) {
					System.out.println(p);
				}
				break;
			case 2:
				System.out.print("ID proyecto: ");
				String idP = sc.nextLine();
				System.out.print("Nombre: ");
				String nombreP = sc.nextLine();
				System.out.print("Responsable: ");
				String respP = sc.nextLine();
				Proyecto nuevoP = new Proyecto(idP, nombreP, respP);
				admin.agregarProyecto(nuevoP);
				break;
			case 3:
				System.out.print("ID del proyecto a eliminar: ");
				String idEliminar = sc.nextLine();
				admin.eliminarProyecto(idEliminar);
				break;
			case 4:
				System.out.print("ID proyecto: ");
				String idVer= sc.nextLine();
				Proyecto proy = Sistema.getInstancia().buscarProyecto(idVer);
				if (proy !=null) {
					for (Tarea t: proy.getTareas()) {
						System.out.println(t.getDescripcion());
					}
				}
				break;
			case 5:
				System.out.print("ID del proyecto al que pertenece la tarea: ");
				String proyectoID = sc.nextLine();
				
				Proyecto proyecto =Sistema.getInstancia().buscarProyecto(proyectoID);
				if (proyecto == null) {
					System.out.println("Error: El proyecto no existe.");
					break;
				}
				System.out.print("ID de la tarea: ");
				String tareaID = sc.nextLine();
				
				System.out.print("Tipo de tarea (Bug/Feature/Documentacion): ");
				String tipo = sc.nextLine();
				
				System.out.print("Descripcion: ");
				String descripcion = sc.nextLine();
				
				System.out.print("Estado inicial (Pendiente/En Proceso/Terminado): ");
				String estado = sc.nextLine();
				
				System.out.print("Responsable: ");
				String responsable= sc.nextLine();
				
				System.out.print("Complejidad (Alta/Media/Baja): ");
				String complejidad = sc.nextLine();
				
				System.out.print("Fecha (YYYY/MM/DD): ");
				String fecha = sc.nextLine();
				
				TareaFactory factory = new TareaFactoryImpl();
				
				try {
					Tarea nuevaTarea = factory.crearTarea(tipo, proyectoID, tareaID, descripcion,
							estado, responsable, complejidad, fecha);
					admin.agregarTarea(nuevaTarea);
					proyecto.addTarea(nuevaTarea);
					
					System.out.println("Tarea agregada exitosamente!");
					
				} catch (IllegalArgumentException e) {
					System.out.println("Error: "+e.getMessage());
				}
				break;
			case 6:
				System.out.print("ID tarea a eliminar: ");
				String tID = sc.nextLine();
				admin.eliminarTarea(tID);
				break;
			case 7:
				System.out.print("ID proyecto: ");
				String pID = sc.nextLine();
				Proyecto pr = Sistema.getInstancia().buscarProyecto(pID);
				if (pr != null) {
					System.out.println("Ordenar por: 1. Fecha 2. Complejidad 3. Tipo");
					int tipoOrden = sc.nextInt();
					sc.nextLine();
					PrioridadStrategy est = null;
					if (tipoOrden == 1) est = new PrioridadFecha();
					else if (tipoOrden == 2) est = new PrioridadComplejidad();
					else est = new PrioridadTipo();
					admin.asignarPrioridad(pr, est);
				}
				break;
			case 8:
				admin.generarReporte();
				break;
			}
		} while (opcion != 0);

	}
}
