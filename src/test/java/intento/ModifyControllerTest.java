package intento;

import modelo.Usuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyControllerTest {

    @Test
    void test_Delete () {
        var tester = new ModifyController() ;
        var usuario = new Usuarios("Jhoseph","2","correo","123") ;
        tester.l.Actualizar(usuario);
        assertEquals("correo",tester.l.ObtenerPorCedula("2").getCorreoElectronico());
    }

}