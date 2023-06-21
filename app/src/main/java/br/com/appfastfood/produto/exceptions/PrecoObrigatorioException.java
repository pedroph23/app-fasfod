package br.com.appfastfood.produto.exceptions;

public class PrecoObrigatorioException extends IllegalAccessError {

    public static String MESSAGER = "Preço é um campo obrigatório";
    public PrecoObrigatorioException() {
        super(MESSAGER);
    }
}
