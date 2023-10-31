package dao;

import model.Degustador;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoDegustador {

    public void inserir(Degustador degustador) {
        String sql = "INSERT INTO degustadores (cpf, nome, data_ingresso, salario) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, degustador.getCpf());
            stmt.setString(2, degustador.getNome());
            stmt.setDate(3, Date.valueOf(degustador.getDataIngresso().toLocalDate()));
            stmt.setBigDecimal(4, degustador.getSalario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Degustador> listarTodos() {
        List<Degustador> degustadores = new ArrayList<>();
        String sql = "SELECT * FROM degustadores";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Degustador degustador = new Degustador();
                degustador.setCpf(rs.getString("cpf"));
                degustador.setNome(rs.getString("nome"));
                degustador.setDataIngresso(Date.valueOf(rs.getDate("data_ingresso").toLocalDate()));
                degustador.setSalario(rs.getBigDecimal("salario"));
                degustadores.add(degustador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return degustadores;
    }

    public void atualizar(Degustador degustador) {
        String sql = "UPDATE degustadores SET nome = ?, data_ingresso = ?, salario = ? WHERE cpf = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, degustador.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(degustador.getDataIngresso().toLocalDate()));
            stmt.setBigDecimal(3, degustador.getSalario());
            stmt.setString(4, degustador.getCpf());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String cpf) {
        String sql = "DELETE FROM degustadores WHERE cpf = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
