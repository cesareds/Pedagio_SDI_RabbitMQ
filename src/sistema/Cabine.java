package sistema;

import dados.Carro;
import dados.Fila;
import dados.Mensagem;
import dados.Provedor;

public class Cabine {
    public Cabine() {
    }
    public Cabine(Fila fila, int dinheiro) {
        this.fila = fila;
        this.dinheiro = dinheiro;
    }

    Fila fila = new Fila();
    private int dinheiro;

    public String receberResposta() {
        // sepa vai precisar mexer no rabbit.
        return "resposta";
    }
    public void liberarCarro() {
        // sepa vai precisar mexer no rabbit.
        this.dinheiro += fila.getMensagens().getFirst().getCarro().getPagamento();
        fila.getMensagens().removeFirst();
    }
    public void lancarCarro(String placa, String modelo, int eixos){
        Provedor adesivo = fila.getProvedor();
        int pagamento = adesivo.getTaxa() * eixos;
        Carro carro = new Carro(placa, modelo, pagamento, eixos, adesivo);
        Mensagem mensagem = new Mensagem(carro);
        fila.getMensagens().add(mensagem);
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public int getDinheiro() {
        return 0;
    }
    public void setDinheiro(int value) {
    }

    @Override
    public String toString() {
        return "Cabine{" +
                "fila=" + fila +
                ", dinheiro=" + dinheiro +
                '}';
    }
}
