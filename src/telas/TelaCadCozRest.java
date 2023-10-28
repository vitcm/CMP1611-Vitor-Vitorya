package telas;

import controle.TelaCadCozRestControle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadCozRest {

    public static void areaCadCozRest() {
        JFrame frame = new JFrame("CADASTRO  DE COZINHEIRO EM RESTAURANTE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO  DE COZINHEIRO EM RESTAURANTE", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os campos de texto
        JPanel camposPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //combobox cozinheiros
        // PEGAR OS DADOS PARA A STRING OPCOESCOZINHEIROS LÁ NO BANCO DE DADOS
        String[] opcoesCozinheiros = {"CPF 1 - Cozinheiro 1", "CPF 2 - Cozinheiro 2", "CPF 3 - Cozinheiro 3"};
        JComboBox<String> comboBoxCozinheiros = new JComboBox<>(opcoesCozinheiros);
        camposPanel.add(comboBoxCozinheiros);

        //combobox restaurantes
        // PEGAR OS DADOS PARA A STRING OPCOESRESTAURANTES LÁ NO BANCO DE DADOS
        String[] opcoesRestaurantes = {"Cod 1 - Restaurante 1", "Cod 2 - Restaurante 2", "Cod 3 - Restaurante 3"};
        JComboBox<String> comboBoxRestaurantes = new JComboBox<>(opcoesRestaurantes);
        camposPanel.add(comboBoxRestaurantes);

        JPanel botoesPanel = new JPanel(new BorderLayout());
        // Botão Cadastrar
        JButton cadastrarButton = new JButton("CADASTRAR");
        cadastrarButton.setBackground(Color.GRAY);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setPreferredSize(new Dimension(400, 50));


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cozinheiroSelecionado = (String) comboBoxCozinheiros.getSelectedItem();
                String restauranteSelecionado = (String) comboBoxRestaurantes.getSelectedItem();
                TelaCadCozRestControle.cadastraCozinheiroEmRestaurante(cozinheiroSelecionado, restauranteSelecionado);
            }
        });

        botoesPanel.add(cadastrarButton, BorderLayout.SOUTH);

        frame.add(camposPanel, BorderLayout.CENTER);
        frame.add(botoesPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }
}
