import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Chofer {
    private String nombre;
    private String contraseña;
    private String ubicacion;

    public Chofer() {
        }

    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    /**
     *
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    /**
     *
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void seleccionarLinea() {
        // TODO - implement Chofer.seleccionarLinea
        throw new UnsupportedOperationException();
    }

    public void iniciarRecorrido() {
        // TODO - implement Chofer.iniciarRecorrido
        throw new UnsupportedOperationException();
    }

    public void opcionesRecorrido() {
        // TODO - implement Chofer.opcionesRecorrido
        throw new UnsupportedOperationException();
    }

    public void configuracionRecorrido() {
        // TODO - implement Chofer.configuracionRecorrido
        throw new UnsupportedOperationException();
    }

    public void menu() {
        // TODO - implement Chofer.menu
        throw new UnsupportedOperationException();
    }

    public void mostrar() {
        // TODO - implement Chofer.mostrar
        throw new UnsupportedOperationException();
    }

    public void ingresarDatosUser() throws IOException {
        Scanner tecla = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario");
        this.nombre = tecla.next();
        System.out.println("Ingrese la cotraseña");
        this.contraseña = tecla.next();
        if(validarUser(this.nombre, this.contraseña)){
            System.out.println("Bienvenido conductor");

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
