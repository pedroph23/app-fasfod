package br.com.appfastfood.produto.exceptions;

public class CategoriaObrigatorioException extends IllegalAccessError {
    public static String MESSAGER = "Categoria é um campo obrigatório!";
    public CategoriaObrigatorioException() { super(MESSAGER); }
}
