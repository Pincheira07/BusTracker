import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BusTrackerTest {

    @org.junit.jupiter.api.Test
    void testLeerArchivo() {
        ArrayList<String> arrlist = BusTracker.leerArchivo("Linea1A.csv");
        assertEquals("-38.67658,-72.50619", arrlist.get(0));
    }
    @org.junit.jupiter.api.Test
    void testLeerArchivo1() {
        ArrayList<String> arrlist = BusTracker.leerArchivo("Linea1A.csv");
        assertEquals("-38.68332,-72.50248", arrlist.get(100));
    }
    @org.junit.jupiter.api.Test
    void testLeerArchivo2() {
        ArrayList<String> arrlist = BusTracker.leerArchivo("Linea1A.csv");
        assertEquals("-38.75937,-72.64552", arrlist.get(850));
    }
    @org.junit.jupiter.api.Test
    void testValidarOpcionMenu(){
        boolean resultado = BusTracker.validarOpcionMenu(10);
        assertFalse(resultado);
    }
    @org.junit.jupiter.api.Test
    void testValidarOpcionMenu2(){
        boolean resultado = BusTracker.validarOpcionMenu(3);
        assertFalse(resultado);
    }
    @org.junit.jupiter.api.Test
    void testValidarOpcionMenu3(){
        boolean resultado = BusTracker.validarOpcionMenu(1);
        assertTrue(resultado);
    }

}