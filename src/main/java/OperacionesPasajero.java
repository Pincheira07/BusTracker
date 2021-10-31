import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperacionesPasajero {
    public OperacionesPasajero(){

    }

    public void selecionarParadero() {

    }

    public void seleccionarMicro() {

    }

    public void cambiarRecorrido() {

    }

    public void mostrar() {

    }

    public void menu() {

    }

    public void mostrarUbicacion() {
        ejecutarConsultaUbicacion();
    }
    private void ejecutarConsultaUbicacion(){
        GestorArchivos ga = new GestorArchivos("movimiento.csv");
        mostrarUbicacion(ga.leerArchivo());
    }
    private void mostrarUbicacion(ArrayList<String> arrayList){
        String[] coordendas;
        for (int i = 0; i < arrayList.size();i++) {
            coordendas = arrayList.get(0).split(",");
            System.out.println("Latitud: " + coordendas[0] + " Longitud: " + coordendas[1]);
        }
    }

}