package br.com.appfastfood.pedido.dominio.modelos.enums;

import br.com.appfastfood.pedido.exceptions.StatusPagamentoNaoEncontrado;

public enum StatusPagamentoEnum {
    PENDENTE(1, "PENDENTE"),
    APROVADO(2, "APROVADO"),
    RECUSADO(3, "RECUSADO");

    private final int id;
    private final String nome;

    StatusPagamentoEnum(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static StatusPagamentoEnum buscaEnumPorStatusString(String nome) {
        for (StatusPagamentoEnum status : values()) {
            if (status.getNome().equalsIgnoreCase(nome)){
                return status;
            }
        }
        throw new StatusPagamentoNaoEncontrado();
    }

    public static String retornaNomeStatusPagamentoEnum(StatusPagamentoEnum status){
        for (StatusPagamentoEnum statusEnum : values()) {
            if (statusEnum == status) {
                return statusEnum.getNome();
            }
        }
        throw new StatusPagamentoNaoEncontrado();
    }
}
