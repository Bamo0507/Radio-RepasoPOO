public interface Radio_30 {
    //Métodos y atributos para implementar en un radio
    void setEncendido(boolean estado);
    void setVolumen(int volumen);
    void setEstacion(float emisora, int banda);
    public static final int AM = 0;
    public static final int FM = 1;
    boolean getEncendido();
    float getEstacion();
    int getBanda();
    int getVolumen();
    void guardarEstacion(float emisora, int banda, int indice);
    float recuperarEstacion(int indice);
}
