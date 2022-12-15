import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void deveNotificarUmEmail() {
        Pedido pedidoTeste = new Pedido(789, "Pedido de exemplo");
        Email emailUm = new Email("emailUm@test.com.br");

        emailUm.registrar(pedidoTeste);

        pedidoTeste.atualizarPedido("Pagamento Aprovado");
        pedidoTeste.atualizarPedido("Em transporte");

        assertTrue(emailUm.getEnvios().contains("Pedido{numero=789, titulo=Pedido de exemplo, status atual='Pagamento Aprovado'}"));
        assertTrue(emailUm.getEnvios().contains("Pedido{numero=789, titulo=Pedido de exemplo, status atual='Em transporte'}"));
    }

    @Test
    void naoDeveNotificalEmail() {
        Pedido pedidoTeste = new Pedido(791, "Pedido de exemplo");
        Email emailUm = new Email("emailUm@test.com.br");

        pedidoTeste.atualizarPedido("Pagamento Aprovado");

        assertEquals("{}", emailUm.getEnvios());
    }

    @Test
    void deveNotificarEmailPedidoTesteUm() {
        Pedido pedidoTesteUm = new Pedido(789, "Pedido de exemplo um");
        Pedido pedidoTesteDois = new Pedido(790, "Pedido de exemplo dois");
        Email emailUm = new Email("emailUm@test.com.br");
        Email emailDois = new Email("emailDois@test.com.br");

        emailUm.registrar(pedidoTesteUm);
        emailDois.registrar(pedidoTesteDois);

        pedidoTesteUm.atualizarPedido("Pagamento Aprovado");
        pedidoTesteUm.atualizarPedido("Em transporte");

        assertTrue(emailUm.getEnvios().contains("Pedido{numero=789, titulo=Pedido de exemplo um, status atual='Pagamento Aprovado'}"));
        assertTrue(emailUm.getEnvios().contains("Pedido{numero=789, titulo=Pedido de exemplo um, status atual='Em transporte'}"));
    }

}