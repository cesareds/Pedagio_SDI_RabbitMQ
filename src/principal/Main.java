package principal;

import dados.Carro;
import dados.Fila;
import dados.Mensagem;
import dados.Provedor;
import sistema.Cabine;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Main {
    public static void main(String[] args) throws IOException, TimeoutException {
        try {
            runMenu();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
    private static final Scanner scannerInt = new Scanner(System.in);
    private static final Scanner scannerString = new Scanner(System.in);
    private static final String QUEUE_NAME = "PEDAGIO";
    public static ArrayList<Cabine> cabines = new ArrayList<>();
    public static int dinheiroTotal;


    public static void connection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String msg = "Pedagio";
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + msg + "'");

            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }


    }
    public static void menu() {
        System.out.println("LC Pedágios à sua disposição!");
        System.out.println("1. Construir Cabine⛩️.\n2. Conectar🕴️.\n3. Lançar carro🚗.\n4. Começar fila👯‍♀️.\n5. Escrever mensagem📝.\n0. Sair😭");
    }
    public static void runMenu() throws IOException, TimeoutException {
        int i = 0;
        do{
            menu();
            i = scannerInt.nextInt();
            switch (i){
                case 1:
                    construirCabine();
                    break;
                case 2:
                    try {
                        connection();
                    } catch (IOException | TimeoutException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    lancarCarro();
                    break;
                case 4:
                    aumentaODinheiro();
                    break;
                case 0:
                    System.out.println("Boa Viagem👋");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
            
        }while(i>0);
    }
    public static void construirCabine(){
        Cabine cabine = new Cabine();
        Fila fila = comecarFila();
        cabine.setFila(fila);
        cabines.add(cabine);
    }
    public static Provedor abrirProvedor(){
        System.out.println("qual a taxa");
        int taxa = scannerInt.nextInt();
        System.out.println("qual o iD");
        String iD = scannerString.next();
        return new Provedor(taxa, iD);
    }
    public static void lancarCarro(){
        System.out.println("qual cabine");
        System.out.println(cabines.toString());
        int seatN = scannerInt.nextInt();
        System.out.println("quantos eixos");
        int eixos = scannerInt.nextInt();
        System.out.println("qual modelo");
        String modelo = scannerString.next();
        String placa = UUID.randomUUID().toString().substring(0, 7).toUpperCase();
        System.out.println("placa: " + placa);
        try {
            cabines.get(seatN).lancarCarro(placa, modelo, eixos);
            System.out.println("carro laçado!");
            System.out.println(cabines.get(seatN).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void escreverMensagem(Carro carro){
        Mensagem mensagem = new Mensagem();
        mensagem.setCarro(carro);
    }
    public static Fila comecarFila(){
        Provedor provedor = abrirProvedor();
        Fila fila = new Fila(new ArrayList<Mensagem>(), provedor);
        provedor.setFila(fila);
        return fila;
    }
    public static void aumentaODinheiro(){
        System.out.println("cabine vítima:");
        System.out.println(cabines.toString());
        int seatN = scannerInt.nextInt();
        cabines.get(seatN).liberarCarro();
        contaODinheiro();
        System.out.println("Dinheiro:\t" + dinheiroTotal);
    }
    public static void contaODinheiro(){
        int money = 0;
        for (int i = 0; i<cabines.size(); i++){
            money += cabines.get(i).getDinheiro();
        }
        dinheiroTotal = money;
    }

}
