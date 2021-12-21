package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoferTest {

    @Test
    void validarDisponibilidadMicro() {
        Chofer chofer = new Chofer();
        Linea linea = new Linea("10");
        linea.agregarMicro("te-st-10");
        linea.serializarMicros("Lineas/Micros/MicrosLinea10(test).txt");
        chofer.setLinea(linea);
        boolean resultado = chofer.validarDisponibilidadMicro("Lineas/Micros/MicrosLinea10(test).txt", 0);
        assertTrue(resultado);
    }

    void validarDisponibilidadMicro2() {
        Chofer chofer = new Chofer();
        Linea linea = new Linea("10");
        linea.agregarMicro("te-st-10");
        linea.serializarMicros("Lineas/Micros/MicrosLinea10(test).txt");
        chofer.setLinea(linea);
        boolean resultado = chofer.validarDisponibilidadMicro("Lineas/Micros/MicrosLinea10(test).txt", 0);
        assertTrue(resultado);
    }
}