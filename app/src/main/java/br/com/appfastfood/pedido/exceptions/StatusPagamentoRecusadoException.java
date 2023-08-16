package br.com.appfastfood.pedido.exceptions;

public class StatusPagamentoRecusadoException extends IllegalAccessError {
    public static String MESSAGER = "Pagamento recusado!";
    public StatusPagamentoRecusadoException() { super(MESSAGER); }
}
