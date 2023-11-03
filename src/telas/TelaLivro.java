package telas;

import controle.TelaLivroControle;
import model.Livro;
import java.awt.*;
import javax.swing.*;
import java.util.List;

public class TelaLivro {
    public static void areaLivro(String isbn) {
        Livro livro = new Livro();

        JFrame frame = new JFrame("LIVRO " + isbn);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("LIVRO " + isbn + " - ISBN", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Lista de receitas
        List<String> receitasLivroList = TelaLivroControle.listaReceitasPorLivro(isbn);
        String[] receitasLivro = receitasLivroList.toArray(new String[0]);
        JList<String> listaReceitasPorLivro = new JList<>(receitasLivro);
        listaReceitasPorLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaReceitasPorLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                if (evt.getClickCount() == 2) {
                    TelaReceita.areaReceita();
                }
            }
        });

        frame.add(new JScrollPane(listaReceitasPorLivro));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
