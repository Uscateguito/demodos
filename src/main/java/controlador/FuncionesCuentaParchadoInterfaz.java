package controlador;

import excepciones.InfoIncompleta;
import modelo.Usuarios;

public interface FuncionesCuentaParchadoInterfaz {
    
    public void crearUsuario(Usuarios UsuarioNuevo);
    public void EliminarPorCedula(String cedula);
    public void Actualizar(Usuarios usuarioModificado);
    public int totalUsuarios();
    public Usuarios ObtenerPorCedula(String cedula);
    public void leer();
    public boolean iniciarSesion(String cedula, String contrasenia) throws InfoIncompleta;
}
