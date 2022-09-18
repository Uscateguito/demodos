package modelo;

public class Usuarios {
    
    private String nombre;
    private String Cedula;
    private String CorreoElectronico;
    private String contrasenia;

    // Constructor --------------------------------

    public Usuarios(String nombre, String cedula, String correoElectronico, String contrasenia) {
        this.nombre = nombre;
        Cedula = cedula;
        CorreoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    // Getters y Setters --------------------------------

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    

    // toString ------------------------------------------

    @Override
    public String toString() {
        return "Usuarios [Cedula=" + Cedula + ", CorreoElectronico=" + CorreoElectronico + ", nombre=" + nombre + "]";
    }

        
}
