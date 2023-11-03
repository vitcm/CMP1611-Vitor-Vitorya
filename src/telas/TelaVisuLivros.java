package telas;

import controle.TelaTesteControle;
import controle.TelaVisuLivrosControle;
import model.Livro;
import model.Teste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaVisuLivros {

    private static DefaultListModel<String> listModel;

    public void abreTelaLivros() {
        JFrame frame = new JFrame("LIVROS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("LIVROS", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial",Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        JButton botaoAtualizar = new JButton("Atualizar Lista");
        criaButton(botaoAtualizar);
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaDeLivros();
            }
        });
        frame.add(botaoAtualizar);

        // Convertendo a lista para um array de strings
        listModel = new DefaultListModel<>();
        JList<String> listaLivros = new JList<>(listModel);
        listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(listaLivros));

        atualizarListaDeLivros();

        listaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    String selectedItem = listaLivros.getSelectedValue();
                    if (selectedItem != null) {
                        String[] parts = selectedItem.split(" - ");
                        String isbn = parts[0];
                        TelaLivro.areaLivro(isbn);
                    }
                }
            }
        });

        // Exibir a tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void atualizarListaDeLivros() {
        List<Livro> listaDeLivros = TelaVisuLivrosControle.listaLivros();

        listModel.clear(); // Limpa o modelo da lista antes de adicionar os novos elementos
        for (Livro livro : listaDeLivros) {
            String item = livro.getISBN() +" - " + livro.getTitulo();
            listModel.addElement(item);
        }
    }

    public static void criaButton(JButton botao) {
        Color minhaCor = new Color(150, 150, 150);
        botao.setBackground(minhaCor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}
