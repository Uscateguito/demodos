package conexion;

import java.util.LinkedList;
import modelo.Lugares;

public interface CrudLugares {
    // En vez de Lugares, debería tener Lugares en sus parámetros, pero todavía no ha sido implementado
    public void Escribir(Lugares usuarioNuevo);
    public LinkedList<Lugares> obtenerLugares();
    public void Update(Lugares UsuarioxActualizar);
    public void Delete(Lugares UsuarioARemover);    
}