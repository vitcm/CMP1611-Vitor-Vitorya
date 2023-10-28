package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAreaCoz {
    public static void areaCoz() {
        JFrame frame = new JFrame("ÁREA COZINHEIRO");
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("ÁREA COZINHEIRO", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.add(botoesPanel, BorderLayout.CENTER);

        // botão para cadastro eceita
        JButton botaoReceita = new JButton("Cadastrar Receita");
        criaButton(botaoReceita);
        botaoReceita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadReceita.areaCadReceita();
            }
        });
        botoesPanel.add(botaoReceita);

        // botão para cadastro de ingredientes
        JButton botaoIngredientes = new JButton("Cadastrar Ingredientes");
        criaButton(botaoIngredientes);
        botaoIngredientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadIngrediente.areaCadIngred();
            }
        });
        botoesPanel.add(botaoIngredientes);

        // botão para cadastro de categorias
        JButton botaoCategoria = new JButton("Cadastrar Categorias");
        criaButton(botaoCategoria);
        botaoCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadCategorias.areaCadCategorias();
            }
        });
        botoesPanel.add(botaoCategoria);

        //coloca no centro da tela
        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }

    //layout dos botões
    public static void criaButton(JButton botao) {
        Color minhaCor = new Color(150, 150, 150);
        botao.setBackground(minhaCor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}
