package dao;

import model.Livro;
import model.ReceitaLivro;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoReceitaLivro {

    public boolean inserir(ReceitaLivro receitaLivro) {
        String sql = "INSERT INTO receita_livro (cod_receita, isbn) VALUES (?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, receitaLivro.getCodReceita());
            stmt.setString(2, receitaLivro.getIsbn());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
