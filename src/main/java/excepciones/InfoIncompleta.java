package excepciones;

/**
 * Es un tipo de excepcion que ocurre cuando la informacion de un formulario esta incompleta 
 */
public class InfoIncompleta extends Exception {
    
    String detalle;

    /**
     * Construye la excepción 
     * @param s Texto de la excepcion
     */
    public InfoIncompleta(String s) {
        detalle=s;
    }

    /**
     * Este metodo convierte la excepcion a un string
     * @return Una cadena de texto que contiene la información de la excepción
     */

    public String toString(){
        return "Excepcion de información: " + detalle;
    }
    
}