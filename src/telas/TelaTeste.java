package telas;

import javax.swing.*;
import java.awt.*;

public class TelaTeste {
    public static void areaTeste() {
        JFrame frame = new JFrame("TESTE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("TESTE", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Painel para os campos de texto
        JPanel camposPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //input cpfDegust
        JPanel nomePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel nomeLabel = new JLabel("CPF Degustador");
        JTextField nomeInput = new JTextField(20);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeInput);
        camposPanel.add(nomePanel);

        //input data TEM COMO PEGAR A DATA DIRETO DO BD NO MOMENTO DO CADASTRO? SE SIM, MELHOR!
        JPanel dataPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel dataLabel = new JLabel("Data");
        JTextField dataInput = new JTextField(20);
        dataPanel.add(dataLabel);
        dataPanel.add(dataInput);
        camposPanel.add(dataPanel);

        //input nota
        JPanel notaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel notaLabel = new JLabel("Nota");
        JTextField notaInput = new JTextField(20);
        notaPanel.add(notaLabel);
        notaPanel.add(notaInput);
        camposPanel.add(notaPanel);


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
        frame.setVisible(true);
    }
}
