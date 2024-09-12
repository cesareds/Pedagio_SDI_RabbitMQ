package dados;

public class Mensagem {
    public Mensagem() {
    }
    public Mensagem(Carro carro) {
        this.carro = carro;
    }
    Carro carro = new Carro();

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
