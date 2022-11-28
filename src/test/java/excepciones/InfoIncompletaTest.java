package excepciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfoIncompletaTest {

    @Test
    void test_InfoCompleta () {
        var tester = new InfoIncompleta("MSG!") ;
        assertEquals("Excepcion de información: MSG!" , tester.toString());
    }

}