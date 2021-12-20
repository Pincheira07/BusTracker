import Datos.GestorArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Chofer implements Serializable {
    private String nombre;
    private String contraseña;
    private String ubicacion;
    private Linea linea;
    private Micro micro;

    public Chofer(String nombre, String contraseña, Linea linea) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.linea = linea;
    }

    public Chofer() {
    }

    public void registrarseEnLinea(){

    }
    public String getNombre() {
        return this.nombre;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void seleccionarLinea(){ //"-38.738135418759, -72.59066435334556"
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        do {
            mostrarMenu();
            String seleccion = teclado.next();
            switch (seleccion) {
                case "1" -> {
                    compartirUbicacion("Linea1A");
                    break;
                }
                case "2" -> {
                    compartirUbicacion("Linea8C");
                    break;
                }
                case "0" -> aux = 1;
                default -> System.err.println("Opcion ingresada no valida");
            }
        }while (aux==0);
    }

    private void mostrarMenu(){
        System.out.println("***********************************************************");
        System.out.println("------------------Seleccione una linea---------------------");
        System.out.println("*                         MENÚ                            *");
        System.out.println("[1]Linea1A");
        System.out.println("[2]Linea8C");
        System.out.println("[0]Salir");
        System.out.println("***********************************************************");
    }

    public void iniciarRecorrido() {
        compartirUbicacion("Linea1A");
    }

    public void opcionesRecorrido() {
    }

    public void configuracionRecorrido() {
    }

    public void compartirUbicacion(String linea){
        GestorArchivos ga = new GestorArchivos("Lineas/"+linea +".csv");
        entregarCoordenadas(ga.leerArchivo(),linea);
    }

    private void entregarCoordenadas(ArrayList<String> arr,String linea){
        /*
         * Crea un array de strings para la linea actual y lo divide en latitud y longitud, luego,
         * llama al metodo "escribirCoordenadas
         * */
        String[] coordendas;

        for (int i = 0; i < arr.size(); i++) {
            try {
                System.out.println("compartiendo");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            coordendas = arr.get(i).split(",");
            escribirCoordenadas(coordendas[0], coordendas[1],linea);
        }
    }

    private void escribirCoordenadas(String latitud, String longitud,String linea){
        /*
         * Escribe la linea proporcionada por "entregarCoordenadas" en un nuevo archivo llamado "movimiento.csv"
         * que cuenta con una sola linea que se va actualizando a medida que se recibe una nueva coordenada
         * */
        try {
            List<List<String>> rows = Collections.singletonList(Arrays.asList(latitud, longitud));
            FileWriter csvWriter = new FileWriter("movimiento"+linea+".csv");
            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ingresarDatosUser(){
        Scanner tecla = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario");
        this.nombre = tecla.next();
        System.out.println("Ingrese la cotraseña");
        this.contraseña = tecla.next();
        if(validarUser(this.nombre, this.contraseña)){
            System.out.println("Bienvenido conductor");
            seleccionarLinea();
            }
        else{
            System.out.println("Usuario no registrado o contraseña erronea");
        }
    }

    private boolean validarUser(String usuario, String contraseña){
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

    private String[][] leerUsuario(){
        Encriptador encriptador = new Encriptador();
        ArrayList<String> usuarios = new ArrayList<>();
        usuarios = encriptador.descifrarArchivo(10);
        int n = usuarios.size();
            String[][] arr = new String[n][2];
            ArrayList<String> arr1;
            String linea;
            for (int i = 0; i<usuarios.size();i++){
                linea = usuarios.get(i);
                arr1 = separarString(linea);
                for (int j = 0; j < arr1.size(); j++) {
                    arr[i][j] = arr1.get(j);
                }
            }
            return arr;
    }

    private ArrayList<String> separarString(String linea){
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
