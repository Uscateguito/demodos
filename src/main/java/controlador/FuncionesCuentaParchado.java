package controlador;

import java.util.LinkedList;

import conexion.CRUDtxt;
import modelo.Usuarios;

public class FuncionesCuentaParchado {
    
    private LinkedList<Usuarios> UsuariosParchados;

    public FuncionesCuentaParchado(LinkedList<Usuarios> usuariosParchados) {
        UsuariosParchados = usuariosParchados;
    }

    public FuncionesCuentaParchado() {
    }
    /**
     * Esta función sirve para agregar un usuario a la base de datos, pero también a la lista
     * También sirve para validar si el usuario ya existe y necesariamente esto se hace con su documento de identificación nacional
     * lo último por motivos de seguridad
     * @param UsuarioNuevo
     */
    public void crearUsuario(Usuarios UsuarioNuevo){
        if(ObtenerPorCedula(UsuarioNuevo.getCedula()) == null){
            UsuariosParchados.add(UsuarioNuevo);
            CRUDtxt bd = new CRUDtxt();
            bd.Escribir(UsuarioNuevo);
        }else{
            System.out.println("El usuario ya está registrado");
        }
    }

    public void EliminarPorCedula(String cedula){
        try {
            Usuarios x = ObtenerPorCedula(cedula);
            CRUDtxt bd = new CRUDtxt();
            bd.Delete(x);
            cargarUsuarios(); 
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ningún usuario tiene esta cédula en nuestra base de datos. :(");
        } 
    }

    /**
     * Aquí el usuario puede modificar sus datos
     * @param usuarioModificado
     */
    public void Actualizar(Usuarios usuarioModificado){
        CRUDtxt bd = new CRUDtxt();
        bd.Update(usuarioModificado);
        cargarUsuarios();
    }
    
    public int totalUsuarios(){
        return UsuariosParchados.size();
    }

    public Usuarios ObtenerPorCedula(String cedula){
        for (Usuarios x : UsuariosParchados) {
            if(x.getCedula().equalsIgnoreCase(cedula)){
                return x;
            }
        }
        return null;
    }

    public void cargarUsuarios(){
        CRUDtxt bd = new CRUDtxt();
        UsuariosParchados = bd.obtener();
    }

    public void leer(){
        for(int i=0;i<UsuariosParchados.size(); i++){
            System.out.println("[Cedula=" + UsuariosParchados.get(i).getCedula() + ", CorreoElectronico=" + UsuariosParchados.get(i).getCorreoElectronico() + 
            ", nombre=" + UsuariosParchados.get(i).getNombre() + "]");
        }
    }

    public boolean iniciarSesion(String cedula, String contrasenia){
        // Valida si el usuario existe en el sistema o no
        // El usuario inicia sesión con su cédula y su contraseña
        Usuarios x = ObtenerPorCedula(cedula);
        if(x != null && contrasenia == x.getContrasenia()){
            return true;
        }
        return false;
    }


}
