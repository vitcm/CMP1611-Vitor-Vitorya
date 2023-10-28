package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVisuReceitas {
    public static void abreTelaReceitas() {
        JFrame frame = new JFrame("RECEITAS");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("RECEITAS", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial",Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Lista de receitas
        String[] receitas = { // ----> PEGAR DO BD
                "Receita 1 - Cozinheiro",
                "Receita 2 - Cozinheiro",
                "Receita 3 - Cozinheiro"
        };
        JList<String> listaReceitas = new JList<>(receitas);
        listaReceitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaReceitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                if (evt.getClickCount() == 2) {
                    //String receitaSelecionada = list.getSelectedValue();
                    TelaReceita.areaReceita();
                }
            }
        });

        frame.add(new JScrollPane(listaReceitas));

        // Exibir a tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
