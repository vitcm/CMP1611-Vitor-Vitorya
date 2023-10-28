package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaAreaEdit {
    public static void areaEdit() {
        JFrame frame = new JFrame("ÁREA EDITOR");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("ÁREA EDITOR", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.add(botoesPanel, BorderLayout.CENTER);

        // botão para cadastro de livro
        JButton botaoLivro = new JButton("Cadastrar Livro");
        criaButton(botaoLivro);
        botaoLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadLivro.areaCadLivro();
            }
        });
        botoesPanel.add(botaoLivro);

        // botão para cadastrar receita em um livro específico
        JButton botaoReceitaLivro = new JButton("Cadastrar Receita em Livro");
        criaButton(botaoReceitaLivro);
        // Adicionando um ActionListener
        botaoReceitaLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadReceitaLivro.areaCadReceitaLivro();
            }
        });
        botoesPanel.add(botaoReceitaLivro);

        // insere no centro da tela
        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }

    //layout botões
    public static void criaButton(JButton botao) {
        Color minhaCor = new Color(150, 150, 150);
        botao.setBackground(minhaCor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}
