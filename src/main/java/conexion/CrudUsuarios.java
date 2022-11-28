// Patron repositorios

package conexion;

import java.util.LinkedList;
import modelo.Usuarios;

public interface CrudUsuarios {
    public void Escribir(Usuarios usuarioNuevo);
    public LinkedList<Usuarios> obtenerUsuarios();
    public void Update(Usuarios UsuarioxActualizar);
    public void Delete(Usuarios UsuarioARemover);    
}