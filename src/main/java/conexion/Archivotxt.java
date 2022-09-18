package conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
public class Archivotxt {

    private String nombre;

    public Archivotxt(String nombre) {
        this.nombre = nombre;
    }

    // Mete las líneas del archivo en una lista
    public LinkedList<String> ObtenerTextodeArchivo() {
        LinkedList<String> lineasDeTexto = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(nombre))) {
            
            // .exists() es un método de la clase file que nos permite comprobar la
            // existencia de un objeto
                lineasDeTexto = new LinkedList<String>();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    // System.out.println(linea); 
                    lineasDeTexto.add(linea);
                }
                reader.close();
            } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
        return lineasDeTexto;
    }

    public static void limpiar(File ArchivoOriginal) {

        File ArchivoTemporal = new File("tempFile.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(ArchivoOriginal));
                PrintWriter writer = new PrintWriter(new FileWriter(ArchivoTemporal))) {
            String lineOfText = reader.readLine();

            while (lineOfText != null) {
                if (!lineOfText.isEmpty()) {
                    writer.println(lineOfText);
                }
                lineOfText = reader.readLine();
            }
            writer.close();
            reader.close();
            ArchivoOriginal.delete();
            ArchivoTemporal.renameTo(ArchivoOriginal);
        } catch (Exception e) {
            e.printStackTrace();
            // JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
    }

}
