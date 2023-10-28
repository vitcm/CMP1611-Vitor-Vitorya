package telas;

import javax.swing.*;
import java.awt.*;

public class TelaReceita {
    public static void areaReceita() {
        JFrame frame = new JFrame("RECEITA X"); // ----> PEGAR O NOME DO LIVRO NO BD
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("RECEITA X - NOME COZINHEIRO", SwingConstants.CENTER); // ----> PEGAR NOMES NO BD
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Lista de ingredientes
        String[] ingredientesReceita = { // ---> CHAMAR MÉTODO QUE PEGUE NO BD OS INGREDIENTES DA RECEITA X
                "Ingrediente x - Quantidade x medida",
                "Ingrediente x - Quantidade x medida",
                "Ingrediente x - Quantidade x medida"
        };
        JList<String> listaIngredientesReceita = new JList<>(ingredientesReceita);
        listaIngredientesReceita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        frame.add(new JScrollPane(listaIngredientesReceita));

        // inserindo o título da tela
        JLabel modoPreparoLabel = new JLabel("blábláblá", SwingConstants.CENTER); // ----> PEGAR MODO DE PREPARO NO BD
        modoPreparoLabel.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12));
        frame.add(modoPreparoLabel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }
}
