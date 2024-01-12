import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("BIENVENIDO A TU RADO DE CONFIANZA!");
        System.out.println("-------------------------------------");

        String  banda = "AM";

        System.out.println("Presiona enter para encender la radio:");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Radio radio = new Radio();
        radio.encender();

        if (radio.getBanda() == 1) {
            banda = "FM";
        }else{
            banda = "AM";
        }

        while (radio.getEstado()) {
            System.out.println("-------------------------------------");
            System.out.println("ESTACIÓN ACTUAL: " + radio.getEstacion() + " " + banda);
            System.out.println("VOLUMEN ACTUAL: " + radio.getVolumen());
            System.out.println("-------------------------------------");


            System.out.println("Elige una opción: ");
            System.out.println("1. Cambiar de banda");
            System.out.println("2. Cambiar de estación");
            System.out.println("3. Guardar estación");
            System.out.println("4. Seleccionar estación guardada");
            System.out.println("5. Apagar la radio");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Elige una banda: ");
                    System.out.println("1. FM");
                    System.out.println("2. AM");
                    int new_banda = scanner.nextInt();
                    radio.setBanda(new_banda);

                    break;
                case 2:
                    System.out.println("Cambiando de estación...");
                    System.out.println("Elige una estación: ");
                    float new_estacion = scanner.nextFloat();
                    radio.setEstacion(new_estacion);

                    break;
                case 3:
                    System.out.println("Guardando estación...");
                    break;
                case 4:
                    System.out.println("Seleccionando estación guardada...");
                    break;
                case 5:
                    System.out.println("Apagando la radio...");
                    radio.setEstado(false);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }

    }
}
