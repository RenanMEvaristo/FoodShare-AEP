package model;

import java.time.LocalDate;

public class Doacao {

    private int id;
    private int idDoador;
    private String descricao;
    private String categoria; // perecivel ou não perecível
    private double quantidade;
    private LocalDate validade;
    private String status; // status da doaçao, disponivel, em_transito, finalizada, cancelada

    public Doacao() {

    }

    public Doacao(int id, int idDoador, String descricao, String categoria, double quantidade, LocalDate validade,
            String status) {
        this.id = id;
        this.idDoador = idDoador;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.validade = validade;
        this.status = status;
    }

    // construtor sem ID para novos cadastrados

    public Doacao(int idDoador, String descricao, String categoria, double quantidade, LocalDate validade,
            String status) {
        this.idDoador = idDoador;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.validade = validade;
        this.status = status;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
