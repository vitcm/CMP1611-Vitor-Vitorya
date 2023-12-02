package telas;

import controle.TelaCadIngredienteControle;
import model.Ingrediente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaDegustadorPorIngrediente {

    public static void abreTelaDegustadorPorIngrediente() {
        JFrame frame = new JFrame("Testes por Ingredientes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);

        // Criação da grid para distribuição dos componentes da tela
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Inserindo o título da tela
        JLabel tituloLabel = new JLabel("Testes por Ingredientes", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panel.add(tituloLabel, gbc);

        // Dropdown Ingredientes
        String[] opcoesIngredientes = {"Ing 1", "Ing 2", "Ing 3"};
        JComboBox<String> ingredienteDropdown = new JComboBox<>(opcoesIngredientes);

        // Botão Adição
        JButton adicionarButton = new JButton("+");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridx = 1;
        panel.add(ingredienteDropdown, gbc);
        gbc.gridx = 2;
        gbc.gridx = 3;
        gbc.gridx = 4;
        gbc.gridx = 5;
        gbc.gridx = 6;
        panel.add(adicionarButton, gbc);

        // Tabela de Ingredientes
        String[] colunas = {"Ingrediente"};
        Object[][] dados = {}; // Os dados serão inseridos DINAMICAMENTE
        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        JTable tabelaIngredientes = new JTable(model);
        tabelaIngredientes.setFillsViewportHeight(true);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 7;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(new JScrollPane(tabelaIngredientes), gbc);

        adicionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ingrediente = (String) ingredienteDropdown.getSelectedItem();
                model.addRow(new Object[]{ingrediente});
            }
        });

        // Botão PESQUISAR
        JButton pesquisarButton = new JButton("PESQUISAR");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 7;
        panel.add(pesquisarButton, gbc);

        pesquisarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicione aqui a lógica para realizar a pesquisa com os ingredientes selecionados
                // e exibir os resultados na tabela principal
            }
        });

        // Tabela principal
        String[] colunasTabela = {"Ingredientes Selecionados", "Degustador", "Receita", "Nota"};
        DefaultTableModel mainTableModel = new DefaultTableModel(colunasTabela, 0);
        JTable mainTable = new JTable(mainTableModel);
        JScrollPane mainScrollPane = new JScrollPane(mainTable);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 7;
        gbc.weighty = 1.0;
        panel.add(mainScrollPane, gbc);

        // Exibir a tela
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
