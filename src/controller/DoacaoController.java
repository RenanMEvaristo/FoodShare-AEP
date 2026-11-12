package controller;

import java.time.LocalDate;

import dao.DoacaoDAO;
import model.Doacao;
import java.util.List;

public class DoacaoController {

    private DoacaoDAO doacaoDAO;

    public DoacaoController() {

        this.doacaoDAO = new DoacaoDAO();

    }

    public boolean cadastrarDoacao(int idDoador, String descricao, String categoria, double quantidade,
            LocalDate validade) {

        if (descricao == null || descricao.trim().isEmpty()) {

            System.err.println("Erro: A descrição da doação nao pode estar vazia");
            return false;

        }

        if (quantidade <= 0) {
            System.err.println("Erro: a quantidade deve ser maior que zero");
            return false;

        }

        if (validade == null || validade.isBefore(LocalDate.now())) {
            System.err.println("Erro: A data de validade não pode estar no passado");
            return false;

        }

        Doacao novaDoacao = new Doacao(idDoador, descricao, categoria, quantidade, validade, "DISPONIVEL");

        return this.doacaoDAO.salvar(novaDoacao);
    }

    public java.util.List<Doacao> listarTodas() {

        return this.doacaoDAO.listarTodas();

    }

    public java.util.List<Doacao> filtrarPorCategoria(String categoria) {

        return this.doacaoDAO.filtrarPorCategoria(categoria);

    }

    public boolean atualizarStatus(int idDoacao, String novoStatus) {

        if (idDoacao <= 0) {

            System.err.println("Erro: ID de doaçao inválido");
            return false;

        }

        return this.doacaoDAO.atualizarStatus(idDoacao, novoStatus);

    }

    public boolean excluir(int id) {

        if (id <= 0) {

            System.err.println("Erro: ID de doacao inválido");
            return false;

        }
        return this.doacaoDAO.excluir(id);

    }

}
