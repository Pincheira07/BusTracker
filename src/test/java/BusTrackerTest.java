import org.junit.jupiter.api.Test;

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
}