package dao;

import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class daoIngredientesReceita {

    public boolean inserirIngredienteReceita(String codReceita, String codIngrediente, String quantidade, String medida) {
        String sql = "INSERT INTO ingredientes_receita (cod_receita, cod_ingrediente, quantidade, medida) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, codReceita);
            stmt.setString(2, codIngrediente);
            stmt.setString(3, quantidade);
            stmt.setString(4, medida);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
