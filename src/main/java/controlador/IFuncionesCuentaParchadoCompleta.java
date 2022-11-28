package controlador;

import excepciones.InfoIncompleta;
import modelo.Usuarios;

public interface IFuncionesCuentaParchadoCompleta {
    
    public void crearUsuario(Usuarios UsuarioNuevo);
    public void EliminarPorCedula(String cedula);
    public void Actualizar(Usuarios usuarioModificado);
    public void leer();
    public modelo.Usuarios ObtenerPorCedula(String cedula);
    public int totalUsuarios();
    public boolean iniciarSesion(String cedula, String contrasenia) throws InfoIncompleta;
}