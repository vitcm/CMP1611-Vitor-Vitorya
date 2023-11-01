package dao;

import model.Categoria;
import util.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoCategoria {

    public boolean inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (codCategoria, descCategoria) VALUES (?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, categoria.getCodCategoria());
            stmt.setString(2, categoria.getDescCategoria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Categoria> listarTodos() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setCodCategoria(rs.getInt("codCategoria"));
                categoria.setDescCategoria(rs.getString("descCategoria"));
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    public void atualizar(Categoria categoria) {
        String sql = "UPDATE categoria SET descCategoria = ? WHERE codCategoria = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, categoria.getDescCategoria());
            stmt.setInt(2, categoria.getCodCategoria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int codCategoria) {
        String sql = "DELETE FROM categoria WHERE codCategoria = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codCategoria);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
