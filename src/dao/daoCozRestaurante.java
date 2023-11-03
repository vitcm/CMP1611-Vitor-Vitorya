package dao;

import model.ReceitaLivro;
import model.RestauranteCozinheiro;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class daoCozRestaurante {

    public boolean inserir(RestauranteCozinheiro restauranteCozinheiro) {
        String sql = "INSERT INTO restaurante_cozinheiro (cod_coz_restcoz, cod_rest_restcoz, data_contratacao) VALUES (?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, restauranteCozinheiro.getCodCozRestcoz());
            stmt.setInt(2, restauranteCozinheiro.getCodRestRestcoz());
            stmt.setDate(3, new Date(restauranteCozinheiro.getDataContratacao().getTime()) );

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
