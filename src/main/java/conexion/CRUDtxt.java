package conexion;

import java.util.LinkedList;


//Implementacion patron Singleton UwU
public abstract class CRUDtxt<T>{


    // CRUD ------------------------------

    /**
     * CREATE
     * Crear un usuario
     * @param usuarioNuevo Este parametro es el nuevo usuario que se va a escribir en el archivo de texto
     */
    public void Escribir(T objetoNuevo) {
    }

    /**
     * READ
     * Leer los usuarios
     * @return Este parametro retorna una lista de usuarios nuevos 
     */
    public LinkedList<T> obtener() {
        return null;
    }

    /**
     * UPDATE
     * Actualizar un usuario
     * @param UsuarioxActualizar Este parametro se usa para pasarle al metodo los datos actualizados 
     */
    public void Update(T ObjetoxActualizar) {
    }

    /**
     * DELETE
     * Eliminar un Objeto
     * @param ObjetoARemover este parametro se usa para pasarle los datos del Objeto que se van a remover
     */
    public void Delete(T ObjetoARemover) {

    }
}