// Patron repositorios

package conexion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

import modelo.Usuarios;

public class CrudUsuarios extends CRUDtxt<Usuarios> {

    // Singleton
    
    private static CrudUsuarios instance;

    public static CrudUsuarios getInstance() {
        if(instance == null) {
            instance=new CrudUsuarios();
        }
        return instance;
    }        

    // CRUD ------------------------------

    /**
     * CREATE
     * Crear un usuario
     * @param usuarioNuevo Este parametro es el nuevo usuario que se va a escribir en el archivo de texto
     */
    public void Escribir(Usuarios usuarioNuevo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("parchaditos.txt", true))) {
            // .exists() es un método de la clase file que nos permite comprobar la
            // existencia de un objeto
            writer.write("\n" + usuarioNuevo.getNombre() + ";" + usuarioNuevo.getCedula() + ";"
                    + usuarioNuevo.getCorreoElectronico()
                    + ";" + usuarioNuevo.getContrasenia());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            // JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
    }

    /**
     * READ
     * Leer los usuarios
     * @return Este parametro retorna una lista de usuarios nuevos 
     */
    public LinkedList<Usuarios> obtener() {
        // Se incerta el nombre del archivo que se requiere conectar
        LinkedList<Usuarios> UsuarioNuevo = null;
        Archivotxt archivo = new Archivotxt("parchaditos.txt");
        LinkedList<String> Lineas = archivo.ObtenerTextodeArchivo();
        if (Lineas != null) {
            UsuarioNuevo = new LinkedList<>();
            for (int i = 0; i < Lineas.size(); i++) {
                String linea = Lineas.get(i);
                // El tokenizer me crea una pequeña lista de los elementos que componen la
                // línea, pero separados
                StringTokenizer tokens = new StringTokenizer(linea, ";");
                String nombre = tokens.nextToken();
                String cedula = tokens.nextToken();
                String CorreoElectronico = tokens.nextToken();
                String contrasenia = tokens.nextToken();
                UsuarioNuevo.add(new Usuarios(nombre, cedula, CorreoElectronico, contrasenia));
            }
        }
        return UsuarioNuevo;
    }

    /**
     * UPDATE
     * Actualizar un usuario
     * @param UsuarioxActualizar Este parametro se usa para pasarle al metodo los datos actualizados 
     */
    public void Update(Usuarios UsuarioxActualizar) {

        // File necesario para hacer el rename al final de esta función
        File ArchivoOriginal = new File("parchaditos.txt");
        File ArchivoTemporal = new File("tempFile.txt");

        String LineaxActualizar = UsuarioxActualizar.getNombre() + ";" + UsuarioxActualizar.getCedula() + ";"
                + UsuarioxActualizar.getCorreoElectronico()
                + ";" + UsuarioxActualizar.getContrasenia();

        System.out.println(LineaxActualizar);

        String lineaActual = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(ArchivoOriginal));
                BufferedWriter writer = new BufferedWriter(new FileWriter(ArchivoTemporal))) {
            // Usuario que queremos quitar

            while ((lineaActual = reader.readLine()) != null) {
                // Trim sirve para quitar los espacios y dejar la línea linda
                String trimmedLine = lineaActual.trim();
                StringTokenizer tokens = new StringTokenizer(trimmedLine, ";");
                tokens.nextToken();
                String cedula = tokens.nextToken();

                // Continue sirve para ignorar el caso en el que se cumple la condición y seguir
                // iterando
                // aquí tiene mucho sentido porque el objetivo es justamente el de no escribir
                // la línea que queremos quitar

                if (cedula.equalsIgnoreCase(UsuarioxActualizar.getCedula())) {
                    writer.write(LineaxActualizar + System.getProperty("line.separator"));
                } else {
                    // System.getProperty("line.separator") es un separador espectacular, porque
                    // hace la separación adecuadamente
                    // independientemente del sistema operativo
                    writer.write(lineaActual + System.getProperty("line.separator"));
                    // System.out.println(lineaActual);
                }
            }
            writer.close();
            reader.close();
            ArchivoOriginal.delete();
            ArchivoTemporal.renameTo(ArchivoOriginal);
            Archivotxt.limpiar(ArchivoOriginal);
        } catch (Exception e) {
            e.printStackTrace();
            // JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
    }

    /**
     * DELETE
     * Eliminar un usuario
     * @param UsuarioARemover este parametro se usa para pasarle los datos del usuario que se van a remover
     */
    public void Delete(Usuarios UsuarioARemover) {

        // File necesario para hacer el rename al final de esta función
        File ArchivoOriginal = new File("parchaditos.txt");
        File ArchivoTemporal = new File("tempFile.txt");

        String lineaARemover = UsuarioARemover.getNombre() + ";" + UsuarioARemover.getCedula() + ";"
                + UsuarioARemover.getCorreoElectronico()
                + ";" + UsuarioARemover.getContrasenia();
        String lineaActual = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(ArchivoOriginal));
                BufferedWriter writer = new BufferedWriter(new FileWriter(ArchivoTemporal))) {
            // Usuario que queremos quitar

            while ((lineaActual = reader.readLine()) != null) {
                // Trim sirve para quitar los espacios y dejar la línea linda
                String trimmedLine = lineaActual.trim();

                // Continue sirve para ignorar el caso en el que se cumple la condición y seguir
                // iterando
                // aquí tiene mucho sentido porque el objetivo es justamente el de no escribir
                // la línea que queremos quitar

                if (trimmedLine.equalsIgnoreCase(lineaARemover)) {
                    continue;
                }
                // System.getProperty("line.separator") es un separador espectacular, porque
                // hace la separación adecuadamente
                // independientemente del sistema operativo
                writer.write(lineaActual + System.getProperty("line.separator"));
                // System.out.println(lineaActual);
            }
            writer.close();
            reader.close();
            ArchivoOriginal.delete();
            ArchivoTemporal.renameTo(ArchivoOriginal);
            Archivotxt.limpiar(ArchivoOriginal);
        } catch (Exception e) {
            e.printStackTrace();
            // JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
    }

}