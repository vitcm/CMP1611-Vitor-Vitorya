package telas;

import controle.TelaCadastroFuncControle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroFunc {
    public static void areaCadFunc() {
        JFrame frame = new JFrame("CADASTRO FUNCIONÁRIO");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO FUNCIONÁRIO", SwingConstants.CENTER);
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

        //input CPF
        JPanel cpfPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel cpfLabel = new JLabel("CPF");
        JTextField cpfInput = new JTextField(20);
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpfInput);
        camposPanel.add(cpfPanel);

        //input data TEM COMO PEGAR A DATA DIRETO DO BD NO MOMENTO DO CADASTRO? SE SIM, MELHOR!
        JPanel dataPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel dataLabel = new JLabel("Data");
        JTextField dataInput = new JTextField(20);
        dataPanel.add(dataLabel);
        dataPanel.add(dataInput);
        camposPanel.add(dataPanel);

        //input salario
        JPanel salarioPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel salarioLabel = new JLabel("Salário");
        JTextField salarioInput = new JTextField(20);
        salarioPanel.add(salarioLabel);
        salarioPanel.add(salarioInput);
        camposPanel.add(salarioPanel);


        JPanel botoesPanel = new JPanel(new BorderLayout());

        // Painel para os radio buttons
        JPanel radioPanel = new JPanel(new FlowLayout());
        JRadioButton editorButton = new JRadioButton("Editor");
        JRadioButton degustadorButton = new JRadioButton("Degustador");
        JRadioButton cozinheiroButton = new JRadioButton("Cozinheiro");

        ButtonGroup group = new ButtonGroup();
        group.add(editorButton);
        group.add(degustadorButton);
        group.add(cozinheiroButton);

        radioPanel.add(editorButton);
        radioPanel.add(degustadorButton);
        radioPanel.add(cozinheiroButton);


        botoesPanel.add(radioPanel, BorderLayout.NORTH);

        // Nome fantasia que só aparece se o cargo for para cozinheiro
        JPanel nomeFantasiaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel nomeFantasiaLabel = new JLabel("Nome Fantasia");
        JTextField nomeFantasiaInput = new JTextField(20);
        nomeFantasiaPanel.add(nomeFantasiaLabel);
        nomeFantasiaPanel.add(nomeFantasiaInput);
        camposPanel.add(nomeFantasiaPanel);
        nomeFantasiaPanel.setVisible(false);

        // Botão Cadastrar
        JButton cadastrarButton = new JButton("CADASTRAR");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String cpf = cpfInput.getText();
                String data = dataInput.getText();
                String salario = salarioInput.getText();

                String cargo = "";
                if (editorButton.isSelected()) {
                    cargo = "Editor";
                } else if (degustadorButton.isSelected()) {
                    cargo = "Degustador";
                } else if (cozinheiroButton.isSelected()) {
                    cargo = "Cozinheiro";
                }

                String nomeFantasia = "";
                if (cargo.equals("Cozinheiro")) {
                    nomeFantasia = nomeFantasiaInput.getText();
                }
                String result = TelaCadastroFuncControle.cadastraFuncionario(nome, cpf, data, salario, cargo, nomeFantasia);
                JOptionPane.showMessageDialog(frame, result);
            }
        });

        cadastrarButton.setBackground(Color.GRAY);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setPreferredSize(new Dimension(400, 50));

        botoesPanel.add(cadastrarButton, BorderLayout.SOUTH);

        cozinheiroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeFantasiaPanel.setVisible(true); // Quando selecionado, torna o campo visível
            }
        });

        // se o campo não for o cozinheiro, o nome fantasia fica escondido
        editorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeFantasiaPanel.setVisible(false);
            }
        });
        degustadorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeFantasiaPanel.setVisible(false);
            }
        });

        frame.add(camposPanel, BorderLayout.CENTER);
        frame.add(botoesPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }
}
