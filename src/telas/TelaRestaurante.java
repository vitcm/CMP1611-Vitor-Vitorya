package telas;

import dao.daoRestaurante;
import model.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaRestaurante {
    private static JFrame frame;
    private static DefaultListModel<String> listModel;

    public static void areaRest() {
        frame = new JFrame("ÁREA RESTAURANTE");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Inserindo o título da tela
        JLabel tituloLabel = new JLabel("ÁREA RESTAURANTE", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Espaço botões
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.add(botoesPanel, BorderLayout.CENTER);

        // Botão para cadastro restaurante
        JButton botaoCadastro = new JButton("Cadastrar Restaurante");
        criaButton(botaoCadastro);
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadRestaurante.areaCadRestaurante();
                // Suponha que esta ação possa atualizar a lista de restaurantes
            }
        });
        botoesPanel.add(botaoCadastro);

        // Botão para cadastrar cozinheiro em restaurante
        JButton botaoCozRest = new JButton("Cadastrar Cozinheiro em Restaurante");
        criaButton(botaoCozRest);
        botaoCozRest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadCozRest.areaCadCozRest();
            }
        });
        botoesPanel.add(botaoCozRest);

        // Botão para atualizar lista de restaurantes
        JButton botaoAtualizar = new JButton("Atualizar Lista");
        criaButton(botaoAtualizar);
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaDeRestaurantes();
            }
        });
        botoesPanel.add(botaoAtualizar);

        // Inicialize o modelo da lista e a JList
        listModel = new DefaultListModel<>();
        JList<String> listaRestaurantes = new JList<>(listModel);
        listaRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(listaRestaurantes), BorderLayout.SOUTH);

        // Atualize a lista de restaurantes
        atualizarListaDeRestaurantes();

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }

    // Método para atualizar a JList
    public static void atualizarListaDeRestaurantes() {
        daoRestaurante dao = new daoRestaurante();
        List<Restaurante> listaDeRestaurantes = dao.listarTodos();

        listModel.clear(); // Limpa o modelo da lista antes de adicionar os novos elementos
        for (Restaurante restaurante : listaDeRestaurantes) {
            String item = "Cod " + restaurante.getCodRest() + " - " + restaurante.getNomeRest();
            listModel.addElement(item);
        }
    }

    // Método para criar botões com um estilo consistente
    public static void criaButton(JButton botao) {
        botao.setBackground(Color.GRAY);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setPreferredSize(new Dimension(400, 50));
    }
}
