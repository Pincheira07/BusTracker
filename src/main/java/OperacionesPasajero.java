import Datos.GestorArchivos;
import GUIs.Mapa;

import java.util.ArrayList;
import java.util.Scanner;


public class OperacionesPasajero {
    private String ubicacion;

    public OperacionesPasajero(){
    }

    public void selecionarParadero() {
    }

    public void mostrarMicrosDiponibles(){
        MinisterioTransporte ministerioTransporte = new MinisterioTransporte();
        int i = 1;
        for (Micro micro:ministerioTransporte.getLineas().get(0).getMicros("Lineas/Micros/MicrosLinea1.txt")) {
            if (!micro.isActiva()){
                System.out.println("["+ i +"]"+" "+micro);
            }
            i++;
        }
    }

    public void seleccionarMicro() {
    }

    public void cambiarRecorrido() {
    }

    public void mostrar() {
    }

    public void ejecutarMenuUser(){ //"-38.738135418759, -72.59066435334556"
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        do {
            mostrarMenu();
            String seleccion = teclado.next();
            switch (seleccion) {
                case "1" -> {
                    mostrarUbicacion("Linea1A");
                    //mostrarMicrosDiponibles();
                    break;
                }
                case "2" -> {
                    mostrarUbicacion("Linea8C");
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

    public void mostrarUbicacion(String linea) {
        ejecutarConsultaUbicacion(linea);
    }
    private void ejecutarConsultaUbicacion(String linea){
        GestorArchivos ga = new GestorArchivos("movimiento"+linea+".csv");
        mostrarUbicacion(ga.leerArchivo());
    }
    private void mostrarUbicacion(ArrayList<String> arrayList){
        String[] coordendas;
        for (int i = 0; i < arrayList.size();i++) {
            coordendas = arrayList.get(0).split(",");
            Mapa mapa = new Mapa(coordendas[0],coordendas[1]);
        }
    }

}