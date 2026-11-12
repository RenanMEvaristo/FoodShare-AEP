package model;

public class Instituicao extends Usuario implements Notificavel {

    private String cnpj;
    private String responsavel;
    private int capacidadeDiaria;

    public Instituicao() {
        super();
    }

    public Instituicao(int id, String nome, String endereco, String telefone, String email, String cnpj,
            String responsavel, int capacidadeDiaria) {
        super(id, nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.capacidadeDiaria = capacidadeDiaria;
    }

    public Instituicao(String nome, String endereco, String telefone, String email, String cnpj, String responsavel,
            int capacidadeDiaria) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.capacidadeDiaria = capacidadeDiaria;
    }

    @Override
    public void gerarAlerta() {
        System.out.println("ALERTA INSTITUICAO " + this.nome + ": Nova doacao disponivel para retirada!");
    }

    @Override
    public void exibirPerfil() {
        System.out.println("--- Perfil da Instituicao ---");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Responsavel: " + this.responsavel);
        System.out.println("Capacidade Diaria: " + this.capacidadeDiaria + " pessoas");
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Email: " + this.email);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getCapacidadeDiaria() {
        return capacidadeDiaria;
    }

    public void setCapacidadeDiaria(int capacidadeDiaria) {
        this.capacidadeDiaria = capacidadeDiaria;
    }
}