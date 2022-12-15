import java.util.Observable;
import java.util.Observer;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;


public class Email implements Observer {

    private String enderecoEmail;
    private HashMap<String, String> envios = new HashMap<String, String>();;

    public Email(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getEnvios() {

        return envios.keySet().stream()
                .map(key -> key + "=" + envios.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }

    public void registrar(Pedido pedido) {
        pedido.addObserver(this);
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void update(Observable pedido, Object arg1) {
        String id = UUID.randomUUID() + "-" + LocalDateTime.now();
        this.envios.put(id, pedido.toString());
    }
}
