package br.com.appfastfood.produto.exceptions;

public class NomeObrigatorioException extends IllegalAccessError {
    public static String MESSAGER = "Nome é um campo obrigatório!";
    public NomeObrigatorioException() {
        super(MESSAGER);
    }
}
