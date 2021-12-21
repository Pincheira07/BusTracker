package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineaTest {



    @Test
    void deserializarMicrosPatente() {
        Linea linea = new Linea("10");
        linea.agregarMicro("te-st-10");
        linea.serializarMicros("Lineas/Micros/MicrosLinea10(test).txt");
        assertEquals(linea.getMicrosTest().get(0).getPatente(), linea.getMicros("Lineas/Micros/MicrosLinea10(test).txt").get(0).getPatente());
    }

    @Test
    void deserializarMicrosPatente2() {
        Linea linea = new Linea("66");
        linea.agregarMicro("te-st-66");
        linea.serializarMicros("Lineas/Micros/MicrosLinea66(test).txt");
        assertEquals("te-st-66",linea.getMicros("Lineas/Micros/MicrosLinea66(test).txt").get(0).getPatente());
    }

    @Test
    void deserializarMicrosLinea() {
        Linea linea = new Linea("66");
        linea.agregarMicro("te-st-66");
        linea.serializarMicros("Lineas/Micros/MicrosLinea66(test).txt");
        assertEquals("66", linea.getMicros("Lineas/Micros/MicrosLinea66(test).txt").get(0).getLinea().getNumero());
    }

    @Test
    void deserializarMicrosIsDisponible() {
        Linea linea = new Linea("10");
        linea.agregarMicro("te-st-10");
        linea.serializarMicros("Lineas/Micros/MicrosLinea10(test).txt");
        assertEquals(linea.getMicrosTest().get(0).isDisponible(), linea.getMicros("Lineas/Micros/MicrosLinea10(test).txt").get(0).isDisponible());
    }

    @Test
    void deserializarMicrosIsDisponible2() {
        Linea linea = new Linea("66");
        linea.agregarMicro("te-st-66");
        linea.serializarMicros("Lineas/Micros/MicrosLinea66(test).txt");
        assertTrue(linea.getMicros("Lineas/Micros/MicrosLinea66(test).txt").get(0).isDisponible());
    }

    @Test
    void deserializarMicrosIsActiva() {
        Linea linea = new Linea("10");
        linea.agregarMicro("te-st-10");
        linea.serializarMicros("Lineas/Micros/MicrosLinea10(test).txt");
        assertEquals(linea.getMicrosTest().get(0).isActiva(), linea.getMicros("Lineas/Micros/MicrosLinea10(test).txt").get(0).isActiva());
    }

    @Test
    void deserializarMicrosIsActiva2() {
        Linea linea = new Linea("66");
        linea.agregarMicro("te-st-66");
        linea.serializarMicros("Lineas/Micros/MicrosLinea66(test).txt");
        assertFalse(linea.getMicros("Lineas/Micros/MicrosLinea66(test).txt").get(0).isActiva());
    }




}