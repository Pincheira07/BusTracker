import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Inicio inicio = new Inicio();
        //inicio.ejecutarMenu();

        MinisterioTransporte ministerioTransporte = new MinisterioTransporte();
        System.out.print(ministerioTransporte.getLineas().toString());



}
}