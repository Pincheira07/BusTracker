import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Linea implements Serializable{

    private String numero;
    private List<String> recorridos;
    private ArrayList<Chofer> choferes = new ArrayList<>();
    private ArrayList<Micro> micros = new ArrayList<>();



    public Linea(String numero, List<String> letras) {
        this.numero = numero;
        this.recorridos = letras;
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

    public void serializarChoferes(String ruta) {
        try
        {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.choferes);
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
        return this.micros;
    }

    public ArrayList<Chofer> deserializarChoferes(String ruta){
        try
        {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.choferes = (ArrayList) ois.readObject();
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
        return this.choferes;
    }


    public String getNumero() {
        return this.numero;
    }



    public List<String> getRecorridoss() {
        return recorridos;
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