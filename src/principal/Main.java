package principal;

import telas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        renderizaTelaInicial();
    }

    public static void renderizaTelaInicial() {
        JFrame frame = new JFrame("PUBLICAÇÃO DE RECEITAS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("PUBLICAÇÃO DE RECEITAS", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.add(botoesPanel, BorderLayout.CENTER);

        // botão para cozinheiro
        JButton botaoCoz = new JButton("Área cozinheiro");
        criaButtonProfissionais(botaoCoz);
        botaoCoz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAreaCoz.areaCoz();
            }
        });
        botoesPanel.add(botaoCoz);

        // botão para cadastro de funcionarios
        JButton botaoCadastroFunc = new JButton("Cadastro Funcionario");
        criaButtonOutros(botaoCadastroFunc);
        botaoCadastroFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroFunc.areaCadFunc();
            }
        });
        botoesPanel.add(botaoCadastroFunc);

        // botão para editor
        JButton botaoEditor = new JButton("Área editor");
        criaButtonProfissionais(botaoEditor);
        botaoEditor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAreaEdit.areaEdit();
            }
        });
        botoesPanel.add(botaoEditor);

        // botão para visualizar receitas
        JButton botaoVisuReceitas = new JButton("Visualizar receitas");
        criaButtonOutros(botaoVisuReceitas);
        botaoVisuReceitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaVisuReceitas.abreTelaReceitas();
            }
        });
        botoesPanel.add(botaoVisuReceitas);

        // botão para degustador
        JButton botaoDegust = new JButton("Área degustador");
        criaButtonProfissionais(botaoDegust);
        botaoDegust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAreaDeg.areaDeg();
            }
        });
        botoesPanel.add(botaoDegust);

        // botão para visulizar livros
        JButton botaoVisuLivros = new JButton("Visualizar livros");
        criaButtonOutros(botaoVisuLivros);
        botaoVisuLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaVisuLivros.abreTelaLivros();
            }
        });
        botoesPanel.add(botaoVisuLivros);

        // botão para área de restaurante
        JButton botaoRestaurantes = new JButton("Área restaurante");
        criaButtonProfissionais(botaoRestaurantes);
        botaoRestaurantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRestaurante.areaRest();
            }
        });
        botoesPanel.add(botaoRestaurantes);

        // botão sair
        JButton sairButton = new JButton("Sair");
        criaButtonOutros(sairButton);
        Color corSair = new Color(64, 95, 135);
        sairButton.setBackground(corSair);
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        botoesPanel.add(sairButton);

        //coloca no centro da tela
        frame.setLocationRelativeTo(null);

        // exibir a tela
        frame.setVisible(true);
    }

    // cria layout para os buttons de área alguma coisa
    public static void criaButtonProfissionais(JButton botao) {
        Color minhaCor = new Color(150, 150, 150);
        botao.setBackground(minhaCor);
        botao.setBackground(Color.GRAY);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }

    // cria layout para os outros buttons
    public static void criaButtonOutros(JButton botao) {
        Color minhaCor = new Color(37, 61, 91);
        botao.setBackground(minhaCor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}