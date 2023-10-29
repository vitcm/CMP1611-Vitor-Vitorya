package telas;

import controle.TelaCadReceitaControle;
import controle.TelaCadastroFuncControle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class TelaCadReceita {
    public static void areaCadReceita() {
        JFrame frame = new JFrame("CADASTRO RECEITA");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 800);

        //criação da grid para distribuição dos componentes da tela
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO RECEITA", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(tituloLabel, gbc);

        //cpf do cozinheiro
        JLabel cpfLabel = new JLabel("CPF do Cozinheiro:");
        JTextField cpfInput = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(cpfLabel, gbc);
        gbc.gridx = 1;
        panel.add(cpfInput, gbc);

        //input nome
        JLabel nomeLabel = new JLabel("Nome receita:");
        JTextField nomeInput = new JTextField(20);
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(nomeLabel, gbc);
        gbc.gridx = 2;
        panel.add(nomeInput, gbc);

        //input data TEM COMO PEGAR A DATA DIRETO DO BD NO MOMENTO DO CADASTRO? SE SIM, MELHOR!
        JLabel dataLabel = new JLabel("Data:");
        JTextField dataInput = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(dataLabel, gbc);
        gbc.gridx = 1;
        panel.add(dataInput, gbc);

        // DROPDOWN COM UM STRING DE CATEGORIAS
        JLabel categoriaLabel = new JLabel("Categoria:");
        String[] categorias = {"Categoria 1", "Categoria 2", "Categoria 3"};
        JComboBox<String> categoriaDropdown = new JComboBox<>(categorias);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(categoriaLabel, gbc);
        gbc.gridx = 1;
        panel.add(categoriaDropdown, gbc);

        // Dropdown Ingredientes
        JLabel ingredienteLabel = new JLabel("Ingrediente:");
        String[] ingredientes = {"Ingrediente 1", "Ingrediente 2", "Ingrediente 3"};
        JComboBox<String> ingredienteDropdown = new JComboBox<>(ingredientes);

        // Input Quantidade
        JLabel quantidadeLabel = new JLabel("Quantidade:");
        JTextField quantidadeInput = new JTextField(5);

        // Dropdown Medida
        JLabel medidaLabel = new JLabel("Medida:");
        String[] medidas = {"KG", "ML", "G"};
        JComboBox<String> medidaDropdown = new JComboBox<>(medidas);

        // Botão Adição
        JButton adicionarButton = new JButton("+");


        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(ingredienteLabel, gbc);
        gbc.gridx = 1;
        panel.add(ingredienteDropdown, gbc);
        gbc.gridx = 2;
        panel.add(quantidadeLabel, gbc);
        gbc.gridx = 3;
        panel.add(quantidadeInput, gbc);
        gbc.gridx = 4;
        panel.add(medidaLabel, gbc);
        gbc.gridx = 5;
        panel.add(medidaDropdown, gbc);
        gbc.gridx = 6;
        panel.add(adicionarButton, gbc);

        // Input Modo de Fazer
        JLabel modoDeFazerLabel = new JLabel("Modo de Fazer:");
        JTextArea modoDeFazerTextArea = new JTextArea(10, 40);
        modoDeFazerTextArea.setLineWrap(true);
        modoDeFazerTextArea.setWrapStyleWord(true);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(modoDeFazerLabel, gbc);
        gbc.gridx = 2;
        gbc.gridwidth = 5;
        panel.add(new JScrollPane(modoDeFazerTextArea), gbc);

        // Tabela de Ingredientes
        String[] colunas = {"Ingrediente", "Quantidade", "Medida"};
        Object[][] dados = {}; // os dados serão inseridos DINAMICAMENTE
        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        JTable tabelaIngredientes = new JTable(model);
        tabelaIngredientes.setFillsViewportHeight(true);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 7;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(tabelaIngredientes), gbc);

        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ingrediente = (String) ingredienteDropdown.getSelectedItem();
                String quantidade = quantidadeInput.getText();
                String medida = (String) medidaDropdown.getSelectedItem();
                DefaultTableModel model = (DefaultTableModel) tabelaIngredientes.getModel();
                model.addRow(new Object[]{ingrediente, quantidade, medida});
                tabelaIngredientes.setModel(model);
            }
        });

        // Botão Cadastrar
        JButton cadastrarButton = new JButton("CADASTRAR");
        cadastrarButton.setBackground(Color.GRAY);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setPreferredSize(new Dimension(400, 50));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 7;
        panel.add(cadastrarButton, gbc);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfInput.getText();
                String nome = nomeInput.getText();
                String data = dataInput.getText();
                String categoria = (String) categoriaDropdown.getSelectedItem();
                String ingrediente = (String) ingredienteDropdown.getSelectedItem();
                String quantidade = quantidadeInput.getText();
                String medida = (String) medidaDropdown.getSelectedItem();


                String result = TelaCadReceitaControle.cadastraReceita(cpf, nome, data, categoria,
                        ingrediente, quantidade, medida);
                JOptionPane.showMessageDialog(frame, result);
            }
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
