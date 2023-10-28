package telas;

import javax.swing.*;
import java.awt.*;

public class TelaCadReceitaLivro {
    public static void areaCadReceitaLivro() {
        JFrame frame = new JFrame("CADASTRO  DE RECEITA EM LIVRO");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO  DE RECEITA EM LIVRO", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os campos de texto
        JPanel camposPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //combobox receitas
        String[] opcoesReceitas = {"Cod receita 1 - Nome receita 1", "Cod receita 2 - Nome receita 2", "Cod receita 3 - Nome receita 3"};
        JComboBox<String> comboBoxReceitas = new JComboBox<>(opcoesReceitas);
        camposPanel.add(comboBoxReceitas);

        //combobox ISBN
        String[] opcoesISBN = {"ISBN 1 - Nome livro 1", "ISBN 2 - Nome livro 2", "ISBN 3 - Nome livro 3"};
        JComboBox<String> comboBoxLivros = new JComboBox<>(opcoesISBN);
        camposPanel.add(comboBoxLivros);

        JPanel botoesPanel = new JPanel(new BorderLayout());
        // Botão Cadastrar
        JButton cadastrarButton = new JButton("CADASTRAR");
        cadastrarButton.setBackground(Color.GRAY);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setPreferredSize(new Dimension(400, 50));

        botoesPanel.add(cadastrarButton, BorderLayout.SOUTH);

        frame.add(camposPanel, BorderLayout.CENTER);
        frame.add(botoesPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }
}
