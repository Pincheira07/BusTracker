package Model;

import Datos.GestorArchivos;
import GUIs.SignIn;

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
    private SignIn sn;

    public Chofer(String nombre, String contraseña, Linea linea) {
        this.nombre = nombre;
        this.contraseña = contraseña;

    }

    public Chofer() {
    }

    public void menuSeleccionarMicro(String ruta){
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        do {
            String seleccion = teclado.next();
            switch (seleccion) {
                case "1" -> {
                    seleccionarMicro(ruta, 0);
                    iniciarRecorrido();
                    break;
                }
                case "2" -> {
                    seleccionarMicro(ruta,1);
                    iniciarRecorrido();
                    break;
                }
                case "3" -> {
                    seleccionarMicro(ruta,2);
                    iniciarRecorrido();
                }
                case "0" -> aux = 1;
                default -> System.err.println("Opcion ingresada no valida");
            }
        }while (aux==0);

    }

    public int seleccionarMicro(String ruta, int index){
        int aux = 1;
        if (validarDisponibilidadMicro(ruta, index)){
            this.micro = linea.getMicros(ruta).get(0);
            micro.setDisponible(false);
            micro.setActiva(true);
            linea.serializarMicros(ruta);
        }else{
            System.out.println("Micro no disponible");
            aux = 0;
        }
        return aux;
    }

    public boolean validarDisponibilidadMicro(String ruta, int index){
        return this.linea.getMicros(ruta).get(index).isDisponible();
    }



    public void mostrarMicros(Linea linea, String ruta){
        int i = 1;
        for (Micro micro:linea.getMicros(ruta)) {
            System.out.println("["+ i +"]"+" "+micro);
            i++;
        }
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

    public void seleccionarLinea(){
        MinisterioTransporte ministerioTransporte = new MinisterioTransporte();
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        do {
            mostrarMenu();
            String seleccion = teclado.next();
            switch (seleccion) {
                case "1" -> {
                    this.linea=ministerioTransporte.getLineas().get(0);
                    mostrarMicros(this.linea, "Lineas/Micros/MicrosLinea1.txt");
                    menuSeleccionarMicro("Lineas/Micros/MicrosLinea1.txt");
                    break;
                }
                case "2" -> {
                    this.linea=ministerioTransporte.getLineas().get(7);
                    mostrarMicros(this.linea, "Lineas/Micros/MicrosLinea8.txt");
                    menuSeleccionarMicro("Lineas/Micros/MicrosLinea8.txt");
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
        System.out.println("[1]Linea1");
        System.out.println("[2]Linea8");
        System.out.println("[0]Salir");
        System.out.println("***********************************************************");
    }

    public void iniciarRecorrido() {
        compartirUbicacion();

    }

    public void opcionesRecorrido() {
    }

    public void configuracionRecorrido() {
    }

    public void compartirUbicacion(){
        GestorArchivos ga = new GestorArchivos("Lineas/Linea"+this.linea.getNumero()+".csv");
        entregarCoordenadas(ga.leerArchivo());
    }

    private void entregarCoordenadas(ArrayList<String> arr){
        /*
         * Crea un array de strings para la linea actual y lo divide en latitud y longitud, luego,
         * llama al metodo "escribirCoordenadas
         * */
        String[] coordendas;
        System.out.println("compartiendo ubicacion...");
        for (int i = 0; i < arr.size(); i++) {
            try {
                Thread.sleep(3750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            coordendas = arr.get(i).split(",");
            escribirCoordenadas(coordendas[0], coordendas[1]);
        }
    }

    private void escribirCoordenadas(String latitud, String longitud){
        /*
         * Escribe la linea proporcionada por "entregarCoordenadas" en un nuevo archivo llamado "movimiento.csv"
         * que cuenta con una sola linea que se va actualizando a medida que se recibe una nueva coordenada
         * */
        try {
            List<List<String>> rows = Collections.singletonList(Arrays.asList(latitud, longitud));
            FileWriter csvWriter = new FileWriter("Lineas/Choferes/movimiento "+this.micro.getPatente()+".csv");
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
        if(validarUser(this.nombre, this.contraseña)){
            sn.setVisible(true);
            }
        else{
            sn.mensajeError();
        }
    }

    public boolean validarUser(String usuario, String contraseña){
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
