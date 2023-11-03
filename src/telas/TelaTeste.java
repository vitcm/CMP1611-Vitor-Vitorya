package telas;

import controle.*;
import model.Cozinheiro;
import model.Degustador;
import model.Receita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        //combobox degustadores
        List<Degustador> degustadores = TelaAreaDegControle.listaDegustadores();
        JComboBox<String> comboBoxDegustadores = new JComboBox<>();
        for(Degustador degustador : degustadores) {
            String opcao = degustador.getCpf() + "-" + degustador.getNome();
            comboBoxDegustadores.addItem(opcao);
        }
        camposPanel.add(comboBoxDegustadores);

        //combobox receitas
        List<Receita> receitas = TelaCadReceitaLivroControle.listaReceitas();
        JComboBox<String> comboboxReceitas = new JComboBox<>();
        for(Receita receita : receitas) {
            String opcao = receita.getCodReceita() + "-" + receita.getNomeReceita();
            comboboxReceitas.addItem(opcao);
        }
        camposPanel.add(comboboxReceitas);

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

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String degustSelecionado = (String) comboBoxDegustadores.getSelectedItem();
                String[] partesdegust = degustSelecionado.split("-");
                String cpfDegust = partesdegust[0];
                String receitaSelecionada = (String) comboboxReceitas.getSelectedItem();
                String[] partesReceita = receitaSelecionada.split("-");
                String codReceita = partesReceita[0];
                String data = dataInput.getText();
                String nota = notaInput.getText();

                String result = TelaTesteControle.cadastraTeste(cpfDegust, codReceita, data, nota);
                JOptionPane.showMessageDialog(frame, result);
            }
        });

        frame.add(camposPanel, BorderLayout.CENTER);
        frame.add(botoesPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
