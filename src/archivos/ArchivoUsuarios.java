package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import taller.Usuario;
import taller.Administrador;
import taller.Colaborador;

/**
* Maneja la lectura y escritura del archivo usuarios.txt.
* Permite cargar la lista de usuarios del sistema y guardar los cambios
* realizados durante la ejecución.
*
* Cada línea del archivo tiene el formato:
* username|password|rol
*
* Según el rol detectado, se instancia un Administrador o un Colaborador.
* Esta clase es usada por Sistema para asegurar la persistencia de usuarios.
*
* @author Ramiro Alvarado - Patricio Alvarado
*/
public class ArchivoUsuarios {
	
	private String ruta = "usuarios.txt";
	
	/**
	* Lee el archivo usuarios.txt y devuelve una lista con los usuarios
	* instanciados según su rol.
	*
	* @return lista de usuarios cargados
	*/
	public ArrayList<Usuario> leer(){
		
		ArrayList<Usuario> lista = new ArrayList<>();
		
		try {
			File file = new File(ruta);
			Scanner sc = new Scanner(file);
		
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[]datos = linea.split("\\|");
				
				String username = datos[0];
				String password = datos[1];
				String rol = datos[2];
				
				if (rol.equalsIgnoreCase("Administrador")) {
					lista.add(new Administrador(username, password));
				}	else {
					lista.add(new Colaborador(username, password));
				}
					
			}
			
			sc.close();
		
		} catch (Exception e) {
			System.out.println("Error leyendo usuarios:" + e.getMessage());
		}
		
		return lista;
		
		
	}
	
	/**
	* Escribe la lista de usuarios en usuarios.txt, sobrescribiendo todo
	* el contenido previo.
	*
	* @param lista lista de usuarios a escribir
	*/
	public void escribir(ArrayList<Usuario>lista) {
		try {
			FileWriter fw = new FileWriter(ruta);
			
			for(Usuario u: lista) {
			fw.write(u.getUsername() + "|" + u.getPassword() + "|" + u.getRol() + "\n");
			}
			
			fw.close();
		} catch (IOException e) {
			System.out.println("Error escribiendo usuarios: " + e.getMessage());
		}
	}

}
