package telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaReceitaPorCategorias {

    public static void abreTelaReceitaPorCategoria() {
        JFrame frame = new JFrame("Categorias e suas receitas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("Categorias e suas receitas", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Cabeçalho da tabela
        String[] colunas = {"Código da categoria", "Descrição categoria", "Quantidade de receitas"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        // Linhas da tabela (estáticas -> FAZER RECEBER OS COMANDOS SQL)
        // TEM QUE SER EM ORDEM CRESCENTE DE QTDE DE RECEITAS
        String[][] dados = {
                {"1", "Categoria x", "28"},
                {"8", "Categoria y", "19"},
                {"4", "Categoria a", "15"},
                {"6", "Categoria m", "12"},
                {"2", "Categoria u", "9"}
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
