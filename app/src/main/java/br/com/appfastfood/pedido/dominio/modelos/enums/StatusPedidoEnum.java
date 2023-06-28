package br.com.appfastfood.pedido.dominio.modelos.enums;

public enum StatusPedidoEnum {
    RECEBIDO(1, "recebido"),
    EM_PREPARACAO(2, "emPreparacao"),
    PRONTO(3, "pronto"),
    FINALIZADO(4, "finalizado");

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