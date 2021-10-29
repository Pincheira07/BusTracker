import java.io.*;
import java.util.*;

public class BusTracker{
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

    public static void mostrarMenu(){
        System.out.println("***********************************************************");
        System.out.println("-----------------------BusTracker--------------------------");
        System.out.println("*                       MENÚ                              *");
        System.out.println("[1]Pasajero");
        System.out.println("[2]Conductor");
        System.out.println("[0]Salir");
        System.out.println("***********************************************************");
    }

    public static void ejecutarMenu() throws IOException {
        int aux=0;
        do {
            mostrarMenu();
            String opcion = leerOpcionMenu();
            switch (opcion) {
                case "1" -> {
                    System.out.println("Iniciando sesion...");
                    System.out.println("Bienvenido pasajero");
                    arranquePasajero();
                }
                case "2" -> {
                    System.out.println("Iniciando sesion...");
                    ingresarDatosUser();
                }
                case "0" -> aux = 1;
                default -> System.err.println("Opcion ingresada no valida");
            }
        }while (aux==0);

    }

    public static void ejecutarConsultaUbicacion(){
            mostrarUbicacion(leerArchivo("movimiento.csv"));
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

    public static ArrayList<String> leerArchivo(String ruta){
        /*
         * Lee el archivo y añade cada linea a un arraylist
         */
        File file = new File(ruta);
        ArrayList<String> arr = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(file);
            while (input.hasNextLine()) {
                arr.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay recorridos disponibles");;
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


    public static boolean validarUser(String usuario, String contraseña){
        String[][] arr;
        arr = leerUsuario();
        assert arr != null;
        for (String[] strings : arr) {
            if (strings[0].equals(usuario) && strings[1].equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public static void menudeLineasDisponibles() {
        System.out.println(".........{Lineas Disponibles }........");
        System.out.println("[1] Linea 1");
        System.out.println("[2] Linea 2");
        System.out.println("[3] VOLVER ATRAS");

    }

    public static int selecionOpciones(int menu) {
        int opcion = 0;
        int cantOP= cantidadOpcionesMenuPrincipal();
        do {
            try {
                definirElMenuMostrar(menu);
                opcion = pedirDatoNumerico();
                if (opcion <= 0 || opcion >= cantOP + 1) {
                    System.out.println("No existe esa opcion");
                    System.out.println("Selecione una correcta");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("No es una exprecion numerica");
                System.out.println("Por favor intentelo denuevo");
            }

        } while (opcion <= 0 || opcion >= cantOP + 1);

        return opcion;

    }
    public static int cantidadOpcionesMenuPrincipal(){
        return 3;
    }

    public static int validarRangodeNumero(int numero1) {
        if (numero1 < 0) {
            System.out.println("No se admiten numeros negativos");
        } else if (numero1 > 100) {  // recordar definir un limite
            System.out.println("No se admiten numeros mayores a 100");
            numero1 = -1;

        }
        return numero1;
    }
    public static int pedirDatoNumerico() {
        Scanner teclado = new Scanner(System.in);
        System.out.println(".......[INGRESE UNA ENTRADA VALIDA]......");
        return  teclado.nextInt();
    }

    public static void definirElMenuMostrar(int menu){
        if (menu == 1) {
            menudeLineasDisponibles();
        }
    }
    public static void arranqueConductor() throws IOException {
        int nivel=4;
        do {
            nivel=definirLinea(nivel);
            if (nivel>6){
                nivel=3;
            }
        }while(nivel != 3);
    }
    public static void arranquePasajero() throws IOException {
        int nivel=1;
        do {
            nivel=definirLineaPasajero(nivel);
            if (nivel>3){
                nivel=0;
            }
        }while(nivel != 0);
    }

    public static int definirLinea(int menu) throws IOException {
        menudeLineasDisponibles();
        switch (selecionOpciones(menu)) {
            case 1 -> {
                System.out.println("Compartiendo Ubicacion");
                compartirUbicacion();
                break;
            }
            case 2-> {
                System.out.println("Proximamente");
                break;
            }
            case 3 -> {
                menu -=1;
                break;
            }
        }
        return menu;
    }

    public static int definirLineaPasajero(int menu) throws IOException {
        switch (selecionOpciones(menu)) {
            case 1 -> {
                ejecutarConsultaUbicacion();
            }
            case 2-> {
                System.out.println("Proximamente");
            }
            case 3 -> {
                menu -=1;
                break;
            }
        }
        return menu;
    }
    public static void ingresarDatosUser() throws IOException {
        Scanner tecla = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario");
        String usuario = tecla.next();
        System.out.println("Ingrese la cotraseña");
        String contraseña = tecla.next();
        if(validarUser(usuario, contraseña)){
            System.out.println("Bienvenido conductor");
            arranqueConductor();
            compartirUbicacion();
        }
        else{
            System.out.println("Usuario no registrado o contraseña erronea");
        }
    }

    public static String[][] leerUsuario(){
        try {
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
        }catch (IOException e){
            System.err.println("Archivo no encontrado");
            return null;
        }
    }

    public static ArrayList<String> separarString(String linea){
        String palabra;
        ArrayList<String> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer (linea);
        while (st.hasMoreTokens())
        {
            palabra = st.nextToken();
            arr.add(palabra);
        }
        return arr;
    }

}