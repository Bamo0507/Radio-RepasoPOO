public interface Radio_30 {
    setEncendido(boolean estado);
    setVolumen(int volumen);
    setEstacion(float emisora, int banda);
    public static final int AM = 0;
    public static final int FM = 1;
    getEncendido();
    getEstacion();
    getBanda();
    getVolumen();
    guardarEstacion(float emisora, int banda, int indice);
    recuperarEstacion(int indice);
}
