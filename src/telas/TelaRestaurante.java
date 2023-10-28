package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRestaurante {
    public static void areaRest() {
        JFrame frame = new JFrame("ÁREA RESTAURANTE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("ÁREA RESTAURANTE", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // espaço botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.add(botoesPanel, BorderLayout.CENTER);

        // botão para cadastro restaurante
        JButton botaoTeste = new JButton("Cadastrar Restaurante");
        criaButton(botaoTeste);
        botaoTeste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadRestaurante.areaCadRestaurante();
            }
        });
        botoesPanel.add(botaoTeste);

        // botão para cadastrar cozinheiro em restaurante
        JButton botaoCozRest = new JButton("Cadastrar Cozinheiro em Restaurante");
        criaButton(botaoCozRest);
        botaoCozRest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadRestaurante.areaCadRestaurante();
            }
        });
        botoesPanel.add(botaoCozRest);

        // Lista de testes  ----> MÉTODO GET DE TODOS OS RESTAURANTES
        String[] testes = {
                "Cod 1 - Nome restaurante",
                "Cod 1 - Nome restaurante",
                "Cod 1 - Nome restaurante"
        };
        JList<String> listaRestaurantes = new JList<>(testes);
        listaRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        frame.add(new JScrollPane(listaRestaurantes), BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }

    public static void criaButton(JButton botao) {
        botao.setBackground(Color.GRAY);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}
