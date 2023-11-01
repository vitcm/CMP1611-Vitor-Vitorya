package dao;

import model.Teste;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoTeste {

    public void inserir(Teste teste) {
        String sql = "INSERT INTO teste (codReceita, cpfDegustador, dataTeste, nota) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, teste.getCodReceita());
            stmt.setString(2, teste.getCpfDegustador());
            stmt.setDate(3, new Date(teste.getDataTeste().getTime()));
            stmt.setInt(4, teste.getNota());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Teste> listarTodos() {
        List<Teste> testes = new ArrayList<>();
        String sql = "SELECT * FROM teste";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Teste teste = new Teste();
                teste.setCodReceita(rs.getInt("codReceita"));
                teste.setCpfDegustador(rs.getString("cpfDegustador"));
                teste.setDataTeste(rs.getDate("dataTeste"));
                teste.setNota(rs.getInt("nota"));
                testes.add(teste);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testes;
    }

    public void atualizar(Teste teste) {
        String sql = "UPDATE teste SET cpfDegustador = ?, dataTeste = ?, nota = ? WHERE codReceita = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, teste.getCpfDegustador());
            stmt.setDate(2, new Date(teste.getDataTeste().getTime()));
            stmt.setInt(3, teste.getNota());
            stmt.setInt(4, teste.getCodReceita());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int codReceita) {
        String sql = "DELETE FROM teste WHERE codReceita = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codReceita);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
