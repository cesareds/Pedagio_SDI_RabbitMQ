package dados;

public class Carro {
    public Carro() {
    }
    public Carro(String placa, String modelo, int pagamento, int eixos, Provedor adesivo) {
        this.adesivo = adesivo;
    }
    private int pagamento;
    Provedor adesivo = new Provedor();

    public int getPagamento() {
        return pagamento;
    }
}
