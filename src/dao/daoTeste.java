package dao;

import model.Teste;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoTeste {

    public static boolean inserir(Teste teste) {
        String sql = "INSERT INTO teste (cod_receita, cpf_degustador, data_teste, nota) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, teste.getCodReceita());
            stmt.setString(2, teste.getCpfDegustador());
            stmt.setDate(3, new Date(teste.getDataTeste().getTime()));
            stmt.setInt(4, teste.getNota());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
                teste.setCodReceita(rs.getInt("cod_receita"));
                teste.setCpfDegustador(rs.getString("cpf_degustador"));
                teste.setDataTeste(rs.getDate("data_teste"));
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

    public static List<Teste> buscarTestesPorIngredientes(String ingredienteX, String ingredienteY) {
        List<Teste> testes = new ArrayList<>();
        String sql = "SELECT "
                + "t.cod_receita, "
                + "d.cpf AS cpf_degustador, "
                + "d.nome AS nome_testador, "
                + "t.data_teste, "
                + "t.nota, "
                + "r.nome_receita "
                + "FROM teste t "
                + "JOIN degustadores d ON t.cpf_degustador = d.cpf "
                + "JOIN receitas r ON t.cod_receita = r.cod_receita "
                + "JOIN ingredientes_receita ir ON r.cod_receita = ir.cod_receita "
                + "JOIN ingredientes i ON ir.cod_ingrediente = i.cod_ingrediente "
                + "WHERE i.nome_ingrediente IN (?, ?) "
                + "GROUP BY t.cod_receita, d.cpf, d.nome, t.data_teste, t.nota, r.nome_receita "
                + "HAVING COUNT(DISTINCT i.nome_ingrediente) = 2;";


        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ingredienteX);
            stmt.setString(2, ingredienteY);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Teste teste = new Teste();
                    teste.setNomeTestador(rs.getString("nome_testador"));
                    teste.setNomeReceita(rs.getString("nome_receita"));
                    teste.setNota(rs.getInt("nota"));
                    testes.add(teste);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testes;
    }
}
