import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Linea implements Serializable{

    private String numero;
    private List<String> letras;
    private List<Chofer> choferes;
    private ArrayList<Micro> micros = new ArrayList<>();
    static final long serialVersionUID = 42L;


    public Linea(String numero, List<String> letras) {
        this.numero = numero;
        this.letras = letras;
    }

    public Micro agregarMicro(String patente ){
        Micro micro = new Micro(patente, this);
        this.micros.add(micro);
        return micro;
    }

    public Chofer agregarChofer(String nombre, String contraseña ){
        Chofer chofer = new Chofer(nombre,contraseña,this);
        this.choferes.add(chofer);
        return chofer;
    }

    public void serializarMicros(String ruta) {
        try
        {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.micros);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public ArrayList<Micro> deserializarMicros(String ruta){

        try
        {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.micros = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();

        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Clase no encontrada");
            c.printStackTrace();

        }

        //Devuelvo la biblioteca
        return this.micros;
    }



    public void mostrarMicros(String ruta){
        for (Micro micro : deserializarMicros(ruta)) {
            System.out.println(micro);
        }
    }

    public String getNumero() {
        return this.numero;
    }



    public List<String> getLetras() {
        return letras;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Micro> getMicros(String ruta) {
        return this.micros = deserializarMicros(ruta);
    }

    @Override
    public String toString() {
        return "[" + "Linea " + numero + "]" + "";
    }
}