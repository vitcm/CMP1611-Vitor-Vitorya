package telas;

import controle.TelaVisuReceitasControle;
import model.Receita;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
        for (Receita r : receitasDoBD) {
            listModel.addElement(r.getNomeReceita() + " - " + r.getCodCozinheiro());
        }

        JList<String> listaReceitas = new JList<>(listModel);
        listaReceitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Pode pegar informações da receita selecionada aqui
                    TelaReceita.areaReceita();  // Se a tela de receita detalhada precisa de algum dado, passe como parâmetro.
                }
            }
        });

        frame.add(new JScrollPane(listaReceitas));

        // Exibir a tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
