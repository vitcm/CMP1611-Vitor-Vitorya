package telas;

import javax.swing.*;
import java.awt.*;

public class TelaVisuLivros {
    public static void abreTelaLivros() {
        JFrame frame = new JFrame("LIVROS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("LIVROS", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial",Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Lista de livros
        String[] livros = { // ----> PEGAR DO BD
                "ISBN - Livro 1",
                "ISBN - Livro 2",
                "ISBN - Livro 3"
        };
        JList<String> listLivros = new JList<>(livros);
        listLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // String receitaSelecionada = list.getSelectedValue();
                    TelaLivro.areaLivro();
                }
            }
        });

        frame.add(new JScrollPane(listLivros));

        // Exibir a tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
