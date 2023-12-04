package telas;

import controle.TelaCadIngredienteControle;
import controle.TelaDegustadorPorIngredienteControle;
import dao.daoIngrediente;
import model.Ingrediente;
import model.Teste;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaDegustadorPorIngrediente {

    private static JComboBox<String> ingredienteDropdown;
    private daoIngrediente ingredienteDao;

    public TelaDegustadorPorIngrediente() {
        ingredienteDao = new daoIngrediente();
        initializeComponents();
        loadIngredientesFromDatabase();
    }

    private void initializeComponents() {
        // Inicialize o JComboBox
        ingredienteDropdown = new JComboBox<>();
    }

    private void loadIngredientesFromDatabase() {
        List<Ingrediente> ingredientes = ingredienteDao.listarTodos();
        for (Ingrediente ingrediente : ingredientes) {
            ingredienteDropdown.addItem(ingrediente.getNomeIngrediente());
        }
    }

    public static void abreTelaDegustadorPorIngrediente() {
        JFrame frame = new JFrame("Testes por Ingredientes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);

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

        TelaDegustadorPorIngrediente tela = new TelaDegustadorPorIngrediente();

        // Botão Adição
        JButton adicionarButton = new JButton("+");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridx = 1;
        panel.add(tela.ingredienteDropdown, gbc);
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

        // Tabela principal
        String[] colunasTabela = {"Ingredientes Selecionados", "Degustador", "Receita", "Nota"};
        DefaultTableModel mainTableModel = new DefaultTableModel(colunasTabela, 0);
        JTable mainTable = new JTable(mainTableModel);
        JScrollPane mainScrollPane = new JScrollPane(mainTable);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 7;
        gbc.weighty = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(mainScrollPane, gbc);

        pesquisarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tabelaIngredientes.getRowCount() < 2) {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecione dois ingredientes.");
                    return;
                }
                String ingredienteX = (String) tabelaIngredientes.getValueAt(0, 0);
                String ingredienteY = (String) tabelaIngredientes.getValueAt(1, 0);

                TelaDegustadorPorIngredienteControle controle = new TelaDegustadorPorIngredienteControle();
                List<Teste> resultados = controle.buscarTestesPorIngredientes(ingredienteX, ingredienteY);

                mainTableModel.setRowCount(0);

                for (Teste teste : resultados) {
                    // Agora você pode usar os getters para obter o nome do testador e o nome da receita
                    mainTableModel.addRow(new Object[]{
                            ingredienteX + ", " + ingredienteY,
                            teste.getNomeTestador(), // Adiciona o nome do testador
                            teste.getNomeReceita(), // Adiciona o nome da receita
                            teste.getNota() // Adiciona a nota
                    });
                }
            }
        });

        // Exibir a tela
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}