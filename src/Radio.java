
public class Radio {

    private boolean estado; 
    private String Marca; 
    private int Banda;  // 1 = FM, 2 = AM
    private float Estacion; 
    private int[] Botones = new int[12]; 
    private int Volumen;


    public Radio() {
        this.estado = false;
        this.Marca = "Sony";
        this.Banda = 1;
        this.Estacion = 87.9f;
        this.Volumen = 0;
    }

    public void encender() {
        this.estado = true;
        System.out.println("La radio se ha encendido");

    }


    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getBanda() {
        return Banda;
    }

    public void setBanda(int banda) {
        if (banda == 1 || banda == 2) {
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

    public float getEstacion() {
        return Estacion;
    }

    public void setEstacion(float estacion) {
        if (Banda == 1) {
            if (estacion >= 87.9 && estacion <= 107.9) {
                Estacion = estacion;
                System.out.println("La estación ha sido cambiada a " + estacion);
            } else {
                System.out.println("La estación no ha sido cambiada. Estación fuera de rango.");
            }
        } else {
            if (estacion >= 530 && estacion <= 1610) {
                Estacion = estacion;
                System.out.println("La estación ha sido cambiada a " + estacion);
            } else {
                System.out.println("La estación no ha sido cambiada. Estación fuera de rango.");
            }
        }
    }

    public int[] getBotones() {
        return Botones;
    }

    public void setBotones(int[] botones) {
        Botones = botones;
    }

    public int getVolumen() {
        return Volumen;
    }

    public void setVolumen(int volumen) {
        Volumen = volumen;
    }
    

    
}