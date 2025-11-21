package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import taller.Tarea;
import taller.Bug;
import taller.Feature;
import taller.Documentacion;

/**
 * Maneja la lectura y escritura del archivo tareas.txt.
 * Permite cargar todas las tareas guardadas y escribir los cambios realizados
 * durante la ejecución del sistema.
 *
 * Cada línea del archivo tiene el formato:
 * ProyectoID|TareaID|Tipo|Descripcion|Estado|Responsable|Complejidad|Fecha
 *
 * Dependiendo del tipo de tarea (Bug, Feature o Documentacion), se crea
 * la instancia correspondiente utilizando sus constructores.
 *
 * Este archivo es utilizado por la clase Sistema para asegurar la persistencia
 * de todas las tareas.
 *
 * @author Ramiro Alvarado - Patricio Alvarado
 */
public class ArchivoTareas {

    private String ruta = "tareas.txt";

    public ArrayList<Tarea> leer() {

    	/**
         * Lee el archivo tareas.txt y devuelve todas las tareas encontradas.
         *
         * @return lista de tareas cargadas desde el archivo
         */
        ArrayList<Tarea> lista = new ArrayList<>();

        try {
            File file = new File(ruta);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split("\\|");

                String proyectoID = datos[0];
                String tareaID = datos[1];
                String tipo = datos[2];
                String descripcion = datos[3];
                String estado = datos[4];
                String responsable = datos[5];
                String complejidad = datos[6];
                String fecha = datos[7];


                if (tipo.equalsIgnoreCase("Bug")) {
                    lista.add(new Bug(proyectoID, tareaID, descripcion, estado, responsable, complejidad, fecha));
                } 
                else if (tipo.equalsIgnoreCase("Feature")) {
                    lista.add(new Feature(proyectoID, tareaID, descripcion, estado, responsable, complejidad, fecha));
                } 
                else if (tipo.equalsIgnoreCase("Documentacion")) {
                    lista.add(new Documentacion(proyectoID, tareaID, descripcion, estado, responsable, complejidad, fecha));
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error leyendo tareas: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Escribe la lista de tareas en el archivo tareas.txt, sobrescribiendo su contenido.
     *
     * @param lista lista de tareas a escribir
     */
    public void escribir(ArrayList<Tarea> lista) {

        try {
            FileWriter fw = new FileWriter(ruta);

            for (Tarea t : lista) {
                fw.write(
                    t.getProyectoID() + "|" +
                    t.getTareaID() + "|" +
                    t.getClass().getSimpleName() + "|" + 
                    t.getDescripcion() + "|" +
                    t.getEstado() + "|" +
                    t.getResponsable() + "|" +
                    t.getComplejidad() + "|" +
                    t.getFecha() + "\n"
                );
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Error escribiendo tareas: " + e.getMessage());
        }
    }
}
