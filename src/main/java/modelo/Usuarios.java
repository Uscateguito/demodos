package modelo;

public class Usuarios {

    private String nombre;
    private String Cedula;
    private String CorreoElectronico;
    private String contrasenia;

    // Constructor --------------------------------

    /**
     * Construye el objeto Usuarios
     * @param nombre nombre del usuario
     * @param cedula cedula del usuario
     * @param correoElectronico correo del usuario
     * @param contrasenia contraseña del usuario
     */
    public Usuarios(String nombre, String cedula, String correoElectronico, String contrasenia) {
        this.nombre = nombre;
        Cedula = cedula;
        CorreoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    // Getters y Setters --------------------------------

    /**
     * Obtiene el nombre
     * @return retorna el nombre 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre 
     * @param nombre El nombre del usuario 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obiene la cedula
     * @return la cedula del usuario
     */
    public String getCedula() {
        return Cedula;
    }

    /**
     * Modifica la cedula
     * @param cedula cedula del usuario
     */
    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    /**
     * Modifica el correo eletronico del usuario
     * @return el correo electronico del usuario
     */
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    /**
     * Modifica el correo electronico del usuario
     * @param correoElectronico El correo electronico del usuario
     */
    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    /**
     * Obtiene la contraseña del usuario
     * @return La contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Modifica la contraseña del usuario
     * @param contrasenia la contraseña del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // toString ------------------------------------------

    /**
     * Convierte el objeto a texto
     */
    @Override
    public String toString() {
        return "Usuarios [Cedula=" + Cedula + ", CorreoElectronico=" + CorreoElectronico + ", nombre=" + nombre + "]";
    }

    /**
     * Clona el usuario 
     */
    public Usuarios clone() {

        Usuarios u;

        u = new Usuarios(this.getNombre(), this.getCedula(), this.getCorreoElectronico(), this.getContrasenia());

        return u;
    }

}
