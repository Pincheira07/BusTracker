import java.util.Scanner;

public class BusTracker{
    public static void main(String[] args) {
        iniciarAplicacion();
    }
    public static void iniciarAplicacion() {
        iniciarMenu();
    }

    private static void iniciarMenu() {
        mostrarMenu();
        int opcion = leerOpcionMenu();
        if (!validarOpcionMenu(opcion)){
            System.out.println("Valor fuera de rango");
        }else{
            ejecutarMenu(opcion);
        }
    }

    private static int leerOpcionMenu() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese una opción:");
        return scanner.nextInt();
    }

    public static boolean validarOpcionMenu(int opcion) {
        return -1 < opcion && opcion < 5;
    }

    public static void ejecutarMenu(int opcion) {
        switch (opcion) {
            case 1 -> {
                System.out.println("Iniciando sesion...");
                System.out.println("Bienvenido pasajero");
            }
            case 2 -> {
                System.out.println("Iniciando sesion...");
                System.out.println("Bienvenido conductor");
                compartirUbicacion();
            }
            case 0 -> System.exit(0);
        }
    }



    public static void mostrarMenu(){
        System.out.println("***********************************************************");
        System.out.println("-----------------------BusTracker--------------------------");
        System.out.println("*                       MENÚ                              *");
        System.out.println("[1]Pasajero");
        System.out.println("[2]Conductor");
        System.out.println("[0]Salir");
        System.out.println("***********************************************************");
    }

    public static void compartirUbicacion(){
        System.out.println("*Coordenadas*");
    }


}