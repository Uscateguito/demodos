package modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuariosTest {

    @Test
    void test_Usuarios () {
        var tester = new Usuarios("John","202200","john22","psw") ;
        assertEquals(tester.toString(),"Usuarios [Cedula=" + tester.getCedula() + ", CorreoElectronico=" + tester.getCorreoElectronico() + ", nombre=" + tester.getNombre() + "]") ;
    }

}