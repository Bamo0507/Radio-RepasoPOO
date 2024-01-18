//Aquí se tiene la clase radio, con todos los atributos generales necesarios para esta.
//También se tienen los métodos a implementar.

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

    
    /** 
     * @param estado
     */
    //Definir el estado del radio, si estará prendido o apagado
    public void setEncendido(boolean estado){
        this.estado = estado;
    }

    
    /** 
     * @param volumen
     */
    //Establecer el volumen del radio
    public void setVolumen(int volumen){
        this.Volumen = volumen;
    }

    
    /** 
     * @param banda
     */
    //Definir la banda que se estará escuchando
    public void setBanda(int banda) {
        if (banda == 1 || banda == 0) {
            Banda = banda;
            if (Banda == 1) {
                this.Estacion = 87.9f;
                System.out.println("La banda ha sido cambiada a FM");
            } else {
                this.Estacion = 530;
                System.out.println("La banda ha sido cambiada a AM");
            }
        } else {
            System.out.println("Opción inválida. La banda no ha sido cambiada.");
        }
    }

    
    /** 
     * @param emisora
     * @param banda
     */
    //Establecer la Estación y Banda
    public void setEstacionBanda(float emisora, int banda) {
        if (Banda == 1) {
            if (incrementoValido(emisora, (float )0.30)) {
                if (emisora >= 87.9 && emisora <= 107.91) {
                    Estacion = emisora;
                    System.out.println("La estación ha sido cambiada a " + emisora);
                } else {
                    System.out.println("La estación no ha sido cambiada. Estación fuera de rango.");
                }
            } else {
                System.out.println("La estación solo puede ser de incrementos de 0.2 en 0.2");
            }
        } else {
            if (incrementoValido(emisora, (float) 10.0)) {
                if (emisora >= 530 && emisora <= 1610) {
                    Estacion = emisora;
                    System.out.println("La estación ha sido cambiada a " + emisora);
                } else {
                    System.out.println("La estación no ha sido cambiada. Estación fuera de rango.");
                }
            } else {
                System.out.println("La estación solo puede ser de incrementos de 10 en 10 ");
            }
        }
    }

    
    /** 
     * @param numero
     * @param incremento
     * @return boolean
     */
    //Se establece si se está aumentando acorde a lo que es permitido por AM o FM
    public boolean incrementoValido(float numero, float incremento) {
        float value = (numero / incremento); // For example, 5.5 / 0.2 = 27.5 
        String strNumero = String.valueOf(numero);
        int ch = (int) strNumero.charAt(strNumero.length() - 1); // 27.5 -> 5
        float remain = value % 1; // 27.5 % 1 = 0.5

        if (numero % 5 == 0) {
            return (0.99 <= remain && remain < 1) || remain == 0;
        } else if (ch % 2 != 0){
            return true;
        } else {
            return false;
        }
    }

    

    
    /** 
     * @return int
     */
    //Obtenemos la banda en la que nos encontramos
    public int getBanda() {
        return Banda;
    }

    
    /** 
     * @return boolean
     */
    //Obtenemos el estado del radio
    public boolean getEncendido() {
        return estado;
    }

    
    /** 
     * @return float
     */
    //Obtenemos la Estación en la que está la radio
    public float getEstacion() {
        return Estacion;
    }

    
    /** 
     * @return int
     */
    //Obtenemos el volumen que tiene el radio actualmente
    public int getVolumen() {
        return Volumen;
    }

    
    /** 
     * @param emisora
     * @param banda
     * @param indice
     */
    public void guardarEstacion(float emisora, int banda, int indice) {
        int Boton = indice - 1;
    
        if (Boton < 0 || Boton >= 12) {
            // Manejar el caso en que el usuario ingrese un número fuera del rango 1-12
            System.out.println("Error: El índice del botón debe estar entre 1 y 12.");
            return; // No se realiza la operación si hay un error.
        } else {
            System.out.println("Guardando estación...");
        }
    
        if (banda == 0) {
            BotonesAM[Boton] = (int) emisora;
        } else if (banda == 1) {
            BotonesFM[Boton] = emisora;
        } else {
          
            System.out.println("Error: El valor de banda debe ser (AM) o (FM).");
        }
    }
    
    /**
     * Recupera la estación guardada en el botón especificado por el índice.
     * 
     * @param indice El índice del botón (entre 1 y 12).
     * @return La estación guardada en el botón especificado.
     *         Si el índice está fuera del rango válido, se muestra un mensaje de error y se devuelve 0.0f.
     *         Si el botón seleccionado está vacío, se muestra un mensaje de error y se devuelve 0.0f.
     *         Si el valor de la banda no es válido, se muestra un mensaje de error y se devuelve 0.0f.
     */
    public float recuperarEstacion(int indice) {
        int Boton = indice - 1;
    
        if (Boton < 0 || Boton >= 12) {
            
            System.out.println("Error: El índice del botón debe estar entre 1 y 12.");
            return 0.0f; 
        }
    
        int banda = this.Banda;
    
        if (banda == 0) {
            if (BotonesAM[Boton] == 0) {
                
                System.out.println("Error: El botón seleccionado está vacío.");
                return 0.0f; 
            }
            return BotonesAM[Boton];
        } else if (banda == 1) {
            if (BotonesFM[Boton] == 0) {
                
                System.out.println("Error: El botón seleccionado está vacío.");
                return 0.0f; 
            }
            return BotonesFM[Boton];
        } else {
            
            System.out.println("Error: El valor de banda debe ser (AM) o (FM).");
            return 0.0f;
        }
    }

}