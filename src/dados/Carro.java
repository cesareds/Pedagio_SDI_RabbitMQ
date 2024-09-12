package dados;

public class Carro {
    public Carro() {
    }
    public Carro(String placa, String modelo, int pagamento, int eixos, Provedor adesivo) {
        this.placa = placa;
        this.modelo = modelo;
        this.eixos = eixos;
        this.adesivo = adesivo;
        this.pagamento = pagamento;
    }
    private String placa;
    private String modelo;
    private int pagamento;
    private int eixos;
    Provedor adesivo = null;

    public int getPagamento() {
        return pagamento;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "eixos=" + eixos +
                '}';
    }
}
