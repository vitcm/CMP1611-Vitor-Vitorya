package dao;

import model.Receita;
import util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoReceita {

    public boolean inserir(Receita receita) {
        String sql = "INSERT INTO receitas (nome_receita, data_inventada, cod_cozinheiro, cod_categoria, descricao_preparacao, num_porcoes) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, receita.getNomeReceita());
            stmt.setDate(2, new Date (receita.getDataInventada().getTime()));
            stmt.setString(3, receita.getCodCozinheiro());
            stmt.setInt(4, receita.getCodCategoria());
            stmt.setString(5, receita.getDescricaoPreparacao());
            stmt.setInt(6, receita.getNumPorcoes());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Receita> listarTodos() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM receitas";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setCodReceita(rs.getInt("cod_receita"));
                receita.setNomeReceita(rs.getString("nome_receita"));
                receita.setDataInventada(Date.valueOf(rs.getDate("data_inventada").toLocalDate()));
                receita.setCodCozinheiro(rs.getString("cod_cozinheiro"));
                receita.setCodCategoria(rs.getInt("cod_categoria"));
                receita.setDescricaoPreparacao(rs.getString("descricao_preparacao"));
                receita.setNumPorcoes(rs.getInt("num_porcoes"));
                receitas.add(receita);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receitas;
    }

    public void atualizar(Receita receita) {
        String sql = "UPDATE receitas SET nomeReceita = ?, dataInventada = ?, codCozinheiro = ?, codCategoria = ?, descricaoPreparacao = ?, numPorcoes = ? WHERE codReceita = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, receita.getNomeReceita());
            stmt.setDate(2, new Date(receita.getDataInventada().getTime()));
            stmt.setString(3, receita.getCodCozinheiro());
            stmt.setInt(4, receita.getCodCategoria());
            stmt.setString(5, receita.getDescricaoPreparacao());
            stmt.setInt(6, receita.getNumPorcoes());
            stmt.setInt(7, receita.getCodReceita());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int codReceita) {
        String sql = "DELETE FROM receitas WHERE codReceita = ?";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, codReceita);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
