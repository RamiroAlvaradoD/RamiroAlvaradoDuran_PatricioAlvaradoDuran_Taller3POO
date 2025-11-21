package sistema;
//Ramiro Alvarado Durán - RUT 19.428.146-3 - ITI - GitHub: RamiroAlvaradoD
//Patricio Alvarado Durán - RUT 20.955.249-3 - ITI - GitHub: Garaxlight
//Taller N°3 - Programación Orientada a Objetos

/**
 * Clase principal de la aplicación.
 * 
 * Inicia el sistema creando una instancia de MenuPrincipal e invocando
 * el flujo inicial del programa mediante el método iniciar().
 * 
 * Esta es la clase que debe ejecutarse para usar el sistema completo.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class App {
	

	
	/**
     * Método principal de la aplicación.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */

	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		menu.iniciar();

	}

}
