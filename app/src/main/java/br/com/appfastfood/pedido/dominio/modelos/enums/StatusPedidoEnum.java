package br.com.appfastfood.pedido.dominio.modelos.enums;

public enum StatusPedidoEnum {
    RECEBIDO(1, "RECEBIDO"),
    EM_PREPARACAO(2, "EM_PREPARACAO"),
    PRONTO(3, "PRONTO"),
    FINALIZADO(4, "FINALIZADO");

    private final int id;
    private final String nome;

    StatusPedidoEnum(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static StatusPedidoEnum buscaEnumPorStatusString(String nome) {
        for (StatusPedidoEnum status : values()) {
            if (status.getNome().toUpperCase() == nome.toUpperCase()) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status Iválido: " + nome);
    }
}