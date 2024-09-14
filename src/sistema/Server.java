package sistema;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Server {
    private final static String QUEUE_NAME = "PEDAGIO";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);

                System.out.println(" [x] Received '" + message + "'");
                String[] msgSPLIcED = message.split("#");
                try {
                    connection_v2(msgSPLIcED[1], msgSPLIcED[0]);
                } catch (TimeoutException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
    public static void connection_v2(String mensagem, String queueName) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(queueName, false, false, false, null);
            channel.basicPublish("", queueName, null, mensagem.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mensagem + "'");

            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
