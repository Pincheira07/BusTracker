import Model.Encriptador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncriptadorTest {

    @Test
    void cifrar() {
        Encriptador encriptador = new Encriptador();
        String prueba = encriptador.cifrar("Matias Pincheira", 10);
        assertEquals("Gk~cky*Zcdibocxk", prueba);
    }

    @Test
    void cifrar2(){
        Encriptador encriptador = new Encriptador();
        String prueba = encriptador.cifrar("hola", 10);
        assertEquals("befk", prueba);
    }

    @Test
    void cifrar3() {
        Encriptador encriptador = new Encriptador();
        String prueba = encriptador.cifrar("BusTracker", 10);
        assertEquals("H\u007Fy^xkiaox", prueba);
    }
}