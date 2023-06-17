package br.com.appfastfood.pedido.dominio.modelos.enums;

public enum StatusPedidoEnum {
    recebido("recebido"),
    emPreparacao("emPreparacao"),
    pronto("pronto"),
    finalizado("finalizado");

    private String nome;

    StatusPedidoEnum(String nome){
        this.nome = nome;
    }

    public String getNomeStatus(){
        return this.nome;
    }
}