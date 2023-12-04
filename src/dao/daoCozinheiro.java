package dao;

import model.Cozinheiro;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoCozinheiro {

    public boolean inserir(Cozinheiro cozinheiro) {
        String sql = "INSERT INTO cozinheiros (cpf, nome, data_ingresso, salario, nome_fantasia, lista_restaurantes) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cozinheiro.getCpf());
            stmt.setString(2, cozinheiro.getNome());
            stmt.setDate(3, new Date(cozinheiro.getDataIngresso().getTime()));
            stmt.setBigDecimal(4, cozinheiro.getSalario());
            stmt.setString(5, cozinheiro.getNomeFantasia());
            stmt.setString(6, cozinheiro.getListaRestaurantes());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cozinheiro> listarTodos() {
        List<Cozinheiro> cozinheiros = new ArrayList<>();
        String sql = "SELECT * FROM cozinheiros";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cozinheiro cozinheiro = new Cozinheiro();
                cozinheiro.setCpf(rs.getString("cpf"));
                cozinheiro.setNome(rs.getString("nome"));
                cozinheiro.setDataIngresso(rs.getDate("data_ingresso"));
                cozinheiro.setSalario(rs.getBigDecimal("salario"));
                cozinheiro.setNomeFantasia(rs.getString("nome_fantasia"));
                cozinheiro.setListaRestaurantes(rs.getString("lista_restaurantes"));
                cozinheiros.add(cozinheiro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cozinheiros;
    }

    public void atualizar(Cozinheiro cozinheiro) {
        String sql = "UPDATE cozinheiros SET nome = ?, data_ingresso = ?, salario = ?, nome_fantasia = ?, lista_restaurantes = ? WHERE cpf = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cozinheiro.getNome());
            stmt.setDate(2, new Date(cozinheiro.getDataIngresso().getTime()));
            stmt.setBigDecimal(3, cozinheiro.getSalario());
            stmt.setString(4, cozinheiro.getNomeFantasia());
            stmt.setString(5, cozinheiro.getListaRestaurantes());
            stmt.setString(6, cozinheiro.getCpf());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String cpf) {
        String sql = "DELETE FROM cozinheiros WHERE cpf = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cozinheiro> buscarMaioresCozinheiros() {
        List<Cozinheiro> cozinheiros = new ArrayList<>();
        String sql = "SELECT c.cpf, c.nome, c.nome_fantasia, c.data_ingresso, c.salario, c.lista_restaurantes, COUNT(r.cod_receita) as quantidade_receitas "
                + "FROM cozinheiros c "
                + "LEFT JOIN receitas r ON c.cpf = r.cod_cozinheiro "
                + "GROUP BY c.cpf "
                + "ORDER BY quantidade_receitas DESC "
                + "LIMIT 5";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cozinheiro cozinheiro = new Cozinheiro();
                cozinheiro.setCpf(rs.getString("cpf"));
                cozinheiro.setNome(rs.getString("nome"));
                cozinheiro.setDataIngresso(rs.getDate("data_ingresso"));
                cozinheiro.setSalario(rs.getBigDecimal("salario"));
                cozinheiro.setNomeFantasia(rs.getString("nome_fantasia"));
                cozinheiro.setListaRestaurantes(rs.getString("lista_restaurantes"));
                cozinheiro.setQuantidadeReceitas(rs.getInt("quantidade_receitas"));
                cozinheiros.add(cozinheiro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cozinheiros;
    }



}
