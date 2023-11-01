package telas;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaVisuLivros {

    private List<String> listaLivros;

    public TelaVisuLivros(List<String> listaLivros) {
        this.listaLivros = listaLivros;
    }

    public void abreTelaLivros() {
        JFrame frame = new JFrame("LIVROS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("LIVROS", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial",Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Convertendo a lista para um array de strings
        String[] livros = listaLivros.toArray(new String[0]);

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
