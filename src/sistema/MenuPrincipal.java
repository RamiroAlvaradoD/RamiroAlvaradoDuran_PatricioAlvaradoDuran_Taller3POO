package sistema;

import java.util.Scanner;

import taller.Usuario;
import taller.Administrador;
import taller.Colaborador;


/**
* Menú principal del sistema.
*
* Esta clase gestiona:
* 
* El proceso de login de usuarios
* La carga inicial de datos
* La invocación del menú correspondiente a cada rol
* El guardado de datos al finalizar
* 
*
* El menú principal es la primera interfaz visible para el usuario.
* Se apoya en el Singleton para obtener la información
* centralizada del programa.
*
* @author Ramiro Alvarado - Patricio Alvarado
*/
public class MenuPrincipal {

    private Scanner sc;
    private Sistema sistema;

    public MenuPrincipal() {
        sc = new Scanner(System.in);
        sistema = Sistema.getInstancia();
    }

    /**
    * Inicia el flujo principal del sistema:
    * 
    * Muestra mensaje inicial
    * Carga datos desde archivos mediante el Sistema
    * Solicita credenciales al usuario
    * Valida el login
    * Invoca el menú correspondiente al rol (Admin/Colab)
    * Guarda los datos al salir
    * 
    */
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