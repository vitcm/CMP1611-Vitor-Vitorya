package dao;

import model.Ingrediente;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoIngrediente {

    public boolean inserir(Ingrediente ingrediente) {
        String sql = "INSERT INTO ingredientes (nome_ingrediente, descricao) VALUES ( ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ingrediente.getNomeIngrediente());
            stmt.setString(2, ingrediente.getDescricao());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Ingrediente> listarTodos() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        String sql = "SELECT * FROM ingredientes";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setCodIngrediente(rs.getInt("codIngrediente"));
                ingrediente.setNomeIngrediente(rs.getString("nomeIngrediente"));
                ingrediente.setDescricao(rs.getString("descricao"));
                ingredientes.add(ingrediente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredientes;
    }

    public void atualizar(Ingrediente ingrediente) {
        String sql = "UPDATE ingredientes SET nome_ingrediente = ?, descricao = ? WHERE cod_ingrediente = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ingrediente.getNomeIngrediente());
            stmt.setString(2, ingrediente.getDescricao());
            stmt.setInt(3, ingrediente.getCodIngrediente());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int codIngrediente) {
        String sql = "DELETE FROM ingredientes WHERE cod_ingrediente = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codIngrediente);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
