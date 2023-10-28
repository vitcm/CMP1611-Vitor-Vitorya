package telas;

import controle.TelaCadCategoriasControle;
import controle.TelaCadastroFuncControle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadCategorias {
    public static void areaCadCategorias() {
        JFrame frame = new JFrame("CADASTRO CATEGORIA");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO CATEGORIA", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os campos de texto
        JPanel camposPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //input nome
        JPanel nomePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel nomeLabel = new JLabel("Categoria");
        JTextField nomeInput = new JTextField(20);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeInput);
        camposPanel.add(nomePanel);

        // criando espaço para botões
        JPanel botoesPanel = new JPanel(new BorderLayout());
        // Botão Cadastrar
        JButton cadastrarButton = new JButton("CADASTRAR");
        cadastrarButton.setBackground(Color.GRAY);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setPreferredSize(new Dimension(400, 50));

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String result = TelaCadCategoriasControle.cadastraCategoria(nome);
                JOptionPane.showMessageDialog(frame, result);
            }
        });

        botoesPanel.add(cadastrarButton, BorderLayout.SOUTH);

        frame.add(camposPanel, BorderLayout.CENTER);
        frame.add(botoesPanel, BorderLayout.SOUTH);

        // inserir no centro da tela
        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }
}
