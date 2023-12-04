package dao;

import model.Categoria;
import util.ConexaoBD;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoCategoria {

    public boolean inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria (desc_categoria) VALUES ( ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, categoria.getDescCategoria());

            stmt.executeUpdate();
            return true;

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
                categoria.setCodCategoria(rs.getInt("cod_categoria"));
                categoria.setDescCategoria(rs.getString("desc_categoria"));
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

    public static DefaultTableModel buscarReceitasPorCategoria() {
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"Código da categoria", "Descrição categoria", "Quantidade de receitas"}, 0);

        String sql = "SELECT cat.cod_categoria, cat.desc_categoria, COUNT(rec.cod_receita) AS quantidade_receitas "
                + "FROM categoria cat "
                + "LEFT JOIN receitas rec ON cat.cod_categoria = rec.cod_categoria "
                + "GROUP BY cat.cod_categoria "
                + "ORDER BY quantidade_receitas ASC;";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] linha = new Object[]{
                        rs.getInt("cod_categoria"),
                        rs.getString("desc_categoria"),
                        rs.getInt("quantidade_receitas")
                };
                modelo.addRow(linha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelo;
    }
}
