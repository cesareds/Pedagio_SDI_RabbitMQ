package sistema;

import dados.Carro;
import dados.Fila;
import dados.Mensagem;
import dados.Provedor;

public class Cabine {
    public Cabine() {
    }

    Fila fila = new Fila();
    private int dinheiro = 0;

    public Mensagem liberarCarro() {
        this.dinheiro += fila.getMensagens().getFirst().getCarro().getPagamento();
        Mensagem mensagem = fila.getMensagens().getFirst();
        fila.getMensagens().removeFirst();
        return mensagem;
    }
    public void lancarCarro(String placa, String modelo, char sticker, int eixos){
        Provedor adesivo = fila.getProvedor();
        int pagamento;
        if( sticker == 'n'){
            pagamento = adesivo.getTaxa() * eixos * 2; //QUEM NAO TEM ADESIVO PAGA 2X
        }else{
            pagamento = adesivo.getTaxa() * eixos;
        }
        System.out.println(adesivo.getTaxa());
        Carro carro = new Carro(placa, modelo, pagamento, eixos, adesivo);
        Mensagem mensagem = new Mensagem(carro);
        fila.getMensagens().add(mensagem);
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    @Override
    public String toString() {
        return "Cabine{" +
                "fila=" + fila +
                ", dinheiro=" + dinheiro +
                '}';
    }
}
