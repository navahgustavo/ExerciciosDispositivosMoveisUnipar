package com.example.appvendas.modelo;

public class Produto {

    private static int contadorCodigo = 0;
    private int codigo;
    private String descricao;
    private double valor;

    public Produto() {
        contadorCodigo++;
        this.codigo = contadorCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
