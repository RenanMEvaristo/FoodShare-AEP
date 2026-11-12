package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Doacao;

public class DoacaoDAO {

    public boolean salvar(Doacao doacao) {

        String sql = "INSERT INTO doacoes (id_doador, descricao, categoria, quantidade, validade, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, doacao.getIdDoador());
            stmt.setString(2, doacao.getDescricao());
            stmt.setString(3, doacao.getCategoria());
            stmt.setDouble(4, doacao.getQuantidade());
            stmt.setDate(5, java.sql.Date.valueOf(doacao.getValidade()));
            stmt.setString(6, doacao.getStatus());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
            return false;
        }
    }

    public List<Doacao> listarTodas() {

        List<Doacao> doacoes = new ArrayList<>();
        String sql = "SELECT * FROM doacoes";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Doacao d = new Doacao();
                d.setId(rs.getInt("id_doacao"));
                d.setIdDoador(rs.getInt("id_doador"));
                d.setDescricao(rs.getString("descricao"));
                d.setCategoria(rs.getString("categoria"));
                d.setQuantidade(rs.getDouble("quantidade"));
                d.setValidade(rs.getDate("validade").toLocalDate());
                d.setStatus(rs.getString("status"));

                doacoes.add(d);

            }
        } catch (SQLException e) {

            System.err.println("Erro ao listar: " + e.getMessage());

        }

        return doacoes;

    }

    public List<Doacao> filtrarPorCategoria(String categoria) {

        List<Doacao> doacoes = new ArrayList<>();

        String sql = "SELECT * FROM doacoes WHERE categoria = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Doacao d = new Doacao();
                    d.setId(rs.getInt("id_doacao"));
                    d.setIdDoador(rs.getInt("id_doador"));
                    d.setDescricao(rs.getString("descricao"));
                    d.setCategoria(rs.getString("categoria"));
                    d.setQuantidade(rs.getDouble("quantidade"));
                    d.setValidade(rs.getDate("validade").toLocalDate());
                    d.setStatus(rs.getString("status"));

                    doacoes.add(d);

                }

            }

        } catch (SQLException e) {

            System.err.println("Erro ao filtrar por categoria: " + e.getMessage());

        }

        return doacoes;

    }

    public boolean atualizarStatus(int id, String novoStatus) {

        String sql = "UPDATE doacoes SET status =? where id_doacao = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {

            System.err.println("Erro ao atualizar status: " + e.getMessage());
            return false;

        }

    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM doacoes WHERE id_doacao = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {

            System.err.println("Erro ao excluir a Doacao: " + e.getMessage());
            return false;

        }

    }

}
