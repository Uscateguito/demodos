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

    /**INICIALIZADOR&CONSTRUCTOR
     * No sólo es un constructor, también inicializa la lista
     */
    public FuncionesCuentaParchado() {
        FuncionesCuentaParchado.cargarUsuarios();
    }
    /**CREATE
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

    /**READ
     * Esta función recorre con un ciclo la lista de usuarios y la imprime en pantalla, se usó principalmente para pruebas
     * Es reemplazable, pero útil en caso de que deban realizarse modificaciones para hacer pruebas
     */
    public void leer(){
        for(int i=0;i<UsuariosParchados.size(); i++){
            System.out.println("[Cedula=" + UsuariosParchados.get(i).getCedula() + ", CorreoElectronico=" + UsuariosParchados.get(i).getCorreoElectronico() + 
            ", nombre=" + UsuariosParchados.get(i).getNombre() + "]");
        }
    }
    
    /**UPDATE
     * Aquí el usuario puede modificar sus datos
     * @param usuarioModificado
     */
    public void Actualizar(Usuarios usuarioModificado){
        System.out.println("Hola");
        CRUDtxt bd = new CRUDtxt();
        bd.Update(usuarioModificado);
        System.out.println("Hola");
        cargarUsuarios();
    }
    
    /**DELETE
     * Elimina a un usuario de la lista con base a su cédula
     * @param cedula
     */
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

    /**SIZEUSUARIOS
     * Retorna la cantidad de usuarios que tiene la app
     * @return
     */
    public int totalUsuarios(){
        return UsuariosParchados.size();
    }

    /**ENCONTRAR USUARIO
     * Esta función busca un usuario en la lista a partir de su cédula, en caso de encontrarlo, retorna al usuario completo
     * @param cedula
     * @return
     */
    public Usuarios ObtenerPorCedula(String cedula){
        for (Usuarios x : UsuariosParchados) {
            if(x.getCedula().equalsIgnoreCase(cedula)){
                return x;
            }
        }
        return null;
    }
    
    /**CARGAR LA MEMORIA DESDE LA BASE DE DATOS
     * Esta función permite llenar la memoria a partir de la persistencia, simplemente realiza un read de la base de datos y mete la información
     * en una linkedList
     */
    public static void cargarUsuarios(){
        CRUDtxt bd = new CRUDtxt();
        UsuariosParchados = bd.obtener();
    }

    
    /**VALIDAR INICIO DE SESIÓN
     * Esta función sirve para evaluar al iniciar sesión que el usuario exista y además que su contraseña sea correcta,
     * le hace falta un hash para que la contraseña no quede guardada en texto plano
     * @param cedula
     * @param contrasenia
     * @return
     * @throws InfoIncompleta
     */
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