package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import taller.Proyecto;

/**
 * Clase encargada de manejar la lectura y escritura del archivo proyectos.txt.
 * Permite cargar proyectos desde el archivo y guardar los cambios realizados
 * durante la ejecución del sistema.
 *
 * Cada línea del archivo tiene el formato:
 * ID|Nombre|Responsable
 *
 * Esta clase es utilizada por Sistema para mantener la persistencia de proyectos.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class ArchivoProyectos {

    private String ruta = "proyectos.txt";

    
    /**
     * Lee el archivo de proyectos y devuelve una lista con los objetos cargados.
     *
     * @return lista de proyectos leídos desde proyectos.txt
     */
    public ArrayList<Proyecto> leer() {

        ArrayList<Proyecto> lista = new ArrayList<>();

        try {
            File file = new File(ruta);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split("\\|");

                String proyectoID = datos[0];
                String nombre = datos[1];
                String responsable = datos[2];

                lista.add(new Proyecto(proyectoID, nombre, responsable));
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error leyendo proyectos: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Escribe la lista de proyectos en el archivo proyectos.txt,
     * sobrescribiendo todo el contenido anterior.
     *
     * @param lista lista de proyectos a escribir
     */
    public void escribir(ArrayList<Proyecto> lista) {
        try {
            FileWriter fw = new FileWriter(ruta);

            for (Proyecto p : lista) {
                fw.write(
                    p.getProyectoID() + "|" +
                    p.getNombre() + "|" +
                    p.getResponsable() + "\n"
                );
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Error escribiendo proyectos: " + e.getMessage());
        }
    }
}