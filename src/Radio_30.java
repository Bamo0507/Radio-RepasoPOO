/**
 * Interfaz que define las operaciones básicas de un sistema de radio.
 */
public interface Radio_30 {

    /**
     * Establece el estado de encendido o apagado del sistema de radio.
     *
     * @param estado true para encendido, false para apagado.
     */
    void setEncendido(boolean estado);

    /**
     * Establece el volumen del sistema de radio.
     *
     * @param volumen Nivel de volumen a establecer.
     */
    void setVolumen(int volumen);

    /**
     * Sintoniza una estación en la banda especificada.
     *
     * @param emisora Frecuencia de la estación.
     * @param banda   Banda de la estación (AM o FM).
     */
    void setEstacionBanda(float emisora, int banda);

    /**
     * Obtiene el estado de encendido o apagado del sistema de radio.
     *
     * @return true si el sistema está encendido, false si está apagado.
     */
    boolean getEncendido();

    /**
     * Obtiene la frecuencia de la estación sintonizada.
     *
     * @return Frecuencia de la estación.
     */
    float getEstacion();

    /**
     * Obtiene la banda de la estación sintonizada (AM o FM).
     *
     * @return Banda de la estación.
     */
    int getBanda();

    /**
     * Obtiene el nivel de volumen actual del sistema de radio.
     *
     * @return Nivel de volumen.
     */
    int getVolumen();

    /**
     * Guarda la estación sintonizada en un índice específico para recuperación futura.
     *
     * @param emisora Frecuencia de la estación.
     * @param banda   Banda de la estación (AM o FM).
     * @param indice  Índice donde se guardará la estación.
     */
    void guardarEstacion(float emisora, int banda, int indice);

    /**
     * Recupera la estación previamente guardada en un índice específico.
     *
     * @param indice Índice de la estación a recuperar.
     * @return Frecuencia de la estación recuperada.
     */
    float recuperarEstacion(int indice);
    
    /**
     * Constante que representa la banda de frecuencia AM.
     */
    public static final int AM = 0;
    
    /**
     * Constante que representa la banda de frecuencia FM.
     */
    public static final int FM = 1;
}

