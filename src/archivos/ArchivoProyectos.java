package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import taller.Proyecto;

public class ArchivoProyectos {

    private String ruta = "proyectos.txt";

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