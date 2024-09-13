package dados;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Fila {
    public Fila() {
    }
    public Fila(Provedor provedor) {
        this.provedor = provedor;
    }
    private BlockingQueue<Mensagem> mensagens = new LinkedBlockingQueue<>();
    private Provedor provedor;

    public BlockingQueue<Mensagem> getMensagens() {
        return mensagens;
    }
    public Provedor getProvedor() {
        return provedor;
    }
    @Override
    public String toString() {
        return "Fila{" +
                "mensagens=" + mensagens +
                "\tprovedor=" + provedor +
                "\n}";
    }
}
