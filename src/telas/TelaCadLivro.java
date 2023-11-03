package telas;

import controle.TelaCadLivroControle;
import controle.TelaCadastroFuncControle;
import model.Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCadLivro {
    public static void areaCadLivro() {
        JFrame frame = new JFrame("CADASTRO LIVRO");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("CADASTRO LIVRO", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os campos de texto
        JPanel camposPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        //input nome
        JPanel nomePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel nomeLabel = new JLabel("Titulo");
        JTextField nomeInput = new JTextField(20);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeInput);
        camposPanel.add(nomePanel);

        //input ISBN
        JPanel isbnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel isbnLabel = new JLabel("ISBN");
        JTextField isbnInput = new JTextField(20);
        isbnPanel.add(isbnLabel);
        isbnPanel.add(isbnInput);
        camposPanel.add(isbnPanel);

        //combobox editores
        List<Editor> editores = TelaCadLivroControle.listaEditores();
        JComboBox<String> comboboxEditores = new JComboBox<>();
        for (Editor editor : editores) {
            String opcao = editor.getCpf() + "-" + editor.getNome();
            comboboxEditores.addItem(opcao);
        }
        camposPanel.add(comboboxEditores);

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
                String isbn = isbnInput.getText();
                String editorSelecionado = (String) comboboxEditores.getSelectedItem();
                String[] partes = editorSelecionado.split("-");
                String cpf = partes[0];
                String result = TelaCadLivroControle.cadastraLivro(nome, isbn, cpf);
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
