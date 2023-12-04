package principal;

import dao.daoLivro;
import model.Livro;
import telas.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        renderizaTelaInicial();
    }

    public static void renderizaTelaInicial() {
        JFrame frame = new JFrame("PUBLICAÇÃO DE RECEITAS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("PUBLICAÇÃO DE RECEITAS", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.add(botoesPanel, BorderLayout.CENTER);

        JButton botaoCoz = new JButton("Área cozinheiro");
        criaButtonProfissionais(botaoCoz);
        botaoCoz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAreaCoz.areaCoz();
            }
        });
        botoesPanel.add(botaoCoz);

        JButton botaoCadastroFunc = new JButton("Cadastro Funcionario");
        criaButtonOutros(botaoCadastroFunc);
        botaoCadastroFunc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroFunc.areaCadFunc();
            }
        });
        botoesPanel.add(botaoCadastroFunc);

        JButton botaoEditor = new JButton("Área editor");
        criaButtonProfissionais(botaoEditor);
        botaoEditor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAreaEdit.areaEdit();
            }
        });
        botoesPanel.add(botaoEditor);

        JButton botaoVisuReceitas = new JButton("Visualizar receitas");
        criaButtonOutros(botaoVisuReceitas);
        botaoVisuReceitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaVisuReceitas.abreTelaReceitas();
            }
        });
        botoesPanel.add(botaoVisuReceitas);

        JButton botaoDegust = new JButton("Área degustador");
        criaButtonProfissionais(botaoDegust);
        botaoDegust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAreaDeg.areaDeg();
            }
        });
        botoesPanel.add(botaoDegust);

        JButton botaoVisuLivros = new JButton("Visualizar livros");
        criaButtonOutros(botaoVisuLivros);
        botaoVisuLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daoLivro newLivro = new daoLivro();
                List<Livro> livrosList = newLivro.listarTodos();

                List<String> titulos = new ArrayList<>();
                for (Livro livro : livrosList) {
                    titulos.add(livro.getTitulo());
                }

                TelaVisuLivros tela = new TelaVisuLivros();
                tela.abreTelaLivros();
            }
        });
        botoesPanel.add(botaoVisuLivros);

        JButton botaoRestaurantes = new JButton("Área restaurante");
        criaButtonProfissionais(botaoRestaurantes);
        botaoRestaurantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRestaurante.areaRest();
            }
        });
        botoesPanel.add(botaoRestaurantes);

        JButton botaoMaioresCozinheiros = new JButton("Maiores Cozinheiros");
        criaButtonOutros(botaoMaioresCozinheiros);
        botaoMaioresCozinheiros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaMaioresCozinheiros tela = new TelaMaioresCozinheiros();
                tela.abreTelaMaioresCozinheiros();
            }
        });
        botoesPanel.add(botaoMaioresCozinheiros);

        JButton botaoReceitaPorCategoria = new JButton("Área receitas por categorias");
        criaButtonProfissionais(botaoReceitaPorCategoria);
        botaoReceitaPorCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaReceitaPorCategorias tela = new TelaReceitaPorCategorias();
                tela.abreTelaReceitaPorCategoria();
            }
        });
        botoesPanel.add(botaoReceitaPorCategoria);

        JButton botaoDegustadorPorIngrediente = new JButton("Ingrediente por degustador");
        criaButtonOutros(botaoDegustadorPorIngrediente);
        botaoDegustadorPorIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDegustadorPorIngrediente tela = new TelaDegustadorPorIngrediente();
                tela.abreTelaDegustadorPorIngrediente();
            }
        });
        botoesPanel.add(botaoDegustadorPorIngrediente);

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

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public static void criaButtonProfissionais(JButton botao) {
        Color minhaCor = new Color(150, 150, 150);
        botao.setBackground(minhaCor);
        botao.setBackground(Color.GRAY);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }

    public static void criaButtonOutros(JButton botao) {
        Color minhaCor = new Color(37, 61, 91);
        botao.setBackground(minhaCor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}