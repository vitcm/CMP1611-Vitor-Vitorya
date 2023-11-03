package telas;

import controle.TelaCadCategoriasControle;
import controle.TelaCadIngredienteControle;
import controle.TelaCadReceitaControle;
import controle.TelaCadastroFuncControle;
import model.Categoria;
import model.Cozinheiro;
import model.Ingrediente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaCadReceita {
    public static void areaCadReceita() {
        JFrame frame = new JFrame("CADASTRO RECEITA");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 800);

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
        JLabel cpfLabel = new JLabel("Cozinheiro:");
        //combobox cozinheiros
        List<Cozinheiro> cozinheiros = TelaCadastroFuncControle.listaCozinheiros();
        JComboBox<String> comboBoxCozinheiros = new JComboBox<>();
        for(Cozinheiro cozinheiro : cozinheiros) {
            String opcao = cozinheiro.getCpf() + "-" + cozinheiro.getNome();
            comboBoxCozinheiros.addItem(opcao);
        }
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(cpfLabel, gbc);
        gbc.gridx = 1;
        panel.add(comboBoxCozinheiros, gbc);

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
        List<Categoria> categorias = TelaCadCategoriasControle.listaCategorias();
        JComboBox<String> categoriaDropdown = new JComboBox<>();
        for(Categoria categoria : categorias) {
            String opcao = categoria.getCodCategoria()+"-"+categoria.getDescCategoria();
            categoriaDropdown.addItem(opcao);
        }
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(categoriaLabel, gbc);
        gbc.gridx = 1;
        panel.add(categoriaDropdown, gbc);

        // Dropdown Ingredientes
        JLabel ingredienteLabel = new JLabel("Ingrediente:");
        List<Ingrediente> ingredientes = TelaCadIngredienteControle.listaIngredientes();
        JComboBox<String> ingredienteDropdown = new JComboBox<>();
        for(Ingrediente ingrediente : ingredientes) {
            String opcao = ingrediente.getCodIngrediente() + "-" + ingrediente.getNomeIngrediente();
            ingredienteDropdown.addItem(opcao);
        }

        // Input Quantidade
        JLabel quantidadeLabel = new JLabel("Quantidade:");
        JTextField quantidadeInput = new JTextField(5);

        // Dropdown Medida
        JLabel medidaLabel = new JLabel("Medida:");
        String[] medidas = {"KG", "ML", "G", "Colher(sopa)", "Colher(chá)", "Xícara"};
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
                String cozinheiroSelecionado = (String) comboBoxCozinheiros.getSelectedItem();
                String[] partesCoz = cozinheiroSelecionado.split("-");
                String cpfCoz = partesCoz[0];
                String nome = nomeInput.getText();
                String data = dataInput.getText();
                String categoria = (String) categoriaDropdown.getSelectedItem();
                String[] partesCat = categoria.split("-");
                String codCat = partesCat[0];
                String ingrediente = (String) ingredienteDropdown.getSelectedItem();
                String[] partesIng = ingrediente.split("-");
                String codIng = partesIng[0];
                String quantidade = quantidadeInput.getText();
                String medida = (String) medidaDropdown.getSelectedItem();
                String modoDeFazer = modoDeFazerTextArea.getText();


                String result = TelaCadReceitaControle.cadastraReceita(cpfCoz, nome, data, codCat,
                         quantidade, medida, modoDeFazer);
                JOptionPane.showMessageDialog(frame, result);

                DefaultTableModel model = (DefaultTableModel) tabelaIngredientes.getModel();
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String ingredienteRec = (String) model.getValueAt(i, 0);
                    String quantidadeIng = (String) model.getValueAt(i, 1);
                    String medidaIng = (String) model.getValueAt(i, 2);
                }
            }
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
