package telas;

import controle.TelaLivroControle;
import controle.TelaVisuReceitasControle;
import model.Livro;
import model.Receita;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelaLivro {

    private static TelaVisuReceitasControle controle = new TelaVisuReceitasControle();
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

        List<Receita> receitasDoBD = controle.buscarTodasReceitas();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Map<String, Integer> receitaIdMap = new HashMap<>();

        for (Receita r : receitasDoBD) {
            String receitaString = r.getNomeReceita() + " - " + r.getCodCozinheiro();
            listModel.addElement(receitaString);
            receitaIdMap.put(receitaString, r.getCodReceita()); // Associa a String com o ID
        }

        // Lista de receitas
        List<String> receitasLivroList = TelaLivroControle.listaReceitasPorLivro(isbn);
        String[] receitasLivro = receitasLivroList.toArray(new String[0]);
        JList<String> listaReceitasPorLivro = new JList<>(receitasLivro);

        listaReceitasPorLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaReceitasPorLivro.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        String selectedValue = list.getModel().getElementAt(index);
                        Integer receitaId = receitaIdMap.get(selectedValue);
                        if (receitaId != null) {
                            TelaReceita.areaReceita(receitaId);
                        }
                    }
                }
            }
        });

        frame.add(new JScrollPane(listaReceitasPorLivro));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
