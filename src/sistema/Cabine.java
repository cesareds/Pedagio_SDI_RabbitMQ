package sistema;

import dados.Carro;
import dados.Fila;
import dados.Mensagem;
import dados.Provedor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Cabine implements Runnable{
    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("marcas-e-modelos/marcas-carros.csv"))){
            String l;
            bufferedReader.readLine();
            while ((l=bufferedReader.readLine())!=null){
                String[] brands = l.split(";");
                todos_os_modelos_de_carros_possiveis.add(brands[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            while (true) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000)); // 1 a 5 segundos
                String placa = UUID.randomUUID().toString().substring(0, 7).toUpperCase();
                String modelo = todos_os_modelos_de_carros_possiveis.getFirst();
                todos_os_modelos_de_carros_possiveis.removeFirst();
                // Gerar um carro aleatório
                lancarCarro(placa, "ModeloX", 'n', ThreadLocalRandom.current().nextInt(2, 5));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Cabine() {

    }
    Fila fila = new Fila();
    private int dinheiro = 0;
    private ArrayList<String> todos_os_modelos_de_carros_possiveis = new ArrayList<>();

    public Mensagem liberarCarro() throws InterruptedException {
        Mensagem mensagem = null;
        try {
            mensagem = fila.getMensagens().take();
            this.dinheiro += mensagem.getCarro().getPagamento();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mensagem;
    }
    public void lancarCarro(String placa, String modelo, char sticker, int eixos){
        Provedor adesivo = fila.getProvedor();
        int pagamento = (sticker == 's') ? adesivo.getTaxa() * eixos : adesivo.getTaxa() * eixos * 2; //SEM ADESIVO PAGA 2X
        Carro carro = new Carro(placa, modelo, pagamento, eixos, adesivo);
        Mensagem mensagem = new Mensagem(carro);
        fila.getMensagens().add(mensagem);
    }
    public void gerador(){

    }
    public void setFila(Fila fila) {
        this.fila = fila;
    }
    public int getDinheiro() {
        return dinheiro;
    }
    @Override
    public String toString() {
        return "\nCabine{" +
                "fila=" + fila +
                '}';
    }
}
