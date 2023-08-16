package br.com.appfastfood.pedido.exceptions;

public class StatusPagamentoNaoEncontrado extends IllegalAccessError {
    public static String MESSAGER = "O status de pagamento informado não existe.";
    public StatusPagamentoNaoEncontrado() { super(MESSAGER); }
}
