package controlador;

import conexion.CRUDtxt;
import modelo.Usuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionesCuentaParchadoTest {

    @Test
    void test_crearUsuario () {
        var aux = CRUDtxt.getInstance();
        var tester = new FuncionesCuentaParchado();
        var usuario = new Usuarios("Aaa","1010","correo","contra") ;
        tester.crearUsuario(usuario);
        assertEquals(1,aux.obtener().stream().filter(usuarios -> usuarios.getCedula().equalsIgnoreCase("1010")).count());
    }

}