package dao;

import model.Livro;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoLivro {

    public void inserir(Livro livro) {
        String sql = "INSERT INTO livros (ISBN, titulo, cpfEditor) VALUES (?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, livro.getISBN());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getCpfEditor());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarTodos() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setISBN(rs.getString("ISBN"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setCpfEditor(rs.getString("cpfEditor"));
                livros.add(livro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE livros SET titulo = ?, cpfEditor = ? WHERE ISBN = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getCpfEditor());
            stmt.setString(3, livro.getISBN());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String ISBN) {
        String sql = "DELETE FROM livros WHERE ISBN = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ISBN);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
