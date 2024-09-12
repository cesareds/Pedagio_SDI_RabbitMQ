package dados;

public class Provedor {
    public Provedor() {
    }
    public Provedor(int taxa, String iD, Fila fila) {
        this.taxa = taxa;
        this.iD = iD;
        this.fila = fila;
    }
    public Provedor(int taxa, String iD) {
        this.taxa = taxa;
        this.iD = iD;
    }

    private int taxa;
    private String iD;
    Fila fila = new Fila();


    public int getTaxa() {
        return 0;
    }
    public void setTaxa(int value) {
    }
    public String getID() {
        return "";
    }
    public void setID(String value) {
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    @Override
    public String toString() {
        return "Provedor{" +
                "iD='" + iD + '\'' +
                ", taxa=" + taxa +
                '}';
    }
}
