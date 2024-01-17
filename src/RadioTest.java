//En esta clase se prueban los JUnit tests para comprobar que algunos de nuestros métodos funcionen como se espera.

//Librerías para probar los métodos
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RadioTest {
    private Radio radio = new Radio();

    //Se prueba que tengamos el booleano correspondiente al estado encendido
    @Test
    public void testEncendido(){
        assertFalse(radio.getEncendido());
        radio.setEncendido(true);
        assertTrue(radio.getEncendido());
    }

    //Se prueba que el volumen sí se vea modificado al setearle un valor
    @Test
    public void testVolumen(){
        assertEquals(0, radio.getVolumen());
        radio.setVolumen(5);
        assertEquals(5, radio.getVolumen());
    }

    //Se prueba el incremento que se vaya a dar en la emisora y si es válido
    @Test
    public void testIncrementoValido() {
        assertTrue(radio.incrementoValido(95.5f, 0.1f));
        assertFalse(radio.incrementoValido(95.55f, 0.1f));
        assertTrue(radio.incrementoValido(600, 0.2f));
        assertFalse(radio.incrementoValido(600.1f, 0.2f));
    }


}
