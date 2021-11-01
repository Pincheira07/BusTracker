import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GestorArchivos {
    private String ruta;

    public GestorArchivos(String ruta) {
        this.ruta = ruta;
    }

    public ArrayList<String> leerArchivo() {
        /*
         * Lee el archivo y añade cada linea a un arraylist
         */
        File file = new File(this.ruta);
        ArrayList<String> arr = new ArrayList<>();
        Scanner input = null;
        try {
            input = new Scanner(file);
            while (input.hasNextLine()) {
                arr.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay recorridos disponibles");
            ;
        }
        return arr;
    }
}