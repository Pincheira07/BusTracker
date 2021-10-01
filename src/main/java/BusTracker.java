import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BusTracker {
    public static void main(String[] args) throws IOException {
        iniciarAplicacion();
    }
    public static void iniciarAplicacion() throws IOException {
        ejecutarMenu();
    }
    private static String leerOpcionMenu() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese una opción:");
        return scanner.next();
    }
    public static void ejecutarMenu() throws IOException {
        int aux=0;
        do {
            mostrarMenu();
            String opcion = leerOpcionMenu();
        switch (opcion) {
            case "1":
                System.out.println("Iniciando sesion...");
                System.out.println("Bienvenido pasajero");
                ejecutarConsultaUbicacion();
                aux=0;
                break;

            case "2":
                System.out.println("Iniciando sesion...");
                ingresarDatosUser();
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
    public static String[][] iniciarSesion() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Usuarios"));
            String[][] arr = new String[5][2];
            ArrayList<String> arr1;
            int i = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                arr1 = separarString(linea);
                for (int j = 0; j < arr1.size(); j++) {
                    arr[i][j] = arr1.get(j);

                }
                i++;
            }
        return arr;
    }
    public static void ingresarDatosUser() throws IOException {
        Scanner tecla = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario");
        String usuario = tecla.next();
        System.out.println("Ingrese la cotraseña");
        String contraseña = tecla.next();
        if(validarUser(usuario,contraseña)==true){
            System.out.println("Bienvenido conductor");
        }
        else{
            System.out.println("Usuario no registrado o contraseña erronea");
        }
    }
    public static boolean validarUser(String usuario, String contraseña) throws IOException {
        String[][] arr;
        arr = iniciarSesion();
        for(int i =0;i< arr.length;i++) {
            if (arr[i][0].equals(usuario) && arr[i][1].equals(contraseña)) {
                return true;
            }
        }
    return false;
    }
    public static ArrayList separarString(String linea){
        String palabra;
        ArrayList<String> arr = new ArrayList<>();
        int numTokens = 0;
        StringTokenizer st = new StringTokenizer (linea);
        while (st.hasMoreTokens())
        {
            palabra = st.nextToken();
            arr.add(palabra);
            numTokens++;
        }
        return arr;
    }

}