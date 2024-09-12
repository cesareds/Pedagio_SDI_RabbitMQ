package dados;

import java.util.ArrayList;

public class Fila {
    public Fila() {
    }
    public Fila(ArrayList<Mensagem> mensagens, Provedor provedor) {
        this.mensagens = mensagens;
        this.provedor = provedor;
    }
    private ArrayList<Mensagem> mensagens = new ArrayList<>();
    private Provedor provedor;

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }
    public Provedor getProvedor() {
        return provedor;
    }
    @Override
    public String toString() {
        return "Fila{" +
                "mensagens=" + mensagens +
                ", provedor=" + provedor +
                '}';
    }
}
