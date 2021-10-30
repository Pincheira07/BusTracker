import java.io.IOException;
import java.util.Scanner;

public class Inicio {
    private String seleccion;

    public Inicio(){
    }

    public void ejecutarMenu() throws IOException {
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        do {
            mostrarMenu();
            this.seleccion = teclado.next();
            switch (this.seleccion) {
                case "1" -> {
                    System.out.println("Iniciando sesion...");
                    System.out.println("Bienvenido pasajero");
                    break;
                }
                case "2" -> {
                    System.out.println("Iniciando sesion...");
                    Chofer chofer = new Chofer();
                    chofer.ingresarDatosUser();
                    break;
                }
                case "0" -> aux = 1;
                default -> System.err.println("Opcion ingresada no valida");
            }
        }while (aux==0);

    }

    private void mostrarMenu(){
            System.out.println("-------------------Ingrese una opción----------------------");
            System.out.println("***********************************************************");
            System.out.println("-----------------------BusTracker--------------------------");
            System.out.println("*                       MENÚ                              *");
            System.out.println("[1]Pasajero");
            System.out.println("[2]Conductor");
            System.out.println("[0]Salir");
            System.out.println("***********************************************************");
        }

}