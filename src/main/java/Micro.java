public class Micro {

    private String patente;
    private String chofer;
    private String linea;

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Chofer getChofer() {
        throw new UnsupportedOperationException();
    }

    public void setChofer(Chofer chofer) {
        throw new UnsupportedOperationException();
    }

    public String getLinea() {
        return this.linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

}