package controlador;

import excepciones.InfoIncompleta;
import modelo.Usuarios;

public interface IFuncionesCuentaParchadoIniciarSesion {
    
    public Usuarios ObtenerPorCedula(String cedula);
    public boolean iniciarSesion(String cedula, String contrasenia) throws InfoIncompleta;
}
