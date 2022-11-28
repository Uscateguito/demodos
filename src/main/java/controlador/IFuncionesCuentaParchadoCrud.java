package controlador;

import modelo.Usuarios;

public interface IFuncionesCuentaParchadoCrud {
    
    public void crearUsuario(Usuarios UsuarioNuevo);
    public void EliminarPorCedula(String cedula);
    public void Actualizar(Usuarios usuarioModificado);
    public void leer();
}
