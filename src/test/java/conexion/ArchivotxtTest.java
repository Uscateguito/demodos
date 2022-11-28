package conexion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchivotxtTest {

    @Test
    void testArchivoTest () {
        Archivotxt tester = new Archivotxt("prueba.txt") ;
        assertEquals("hola", tester.ObtenerTextodeArchivo().get(0));
    }

}