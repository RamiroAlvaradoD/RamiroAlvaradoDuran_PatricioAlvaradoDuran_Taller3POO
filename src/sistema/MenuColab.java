package sistema;

import java.util.Scanner;

import taller.Colaborador;
import visitor.VisitorAccionesTareas;
import visitor.TareaVisitor;

public class MenuColab {
	private Colaborador colab;

	public MenuColab(Colaborador colab) {
		this.colab = colab;
	}

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
