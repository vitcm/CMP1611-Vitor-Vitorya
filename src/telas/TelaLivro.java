package telas;

import javax.swing.*;
import java.awt.*;

public class TelaLivro {
    public static void areaLivro() {
        JFrame frame = new JFrame("LIVRO X"); // ----> PEGAR O NOME DO LIVRO NO BD
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("LIVRO X - ISBN", SwingConstants.CENTER); // ----> PEGAR O NOME DO LIVRO NO BD
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Lista de receitas
        String[] receitasLivro = { // ---> CHAMAR MÉTODO QUE PEGUE NO BD AS RECEITAS CADASTRADAS NO LIVRO X
                "Receita x - Cozinheiro Nome Completo - Nota x",
                "Receita x - Cozinheiro Nome Completo - Nota x",
                "Receita x - Cozinheiro Nome Completo - Nota x"
        };
        JList<String> listaReceitasPorLivro = new JList<>(receitasLivro);
        listaReceitasPorLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaReceitasPorLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                if (evt.getClickCount() == 2) { //clique 2x
                    TelaReceita.areaReceita();
                }
            }
        });

        frame.add(new JScrollPane(listaReceitasPorLivro));

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }
}
