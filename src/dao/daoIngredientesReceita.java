package dao;

import model.IngredientesReceita;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class daoIngredientesReceita {

    public boolean inserirIngredienteReceita(IngredientesReceita ingredientesReceita) {
        String sql = "INSERT INTO ingredientes_receita (cod_receita, cod_ingrediente, quantidade, medida) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, ingredientesReceita.getCodReceita());
            stmt.setInt(2, ingredientesReceita.getCodIngrediente());
            stmt.setInt(3, ingredientesReceita.getQuantidade());
            stmt.setString(4, ingredientesReceita.getMedida());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
