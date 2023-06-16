package br.com.appfastfood.cliente.exceptions;

public class FormatoEmailException extends IllegalAccessError {
    public static String MESSAGER = "Formato e-mail inválido!";

    public FormatoEmailException() { super(MESSAGER); }

}
