package dados;

public class Mensagem {
    public Mensagem(Carro carro) {
        this.carro = carro;
        this.pagamento = carro.getPagamento();
    }
    Carro carro;
    int pagamento;
    public Carro getCarro() {
        return carro;
    }

    @Override
    public String toString() {
        return carro.adesivo.getiD() + "#Mensagem{" +
                "pagamento=" + pagamento +
                "carro=" + carro +
                '}';
    }
}
