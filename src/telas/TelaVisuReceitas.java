package telas;

import controle.TelaVisuReceitasControle;
import model.Receita;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelaVisuReceitas {
    private static TelaVisuReceitasControle controle = new TelaVisuReceitasControle();

    public static void abreTelaReceitas() {
        JFrame frame = new JFrame("RECEITAS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("RECEITAS", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Lista de receitas
        List<Receita> receitasDoBD = controle.buscarTodasReceitas();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Map<String, Integer> receitaIdMap = new HashMap<>(); // Mapa para associar a String com o ID da receita

        for (Receita r : receitasDoBD) {
            String receitaString = r.getNomeReceita() + " - " + r.getCodCozinheiro();
            listModel.addElement(receitaString);
            receitaIdMap.put(receitaString, r.getCodReceita());
        }

        JList<String> listaReceitas = new JList<>(listModel);
        listaReceitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
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

        frame.add(new JScrollPane(listaReceitas));

        // Exibir a tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
