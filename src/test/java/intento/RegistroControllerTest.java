package intento;

import conexion.CrudUsuarios;
import modelo.Usuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroControllerTest {

    @Test
    void test_Registro () {
        var tester = new RegistroController() ;
        var usuario = new Usuarios("Aaa","1001","correo","psw") ;
        var aux = CrudUsuarios.getInstance();
        tester.l.crearUsuario(usuario);
        assertEquals(1,aux.obtener().stream().filter(usuarios -> usuarios.getCedula().equalsIgnoreCase("1001")).count());
    }

}