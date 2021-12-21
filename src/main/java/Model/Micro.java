package Model;

import java.io.Serializable;

public class Micro implements Serializable{

    private String patente;
    private boolean isDisponible;
    private Linea Linea;
    private boolean isActiva;
    private Chofer chofer;
    static final long serialVersionUID = 42L;


    public Micro(String patente, Linea linea) {
        this.patente = patente;
        Linea = linea;
        this.isDisponible = true;
        this.isActiva = false;

    }



    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }


    public Linea getLinea() {
        return Linea;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public boolean isActiva() {
        return isActiva;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    @Override
    public String toString() {
        return "patente:'" + patente + '\'' +
                ", isDisponible:" + isDisponible +
                ", isActiva:" + isActiva +
                '}'+'\n';
    }
}