package controlador;

import conexion.CrudUsuarios;
import modelo.Usuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionesCuentaParchadoTest {

    @Test
    void test_crearUsuario () {
        var aux = CrudUsuarios.getInstance();
        var tester = new FuncionesCuentaParchado();
        var usuario = new Usuarios("Aaa","1010","correo","contra") ;
        tester.crearUsuario(usuario);
        assertEquals(1,aux.obtener().stream().filter(usuarios -> usuarios.getCedula().equalsIgnoreCase("1010")).count());
    }

}