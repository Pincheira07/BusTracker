package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinisterioTransporte {
    private List<Linea> lineas = new ArrayList<>();


    public MinisterioTransporte() {
        añadirLineas();
    }

    public void añadirLineas() {
        this.lineas.add(new Linea("1",Arrays.asList("A","B","C","D")));
        this.lineas.add(new Linea("2",Arrays.asList("A","B","C","D")));
        this.lineas.add(new Linea("3",Arrays.asList("A","B","C","D")));
        this.lineas.add(new Linea("4",Arrays.asList("A","B")));
        this.lineas.add(new Linea("5",Arrays.asList("A","B","C")));
        this.lineas.add(new Linea("6",Arrays.asList("A","B","C")));
        this.lineas.add(new Linea("7",Arrays.asList("A","B")));
        this.lineas.add(new Linea("8",Arrays.asList("A","B","C","D","E")));
        this.lineas.add(new Linea("9",Arrays.asList("A","B","C","D")));
        this.lineas.add(new Linea("10",Arrays.asList("A","B","C")));
        this.lineas.add(new Linea("66",Arrays.asList("A")));
    }

    public List<Linea> getLineas() {
        return lineas;
    }
}
