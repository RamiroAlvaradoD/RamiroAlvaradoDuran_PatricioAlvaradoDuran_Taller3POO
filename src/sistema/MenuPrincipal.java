package sistema;

import java.util.Scanner;

import taller.Usuario;
import taller.Administrador;
import taller.Colaborador;

public class MenuPrincipal {

    private Scanner sc;
    private Sistema sistema;

    public MenuPrincipal() {
        sc = new Scanner(System.in);
        sistema = Sistema.getInstancia();
    }

    public void iniciar() {

        System.out.println("=== SISTEMA DE GESTIÓN DE PROYECTOS ===");
        System.out.println("Cargando datos.");

        sistema.cargarDatos();

        while (true) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Usuario: ");
            String username = sc.nextLine();

            System.out.print("Contraseña: ");
            String password = sc.nextLine();

            Usuario u = sistema.login(username, password);

            if (u == null) {
                System.out.println("Usuario o contraseña incorrectos.");
            } else {
                System.out.println("Bienvenido, " + u.getUsername());
                u.mostrarMenu();  
                break;           
            }
        }

        System.out.println("\nSaliendo del sistema...");
        sistema.guardarDatos();
    }
}