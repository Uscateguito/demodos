package controlador;

import java.util.LinkedList;

import conexion.CRUDtxt;
import excepciones.InfoIncompleta;
import modelo.Usuarios;

public class FuncionesCuentaParchado {
    
    private static LinkedList<Usuarios> UsuariosParchados;

    public FuncionesCuentaParchado(LinkedList<Usuarios> usuariosParchados) {
        UsuariosParchados = usuariosParchados;
    }

    public FuncionesCuentaParchado() {
        FuncionesCuentaParchado.cargarUsuarios();
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

    public static void cargarUsuarios(){
        CRUDtxt bd = new CRUDtxt();
        UsuariosParchados = bd.obtener();
    }

    public void leer(){
        for(int i=0;i<UsuariosParchados.size(); i++){
            System.out.println("[Cedula=" + UsuariosParchados.get(i).getCedula() + ", CorreoElectronico=" + UsuariosParchados.get(i).getCorreoElectronico() + 
            ", nombre=" + UsuariosParchados.get(i).getNombre() + "]");
        }
    }

    public boolean iniciarSesion(String cedula, String contrasenia) throws InfoIncompleta{
        // Valida si el usuario existe en el sistema o no
        // El usuario inicia sesión con su cédula y su contraseña
        if( cedula == null || contrasenia == null ){
            throw new InfoIncompleta("Por favor ingrese un valor en todas las líneas");
        }else{
            Usuarios x = ObtenerPorCedula(cedula);
        if(x != null && contrasenia.equalsIgnoreCase(x.getContrasenia())){
            System.out.println("Se cumple");
            return true;
        }
        return false;
        }
    }


}
