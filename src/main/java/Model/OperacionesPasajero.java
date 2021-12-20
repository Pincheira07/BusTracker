package Model;

import Datos.GestorArchivos;
import GUIs.Mapa;
import Model.Micro;
import Model.MinisterioTransporte;

import java.util.ArrayList;
import java.util.Scanner;


public class OperacionesPasajero {
    private String ubicacion;

    public OperacionesPasajero(){
    }

    public void selecionarParadero() {
    }

    public void mostrarMicrosDiponibles(String ruta){
        MinisterioTransporte ministerioTransporte = new MinisterioTransporte();
        int i = 1;
        for (Micro micro:ministerioTransporte.getLineas().get(0).getMicros(ruta)) {
            if (micro.isActiva()){
                System.out.println("["+ i +"]"+" "+micro);
            }
            i++;
        }
    }

    public void seleccionarMicro(String ruta, int index) {
        MinisterioTransporte ministerioTransporte = new MinisterioTransporte();
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        do {
            String seleccion = teclado.next();
            switch (seleccion) {
                case "1" -> {
                    mostrarUbicacion(ministerioTransporte.getLineas().get(index).getMicros(ruta).get(0).getPatente());
                    break;
                }
                case "2" -> {
                    mostrarUbicacion(ministerioTransporte.getLineas().get(index).getMicros(ruta).get(1).getPatente());
                    break;
                }
                case "3" -> {
                    mostrarUbicacion(ministerioTransporte.getLineas().get(index).getMicros(ruta).get(2).getPatente());
                }
                case "0" -> aux = 1;
                default -> System.err.println("Opcion ingresada no valida");
            }
        }while (aux==0);
    }

    public void cambiarRecorrido() {
    }

    public void mostrar() {
    }

    public void ejecutarMenuUser(){
        Scanner teclado = new Scanner(System.in);
        int aux=0;
        do {
            mostrarMenu();
            String seleccion = teclado.next();
            switch (seleccion) {
                case "1" -> {
                    mostrarMicrosDiponibles("Lineas/Micros/MicrosLinea1.txt");
                    seleccionarMicro("Lineas/Micros/MicrosLinea1.txt",0);
                    break;
                }
                case "2" -> {
                    mostrarMicrosDiponibles("Lineas/Micros/MicrosLinea8.txt");
                    seleccionarMicro("Lineas/Micros/MicrosLinea8.txt",1);
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
        System.out.println("[1]Linea 1");
        System.out.println("[2]Linea 8");
        System.out.println("[0]Salir");
        System.out.println("***********************************************************");
    }

    public void mostrarUbicacion(String patente) {
        ejecutarConsultaUbicacion(patente);
    }
    private void ejecutarConsultaUbicacion(String patente){
        GestorArchivos ga = new GestorArchivos("Lineas/Choferes/movimiento "+patente+".csv");
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