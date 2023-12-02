package telas;

import controle.TelaVisuReceitasControle;
import model.Receita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaMaioresCozinheiros {

    public static void abreTelaMaioresCozinheiros() {
        JFrame frame = new JFrame("Top 5 Cozinheiros");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("Top 5 Cozinheiros", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Cabeçalho da tabela
        String[] colunas = {"Nome cozinheiro", "Nome fantasia", "CPF cozinheiros", "Quantidade de receitas criadas"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        // Linhas da tabela (estáticas -> FAZER RECEBER OS COMANDOS SQL)
        // TEM QUE SER EM ORDEM CRESCENTE DE QTDE DE RECEITAS
        String[][] dados = {
                {"Cozinheiro1", "Fantasia1", "123.456.789-01", "10"},
                {"Cozinheiro2", "Fantasia2", "987.654.321-01", "8"},
                {"Cozinheiro3", "Fantasia3", "111.222.333-44", "15"},
                {"Cozinheiro4", "Fantasia4", "555.666.777-88", "12"},
                {"Cozinheiro5", "Fantasia5", "999.888.777-66", "9"}
        };

        for (String[] linha : dados) {
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Exibir a tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
