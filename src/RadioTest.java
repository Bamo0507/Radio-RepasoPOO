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



}
