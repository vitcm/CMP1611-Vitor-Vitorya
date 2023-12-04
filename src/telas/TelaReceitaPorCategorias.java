package telas;

import controle.TelaReceitaPorCategoriasControle;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaReceitaPorCategorias {

    public static void abreTelaReceitaPorCategoria() {
        JFrame frame = new JFrame("Categorias e suas receitas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Categorias e suas receitas", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        TelaReceitaPorCategoriasControle controle = new TelaReceitaPorCategoriasControle();

        DefaultTableModel modelo = controle.buscarReceitasPorCategoriaModeloTabela();

        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
