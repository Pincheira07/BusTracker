import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BusTracker{
    public static void main(String[] args) throws IOException {
        iniciarAplicacion();
    }
    public static void iniciarAplicacion() throws IOException {
        iniciarMenu();
    }

    private static void iniciarMenu() throws IOException {
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

    public static void ejecutarMenu(int opcion) throws IOException {
        switch (opcion) {
            case 1 -> {
                System.out.println("Iniciando sesion...");
                System.out.println("Bienvenido pasajero");
                ejecutarConsultaUbicacion();
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

    public static void ejecutarConsultaUbicacion(){
        try {
            mostrarUbicacion(leerArchivo("movimiento.csv"));
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void mostrarUbicacion(ArrayList<String> arrayList){
        String[] coordendas;
        for (int i = 0; i < arrayList.size();i++) {
            coordendas = arrayList.get(0).split(",");
            System.out.println("Latitud: " + coordendas[0] + " Longitud: " + coordendas[1]);
        }


    }



    public static void compartirUbicacion() throws IOException {
        entregarCoordenadas(leerArchivo("Linea1A.csv"));
    }

    public static ArrayList<String> leerArchivo(String ruta) throws IOException {
        /*
        * Lee el archivo y añade cada linea a un arraylist
        */
        File file = new File(ruta);
        Scanner input = new Scanner(file);
        ArrayList<String> arr = new ArrayList<>();
        while (input.hasNextLine()) {
            arr.add(input.nextLine());
        }
        return arr;
    }

    public static void entregarCoordenadas(ArrayList<String> arr) throws IOException{
        /*
        * Crea un array de strings para la linea actual y lo divide en latitud y longitud, luego,
        * llama al metodo "escribirCoordenadas
        * */
        String[] coordendas;

        for (int i = 0; i < arr.size(); i++) {
            try {
                Thread.sleep(3930);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            coordendas = arr.get(i).split(",");
            escribirCoordenadas(coordendas[0], coordendas[1]);
        }


    }

    public static void escribirCoordenadas(String latitud, String longitud) throws IOException {
        /*
        * Escribe la linea proporcionada por "entregarCoordenadas" en un nuevo archivo llamado "movimiento.csv"
        * que cuenta con una sola linea que se va actualizando a medida que se recibe una nueva coordenada
        * */
        List<List<String>> rows = Collections.singletonList(Arrays.asList(latitud, longitud));
        FileWriter csvWriter = new FileWriter("movimiento.csv");
        for (List<String> rowData : rows) {
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }


}