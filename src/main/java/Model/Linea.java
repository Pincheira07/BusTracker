package Model;

import Model.Chofer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Linea implements Serializable{

    private String numero;
    private ArrayList<Micro> micros = new ArrayList<>();



    public Linea(String numero) {
        this.numero = numero;
    }

    public Micro agregarMicro(String patente ){
        Micro micro = new Micro(patente, this);
        this.micros.add(micro);
        return micro;
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
        return this.micros;
    }




    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ArrayList<Micro> getMicros(String ruta) {
        return this.micros = deserializarMicros(ruta);
    }

    public ArrayList<Micro> getMicrosTest() {
        return micros;
    }

    @Override
    public String toString() {
        return "[" + "Linea " + numero + "]" + "";
    }
}