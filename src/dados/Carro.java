package dados;

public class Carro {
    public Carro() {
    }
    public Carro(String placa, String modelo, int pagamento, int eixos, Provedor adesivo) {
        this.eixos = eixos;
        this.adesivo = adesivo;
    }
    private int pagamento;
    private int eixos;
    Provedor adesivo = new Provedor();

    public int getPagamento() {
        return eixos;
    }
}
