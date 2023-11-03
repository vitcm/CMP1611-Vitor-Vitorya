package telas;

import controle.TelaCadCozRestControle;
import controle.TelaCadRestauranteControle;
import controle.TelaCadastroFuncControle;
import model.Cozinheiro;
import model.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        List<Cozinheiro> cozinheiros = TelaCadastroFuncControle.listaCozinheiros();
        JComboBox<String> comboBoxCozinheiros = new JComboBox<>();
        for(Cozinheiro cozinheiro : cozinheiros) {
            String opcao = cozinheiro.getCpf() + "-" + cozinheiro.getNome();
            comboBoxCozinheiros.addItem(opcao);
        }
        camposPanel.add(comboBoxCozinheiros);

        //combobox restaurantes
        List<Restaurante> restaurantes = TelaCadRestauranteControle.getTodosRestaurantes();
        JComboBox<String> comboBoxRestaurantes = new JComboBox<>();
        for(Restaurante restaurante : restaurantes) {
            String opcao = restaurante.getCodRest() + "-" + restaurante.getNomeRest();
            comboBoxRestaurantes.addItem(opcao);
        }
        camposPanel.add(comboBoxRestaurantes);

        //input data TEM COMO PEGAR A DATA DIRETO DO BD NO MOMENTO DO CADASTRO? SE SIM, MELHOR!
        JPanel dataPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel dataLabel = new JLabel("Data");
        JTextField dataInput = new JTextField(20);
        dataPanel.add(dataLabel);
        dataPanel.add(dataInput);
        camposPanel.add(dataPanel);


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
                String[] partesCoz = cozinheiroSelecionado.split("-");
                String cpfCoz = partesCoz[0];
                String restauranteSelecionado = (String) comboBoxRestaurantes.getSelectedItem();
                String[] partesRest = restauranteSelecionado.split("-");
                String codRest = partesRest[0];
                String data = dataInput.getText();
                String result = TelaCadCozRestControle.cadastraCozinheiroEmRestaurante(cpfCoz, codRest, data);
                JOptionPane.showMessageDialog(frame, result);
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
