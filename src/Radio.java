
public class Radio implements Radio_30 {
    //Atributos de un radio
    private boolean estado; 
    private String Marca; 
    private int Banda;  // AM = 0, FM = 1
    private int AM = 0;
    private int FM = 1;
    private float Estacion; 
    private float[] BotonesFM = new float[12]; 
    private int[] BotonesAM = new int[12];
    private int Volumen;

    //Constructor para el radio
    public Radio() {
        this.estado = false;
        this.Marca = "Sony";
        this.Banda = 1;
        this.Estacion = 87.9f;
        this.Volumen = 0;
    }

    //Definir el estado del radio, si estará prendido o apagado
    public void setEncendido(boolean estado){
        this.estado = estado;
    }

    //Establecer el volumen del radio
    public void setVolumen(int volumen){
        this.Volumen = volumen;
    }

    //Definir la banda que se estará escuchando
    public void setBanda(int banda) {
        if (banda == 1 || banda == 0) {
            Banda = banda;
            if (Banda == 1) {
                this.Estacion = 88.1f;
                System.out.println("La banda ha sido cambiada a FM");
            } else {
                this.Estacion = 530;
                System.out.println("La banda ha sido cambiada a AM");
            }
        } else {
            System.out.println("Opción inválida. La banda no ha sido cambiada.");
        }
    }

    //Establecer la Estación y Banda
    public void setEstacion(float emisora, int banda) {
        if (Banda == 1) {
            if (emisora >= 87.9 && emisora <= 107.91) {
                Estacion = emisora;
                System.out.println("La estación ha sido cambiada a " + emisora);
            } else {
                System.out.println("La estación no ha sido cambiada. Estación fuera de rango.");
            }
        } else {
            if (emisora >= 530 && emisora <= 1610) {
                Estacion = emisora;
                System.out.println("La estación ha sido cambiada a " + emisora);
            } else {
                System.out.println("La estación no ha sido cambiada. Estación fuera de rango.");
            }
        }
    }

    //Obtenemos la banda en la que nos encontramos
    public int getBanda() {
        return Banda;
    }

    //Obtenemos el estado del radio
    public boolean getEncendido() {
        return estado;
    }

    //Obtenemos la Estación en la que está la radio
    public float getEstacion() {
        return Estacion;
    }

    //Obtenemos el volumen que tiene el radio actualmente
    public int getVolumen() {
        return Volumen;
    }

    //FALTA COLOCAR ACÁ ABAJO LOS MÉTODOS DE GUARDARESTACION Y RECUPERARESTACIÓN
  
}