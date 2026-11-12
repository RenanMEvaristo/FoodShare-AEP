package model;

import java.util.ArrayList;
import java.util.List;

public class Doador extends Usuario implements Notificavel {

    private String cnpj;
    private String nomeFantasia;

    private List<Doacao> listaDoacoes;

    public Doador() {

        super();
        this.listaDoacoes = new ArrayList<>();

    }

    public Doador(int id, String nome, String endereco, String telefone, String email, String cnpj,
            String nomeFantasia) {

        super(id, nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.listaDoacoes = new ArrayList<>();

    }

    public Doador(String nome, String endereco, String telefone, String email, String cnpj, String nomeFantasia) {

        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.listaDoacoes = new ArrayList<>();

    }

    @Override
    public void gerarAlerta() {

        System.out.println("ALERTA DOADOR " + this.nomeFantasia + ": Coleta confirmada! Prepare os itens!");

    }

    @Override
    public void exibirPerfil() {

        System.out.println("--- Perfil do Doador ---");
        System.out.println("ID: " + this.id);
        System.out.println("Razao Social: " + this.nome);
        System.out.println("Nome Fantasia: " + this.nomeFantasia);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Email: " + this.email);

    }

    public void cadastrarDoacao(Doacao doacao) {

        this.listaDoacoes.add(doacao);

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Doacao> getListaDoacoes() {
        return listaDoacoes;
    }

    public void setListaDoacoes(List<Doacao> listaDoacoes) {
        this.listaDoacoes = listaDoacoes;
    }

}
