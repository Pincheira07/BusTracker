import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BusTrackerTest {


    @Test
    void validarUserTest1() {
        String usuario = "Gonzalo";
        String contraseña = "123456";
        boolean esperado = true;
        boolean real = BusTracker.validarUser(usuario,contraseña);
        assertEquals(esperado,real);
    }

    @Test
    void validarUserTest2() {
        String usuario = "Sebastian";
        String contraseña = "123456";
        boolean esperado = false;
        boolean real = BusTracker.validarUser(usuario,contraseña);
        assertEquals(esperado,real);
    }

    @Test
    void separarString() {
        String palabra = "Hola Mundo";
        ArrayList<String> arrEsperado= new ArrayList<String>();
        ArrayList<String> arrReal= new ArrayList<String>();
        arrEsperado.add("Hola");
        arrEsperado.add("Mundo");
        arrReal = BusTracker.separarString(palabra);
        assertArrayEquals(arrEsperado.toArray(),arrReal.toArray());
    }

    @Test
    void separarStringTest2() {
        String palabra = "Hola 1234 ;";
        ArrayList<String> arrEsperado= new ArrayList<String>();
        ArrayList<String> arrReal= new ArrayList<String>();
        arrEsperado.add("Hola");
        arrEsperado.add("1234");
        arrEsperado.add(";");
        arrReal = BusTracker.separarString(palabra);
        assertArrayEquals(arrEsperado.toArray(),arrReal.toArray());
    }
    @org.junit.jupiter.api.Test
    void testLeerArchivo() throws IOException {
        ArrayList<String> arrlist = BusTracker.leerArchivo("Linea1A.csv");
        assertEquals("-38.67658,-72.50619", arrlist.get(0));
    }
    @org.junit.jupiter.api.Test
    void testLeerArchivo1() throws IOException {
        ArrayList<String> arrlist = BusTracker.leerArchivo("Linea1A.csv");
        assertEquals("-38.68332,-72.50248", arrlist.get(100));
    }
    @org.junit.jupiter.api.Test
    void testLeerArchivo2() throws IOException {
        ArrayList<String> arrlist = BusTracker.leerArchivo("Linea1A.csv");
        assertEquals("-38.75937,-72.64552", arrlist.get(850));
    }

}