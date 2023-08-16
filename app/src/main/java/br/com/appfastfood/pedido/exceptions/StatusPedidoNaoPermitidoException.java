package br.com.appfastfood.pedido.exceptions;

public class StatusPedidoNaoPermitidoException extends IllegalAccessError {
    public static String MESSAGER = "Status não permitido!";
    public StatusPedidoNaoPermitidoException() { super(MESSAGER); }
}
