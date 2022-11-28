package conexion;

import java.util.LinkedList;
import modelo.Deportes;

public interface CrudDeportes {
    // En vez de Deportes, debería tener deportes en sus parámetros, pero todavía no ha sido implementado
    public void Escribir(Deportes usuarioNuevo);
    public LinkedList<Deportes> obtenerDeportes();
    public void Update(Deportes UsuarioxActualizar);
    public void Delete(Deportes UsuarioARemover);    
}