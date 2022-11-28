package intento;

import conexion.CrudUsuarios;
import modelo.Usuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteControllerTest {

    @Test
    void test_Delete () {
        var tester = new DeleteController() ;
        var usuario = new Usuarios("Aaa","1010","core","psw") ;
        var aux = CrudUsuarios.getInstance();
        tester.l.EliminarPorCedula(usuario.getCedula());
        assertEquals(0,aux.obtener().stream().filter(usuarios -> usuarios.getCedula().equalsIgnoreCase("1010")).count());
    }

}