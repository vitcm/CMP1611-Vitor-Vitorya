package dao;

import model.Restaurante;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoRestaurante {

    public void inserir(Restaurante restaurante) {
        String sql = "INSERT INTO restaurante (nome_rest) VALUES (?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, restaurante.getNomeRest());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurante> listarTodos() {
        List<Restaurante> restaurantes = new ArrayList<>();
        String sql = "SELECT * FROM restaurante";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Restaurante restaurante = new Restaurante();
                restaurante.setCodRest(rs.getInt("cod_rest"));
                restaurante.setNomeRest(rs.getString("nome_rest"));
                restaurantes.add(restaurante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantes;
    }

    public void atualizar(Restaurante restaurante) {
        String sql = "UPDATE restaurante SET nomeRest = ? WHERE codRest = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, restaurante.getNomeRest());
            stmt.setInt(2, restaurante.getCodRest());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int codRest) {
        String sql = "DELETE FROM restaurante WHERE codRest = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codRest);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
