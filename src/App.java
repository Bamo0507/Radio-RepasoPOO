//En esta clase se manejará toda la lógica detrás de nuestro programa.
//Este se encargará de manejar que el radio realicé diferentes funciones, como aumentar volumen, modificar estado, cambiar de band y estación.
import java.util.Scanner;

public class App {
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //Mensaje de bienvenida
        System.out.println("BIENVENIDO A TU RADIO DE CONFIANZA!");
        System.out.println("----------- -SOMOS SONY- -----------");
        System.out.println("-------------------------------------");

        String banda = "AM";

        //Se comienza con el menú
        System.out.println("Presiona enter para encender la radio:");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Radio radio = new Radio();

        //Colocamos que la radio está encendida
        radio.setEncendido(true);

        //Se establece el valor adecuado para la banda
        if (radio.getBanda() == 0) {
            banda = "AM";
        }else{
            banda = "FM";
        }

        //Siempre que el radio esté encendido se desplegará la siguiente información y opciones
        while (radio.getEncendido()) {
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println("ESTACION ACTUAL: " + radio.getEstacion() + " " + banda);
            System.out.println("VOLUMEN ACTUAL: " + radio.getVolumen());
            System.out.println("-------------------------------------");

            //Opciones ofrecidas al usuario
            System.out.println("Elige una opción: ");
            System.out.println("1. Cambiar de banda");
            System.out.println("2. Cambiar de estación");
            System.out.println("3. Guardar estación");
            System.out.println("4. Seleccionar estación guardada");
            System.out.println("5. Apagar la radio");
            System.out.println("6. Modificar el volumen");

            //Variables para manejar las elecciones del usuario
            //
            //Guarda la opción elegida para el menú principal
            String opcion = scanner.nextLine();
            //Verifica que se ingrese algo válido
            boolean verificacion1 = true;

            //Se correrá la opción correspondiente dependiendo de lo que el usuario elija
            switch (opcion) {
                //Código a correr para cambiar de AM a FM a AM
                case "1":
                        System.out.println("Elige una banda: ");
                        System.out.println("1. FM");
                        System.out.println("2. AM");
                        int opcionBanda = obtenerEnteroValido(scanner);
                        switch(opcionBanda){
                            case 1:
                                radio.setBanda(1);
                                banda = "FM";
                                break;
                            case 2:
                                radio.setBanda(0);
                                banda = "AM";
                                break;
                            default:
                                System.out.println("Por favor, seleccione una opción válida.");
                        }
                    break;
                
                //Código a correr para cambiar de estación (avanzar en el dial)
                case "2":
                    System.out.println("Cambiando de estación...");
                    System.out.println("Elige una estación: ");
                    float new_estacion = scanner.nextFloat();
                    scanner.nextLine();
                    int currentBanda = radio.getBanda();
                    radio.setEstacion(new_estacion, currentBanda);
                    break; 
                    

                //AQUÍ HAY QUE GUARDAR LA ESTÁCIÓN EN ALGUNO DE LOS 12 BOTONES
                //DEPENDIENDO DE SI ESTAMOS EN LA BANDA AM O FM
                case "3":
                    int banda1 = radio.getBanda();
                    Float emisora1 = radio.getEstacion();
                    System.out.println("¿En qué botón desea guardar la emisora actual? 1~12");
                    int espacio = obtenerEnteroValido(scanner);
                    radio.guardarEstacion(emisora1, banda1, espacio); 
                    break;

                //AQUÍ HAY QUE MANDAR A LLAMAR A LA ESTACIÓN CORRECTA 
                //ESTO DEPENDE DEL INDICE QUE MANDE EL USUARIO Y DE LA BANDA (AM O FM)
                case "4":
                    System.out.println("Seleccionando estación guardada...");
                    System.out.println("Ingrese el número del botón (1-12) para seleccionar la estación guardada:");
                    
                    int botonSeleccionado = Integer.parseInt(scanner.nextLine());
                
                    if (botonSeleccionado < 1 || botonSeleccionado > 12) {
                        System.out.println("Error: El número del botón debe estar entre 1 y 12.");
                    } else {
                
                        float estacionRecuperada = radio.recuperarEstacion(botonSeleccionado);
                
                        if (estacionRecuperada == 0.0f) {
                            System.out.println("--------------------------------");
                        } else {
                            int Bandaactual = radio.getBanda();
                            radio.setEstacion(estacionRecuperada, Bandaactual);
                            System.out.println("Estación guardada seleccionada: " + estacionRecuperada);
                        }
                    }
                    break;

                //Si se selecciona la opción de apagar la radio
                case "5":
                    System.out.println("Apagando la radio...");
                    radio.setEncendido(false);
                    break;

                //ACÁ SE DEBERÁ MODIFICAR EL VOLUMEN DANDO DOS OPCIONES
                //SUBIRLE VOLUMEN A TRAVÉS DE UN VALOR INGRESADO
                //O SUBIR POR 1 EL VALOR DEL VOLUMEN
                //SIEMPRE TOMANDO EN CUENTA EL LIMITE DE 0 A 100
                case "6":
                    System.out.println("¿Còmo desea modificar el volumen de la radio?");
                    int opcion2 = 0;
                    int volumen = 0;
                    while(!(opcion2<=2 && opcion2>=1)){
                        System.out.println("1. Ingresar volumen de manera manual.");
                        System.out.println("2. Aumentar por uno el volumen.");
                        opcion2 = obtenerEnteroValido(scanner);
                        if(opcion2 == 1){
                            System.out.println("Ingrese el nuevo volumen (0-100):");
                            volumen = obtenerEnteroValido(scanner);
                            // Validación para no ingresar números negativos
                            if (volumen < 0) {
                                System.out.println("Error: No se pueden ingresar números negativos. Volumen ajustado a 0.");
                                volumen = 0;
                            } else if (volumen > 100) {
                                volumen = 100;
                            }
                            radio.setVolumen(volumen);
                        } else if(opcion2 == 2){
                            int volumenActual = radio.getVolumen();
                            volumenActual++;
                            radio.setVolumen(volumenActual);
                            System.out.println("Ahora tu volumen es de " + volumenActual + ".");
                        }else{
                            System.out.println("Por favor, ingrese una de las dos opciones vàlidas.");
                        };
                    }
                    break;

                //Líneas a mostrar al usuario en saso de seleccionar una opción inválida
                default:
                    System.out.println("Opción no válida");
                    System.out.println("Por favor, vuelva a intentarlo");
                    break;
            }

        }

    }

    
    /** 
     * @param scanner
     * @return int
     */
    //Método para asegurarse que se ingrese un entero en los campos necesarios
    public static int obtenerEnteroValido(Scanner scanner) {
        int numero = 0;
        boolean entradaValida = false;
        System.out.println("------------------------");
        do {
            try {
                System.out.print("Por favor, ingresa un número entero: ");
                String entrada = scanner.nextLine();
                numero = Integer.parseInt(entrada);
                entradaValida = true;
                System.out.println("");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debes ingresar un número entero.");
            }
        } while (!entradaValida);

        return numero;
    }

    /** 
     * @param scanner
     * @return float
     */
    //Método para asegurarse que se ingrese un float en los campos necesarios
    public static float obtenerFloatValido(Scanner scanner) {
        float numero = 0.0f;  // Inicializado a 0.0f
        boolean entradaValida = false;
        System.out.println("------------------------");
        do {
            try {
                System.out.print("Por favor, ingresa un número decimal: ");
                String entrada = scanner.nextLine();
                numero = Float.parseFloat(entrada);
                entradaValida = true;
                System.out.println("");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debes ingresar un número decimal.");
            }
        } while (!entradaValida);
    
        return numero;
    }

}
