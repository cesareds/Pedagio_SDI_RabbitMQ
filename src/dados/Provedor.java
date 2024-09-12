package dados;

public class Provedor {
    public Provedor(int taxa, String iD) {
        this.taxa = taxa;
        this.iD = iD;
    }

    private int taxa;
    private String iD;
    Fila fila = new Fila();


    public int getTaxa() {
        return taxa;
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
