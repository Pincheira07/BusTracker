import java.util.Scanner;
public class BusTracker {
    public static void main(String[] args) {
        iniciarAplicacion();
    }

    public static void iniciarAplicacion() {
        ejecutarMenu();
    }

    private static String leerOpcionMenu() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese una opción:");
        return scanner.next();
    }


    public static void ejecutarMenu() {
        int aux=0;
        do {
            mostrarMenu();
            String opcion = leerOpcionMenu();
        switch (opcion) {
            case "1":
                System.out.println("Iniciando sesion...");
                System.out.println("Bienvenido pasajero");
                aux=0;
                break;

            case "2":
                System.out.println("Iniciando sesion...");
                System.out.println("Bienvenido conductor");
                compartirUbicacion();
                aux=0;
                break;

            case "0":
                aux=1;
                break;

            default:
                aux=0;
                System.err.println("Opcion ingresada no valida");
        }
        }while (aux==0);

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