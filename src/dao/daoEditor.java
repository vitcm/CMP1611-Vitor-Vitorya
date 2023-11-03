package dao;

import model.Editor;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoEditor {

    public boolean inserir(Editor editor) {
        String sql = "INSERT INTO editores (cpf, nome, data_ingresso, salario) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, editor.getCpf());
            stmt.setString(2, editor.getNome());
            stmt.setDate(3, new Date(editor.getDataIngresso().getTime()));
            stmt.setBigDecimal(4, editor.getSalario());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Editor> listarTodos() {
        List<Editor> editores = new ArrayList<>();
        String sql = "SELECT * FROM editores";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Editor editor = new Editor();
                editor.setCpf(rs.getString("cpf"));
                editor.setNome(rs.getString("nome"));
                editor.setDataIngresso(rs.getDate("data_ingresso"));
                editor.setSalario(rs.getBigDecimal("salario"));
                editores.add(editor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return editores;
    }

    public void atualizar(Editor editor) {
        String sql = "UPDATE editores SET nome = ?, data_ingresso = ?, salario = ? WHERE cpf = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, editor.getNome());
            stmt.setDate(2, new Date(editor.getDataIngresso().getTime()));
            stmt.setBigDecimal(3, editor.getSalario());
            stmt.setString(4, editor.getCpf());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  /*  public void excluir(String cpf) {
        String sql = "DELETE FROM editores WHERE cpf = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
