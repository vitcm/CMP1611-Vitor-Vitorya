package telas;

import javax.swing.*;
import java.awt.*;

public class TelaCadRestaurante {
    public static void areaCadRestaurante() {
        JFrame frame = new JFrame("CADASTRO RESTAURANTE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO RESTAURANTE", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os campos de texto
        JPanel camposPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //input nome
        JPanel nomePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel nomeLabel = new JLabel("Nome");
        JTextField nomeInput = new JTextField(20);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeInput);
        camposPanel.add(nomePanel);

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
