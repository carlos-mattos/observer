import java.util.Observable;

public class Pedido extends Observable {

    private Integer numero;
    private String titulo;
    private String status;

    public Pedido(Integer numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
    }

    public void atualizarPedido(String status) {
        this.status = status;
        setChanged();
        notifyObservers();
    }

    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", titulo=" + titulo +
                ", status atual='" + status + '\'' +
                '}';
    }
}
