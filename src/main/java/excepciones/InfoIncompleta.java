package excepciones;

public class InfoIncompleta extends Exception {
    
    String detalle;

    public InfoIncompleta(String s) {
        detalle=s;
    }

    public String toString(){
        return "Excepcion de información: " + detalle;
    }
    
}