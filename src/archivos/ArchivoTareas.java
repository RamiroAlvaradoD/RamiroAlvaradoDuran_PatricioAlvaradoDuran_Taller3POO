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

public class ArchivoTareas {

    private String ruta = "tareas.txt";

    public ArrayList<Tarea> leer() {

        ArrayList<Tarea> lista = new ArrayList<>();

        try {
            File file = new File(ruta);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(";");

                String proyectoID = datos[0];
                String tareaID = datos[1];
                String tipo = datos[2];
                String descripcion = datos[3];
                String estado = datos[4];
                String responsable = datos[5];
                String complejidad = datos[6];
                String fecha = datos[7];


                if (tipo.equalsIgnoreCase("Bug")) {
                    lista.add(new Bug(tareaID, proyectoID, descripcion, estado, responsable, complejidad, fecha));
                } 
                else if (tipo.equalsIgnoreCase("Feature")) {
                    lista.add(new Feature(tareaID, proyectoID, descripcion, estado, responsable, complejidad, fecha));
                } 
                else if (tipo.equalsIgnoreCase("Documentacion")) {
                    lista.add(new Documentacion(tareaID, proyectoID, descripcion, estado, responsable, complejidad, fecha));
                }
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error leyendo tareas: " + e.getMessage());
        }

        return lista;
    }

    public void escribir(ArrayList<Tarea> lista) {

        try {
            FileWriter fw = new FileWriter(ruta);

            for (Tarea t : lista) {
                fw.write(
                    t.getProyectoID() + ";" +
                    t.getTareaID() + ";" +
                    t.getClass().getSimpleName() + ";" +  // Tipo a partir de la clase
                    t.getDescripcion() + ";" +
                    t.getEstado() + ";" +
                    t.getResponsable() + ";" +
                    t.getComplejidad() + ";" +
                    t.getFecha() + "\n"
                );
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Error escribiendo tareas: " + e.getMessage());
        }
    }
}
