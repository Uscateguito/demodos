package conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
public class Archivotxt {

    private String nombre;

    /**
     * Constructor de la clase archivo
     * @param nombre Este parametro indica el nombre del Archivo.txt 
    */
    public Archivotxt(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Organiza un archivo de texto dentro de la memoria
     * @return retorna una lista de lineas de texto del Archivo
     */
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

    /**
     * Quita todas las líneas que quedan en blanco de un documento txt al hacerle alguna eliminación
     * @param ArchivoOriginal El Archivo original a ser limpiado 
     */
    public static void limpiar(File ArchivoOriginal) {

        File ArchivoTemporal = new File("tempFile.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(ArchivoOriginal));
                PrintWriter writer = new PrintWriter(new FileWriter(ArchivoTemporal))) {
            String lineOfText = reader.readLine();

            boolean salto_inciial = false;
            while (lineOfText != null) {
                if (!lineOfText.isEmpty()) {
                    if (salto_inciial) 
                        writer.write(System.getProperty("line.separator"));
                    else salto_inciial = true;
                    writer.write(lineOfText);
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