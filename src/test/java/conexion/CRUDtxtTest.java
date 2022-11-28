package conexion;

import modelo.Usuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CRUDtxtTest {

    @Test
    void test_obtenerUsuario () {
        var tester = CrudUsuarios.getInstance();
        var usuario = new Usuarios("Aaa","0000","correo","psw") ;
        tester.Escribir(usuario);
        assertEquals(0,tester.obtener().stream().filter(s->s.getCedula().equalsIgnoreCase("1001")).count());
    }

    @Test
    void test_crearUsuario () {
        var tester = CrudUsuarios.getInstance() ;
        var usuario = new Usuarios("Aaa","1001","correo","psw") ;
        tester.Escribir(usuario);
        assertEquals(1,tester.obtener().stream().filter(s->s.getCedula().equalsIgnoreCase("1001")).count());
        tester.Delete(usuario);
    }

    @Test
    void test_eliminarUsuario () {
        var tester =CrudUsuarios.getInstance() ;
        var usuario = new Usuarios("Aaa","1001","correo","psw") ;
        tester.Delete(usuario);
        assertEquals(0,tester.obtener().stream().filter(s->s.getCedula().equalsIgnoreCase("1001")).count());
    }

    @Test
    void test_actualizarUsuario () {
        //test_crearUsuario(); // Dependiendo de la prueba se puede comentar esta linea.
        var tester = CrudUsuarios.getInstance() ;
        var usuario = new Usuarios("Bbb","1001","correo","psw") ;
        tester.Update(usuario);
        assertEquals(1,tester.obtener().stream().filter(s->s.getCedula().equalsIgnoreCase("1001")).count());
    }

}