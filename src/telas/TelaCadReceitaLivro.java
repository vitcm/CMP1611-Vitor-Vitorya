package telas;

import controle.TelaCadLivroControle;
import controle.TelaCadReceitaLivroControle;
import model.Livro;
import model.Receita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCadReceitaLivro {
    public static void areaCadReceitaLivro() {
        JFrame frame = new JFrame("CADASTRO  DE RECEITA EM LIVRO");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO  DE RECEITA EM LIVRO", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os campos de texto
        JPanel camposPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //combobox receitas
        List<Receita> receitas = TelaCadReceitaLivroControle.listaReceitas();
        JComboBox<String> comboboxReceitas = new JComboBox<>();
        for(Receita receita : receitas) {
            String opcao = receita.getCodReceita() + "-" + receita.getNomeReceita();
            comboboxReceitas.addItem(opcao);
        }
        camposPanel.add(comboboxReceitas);

        //combobox Livros
        List<Livro> livros = TelaCadReceitaLivroControle.listaLivros();
        JComboBox<String> comboboxLivros = new JComboBox<>();
        for(Livro livro : livros) {
            String opcao = livro.getISBN() +"-" + livro.getTitulo();
            comboboxLivros.addItem(opcao);
        }
        camposPanel.add(comboboxLivros);

        JPanel botoesPanel = new JPanel(new BorderLayout());
        // Botão Cadastrar
        JButton cadastrarButton = new JButton("CADASTRAR");
        cadastrarButton.setBackground(Color.GRAY);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setPreferredSize(new Dimension(400, 50));

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String receitaSelecionada = (String) comboboxReceitas.getSelectedItem();
                String[] partesReceita = receitaSelecionada.split("-");
                String codReceita = partesReceita[0];
                String livroSelecionado = (String) comboboxLivros.getSelectedItem();
                String[] partesLivro = livroSelecionado.split("-");
                String isbn = partesLivro[0];
                String result = TelaCadReceitaLivroControle.cadastraReceitaEmLivro(codReceita, isbn);
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
