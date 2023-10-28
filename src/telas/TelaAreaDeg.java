package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TelaAreaDeg {
    public static void areaDeg() {
        JFrame frame = new JFrame("ÁREA DEGUSTADOR");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // inserindo o título da tela
        JLabel tituloLabel = new JLabel("ÁREA DEGUSTADOR", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // criando espaço central para os botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.add(botoesPanel, BorderLayout.CENTER);

        // botão para cadastro de teste
        JButton botaoTeste = new JButton("Cadastrar Teste");
        criaButton(botaoTeste);
        botaoTeste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaTeste.areaTeste();
            }
        });
        botoesPanel.add(botaoTeste);

        // Lista de testes ---> CHAMAR UM MÉTODO QUE FAÇA O GET DO BANCO DE DADOS COM TODOS OS TESTES
        String[] testes = {
                "Nome receita - nota - Nome completo do degustador",
                "Nome receita - nota - Nome completo do degustador",
                "Nome receita - nota - Nome completo do degustador"
        };
        JList<String> listaReceitas = new JList<>(testes);
        listaReceitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(listaReceitas), BorderLayout.SOUTH);

        // insere no centro da tela
        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }

    //layout do botão
    public static void criaButton(JButton botao) {
        Color minhaCor = new Color(150, 150, 150);
        botao.setBackground(minhaCor);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}
