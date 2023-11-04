package dao;

import model.Receita;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoReceita {

    public boolean inserir(Receita receita) {
        String sql = "INSERT INTO receitas (nome_receita, data_inventada, cod_cozinheiro, cod_categoria, descricao_preparacao, num_porcoes) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, receita.getNomeReceita());
            stmt.setDate(2, new Date (receita.getDataInventada().getTime()));
            stmt.setString(3, receita.getCodCozinheiro());
            stmt.setInt(4, receita.getCodCategoria());
            stmt.setString(5, receita.getDescricaoPreparacao());
            stmt.setInt(6, receita.getNumPorcoes());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Receita> listarTodos() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM receitas";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setCodReceita(rs.getInt("cod_receita"));
                receita.setNomeReceita(rs.getString("nome_receita"));
                receita.setDataInventada(Date.valueOf(rs.getDate("data_inventada").toLocalDate()));
                receita.setCodCozinheiro(rs.getString("cod_cozinheiro"));
                receita.setCodCategoria(rs.getInt("cod_categoria"));
                receita.setDescricaoPreparacao(rs.getString("descricao_preparacao"));
                receita.setNumPorcoes(rs.getInt("num_porcoes"));
                receitas.add(receita);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receitas;
    }

    public void atualizar(Receita receita) {
        String sql = "UPDATE receitas SET nomeReceita = ?, dataInventada = ?, codCozinheiro = ?, codCategoria = ?, descricaoPreparacao = ?, numPorcoes = ? WHERE codReceita = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, receita.getNomeReceita());
            stmt.setDate(2, new Date(receita.getDataInventada().getTime()));
            stmt.setString(3, receita.getCodCozinheiro());
            stmt.setInt(4, receita.getCodCategoria());
            stmt.setString(5, receita.getDescricaoPreparacao());
            stmt.setInt(6, receita.getNumPorcoes());
            stmt.setInt(7, receita.getCodReceita());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int codReceita) {
        String sql = "DELETE FROM receitas WHERE codReceita = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codReceita);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Receita buscarPorId(int codReceita) {
        String sql = "SELECT * FROM receitas WHERE cod_receita = ?";
        Receita receita = null;

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codReceita);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                receita = new Receita();
                receita.setCodReceita(rs.getInt("cod_receita"));
                receita.setNomeReceita(rs.getString("nome_receita"));
                receita.setDataInventada(rs.getDate("data_inventada"));
                receita.setCodCozinheiro(rs.getString("cod_cozinheiro"));
                receita.setCodCategoria(rs.getInt("cod_categoria"));
                receita.setDescricaoPreparacao(rs.getString("descricao_preparacao"));
                receita.setNumPorcoes(rs.getInt("num_porcoes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receita;
    }
    public String buscarNomeCozinheiro(String codCozinheiro) {
        String sql = "SELECT nome FROM cozinheiros WHERE cpf = ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, codCozinheiro);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Cozinheiro não encontrado";
    }

    public List<String> buscarIngredientesPorIdReceita(int codReceita) {
        List<String> ingredientesDetalhes = new ArrayList<>();
        // Adjust the SQL to join the 'ingredientes_receita' table with 'ingredientes' table
        String sql = "SELECT ir.cod_ingrediente, i.nome_ingrediente, i.descricao " +
                "FROM ingredientes_receita ir " +
                "JOIN ingredientes i ON ir.cod_ingrediente = i.cod_ingrediente " +
                "WHERE ir.cod_receita = ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codReceita);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Construct a string with the ingredient details
                String detalheIngrediente =" Nome: " + rs.getString("nome_ingrediente") +
                        ", Descrição: " + rs.getString("descricao");
                ingredientesDetalhes.add(detalheIngrediente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientesDetalhes;
    }
}
