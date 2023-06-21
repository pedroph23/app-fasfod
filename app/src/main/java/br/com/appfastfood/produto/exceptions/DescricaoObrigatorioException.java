package br.com.appfastfood.produto.exceptions;

public class DescricaoObrigatorioException extends IllegalAccessError {
    public static String MESSAGER = "Descrição é um campo obrigatório!";
    public DescricaoObrigatorioException() { super(MESSAGER); }
}
