package br.com.appfastfood.produto.exceptions;

public class IDNaoEncontradoException extends IllegalAccessError {
    public static String MESSAGER = "Identificação não encontrada!";
    public IDNaoEncontradoException() { super(MESSAGER); }
}
