package telas;

import controle.TelaTesteControle;
import dao.daoRestaurante;
import model.Restaurante;
import model.Teste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaAreaDeg {

    private static DefaultListModel<String> listModel;
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

        // Botão para atualizar lista de restaurantes
        JButton botaoAtualizar = new JButton("Atualizar Lista");
        criaButton(botaoAtualizar);
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaDeTestes();
            }
        });
        botoesPanel.add(botaoAtualizar);


        // Inicialize o modelo da lista e a JList
        listModel = new DefaultListModel<>();
        JList<String> listaTestes = new JList<>(listModel);
        listaTestes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(listaTestes), BorderLayout.SOUTH);

        // Atualize a lista de testes
        atualizarListaDeTestes();


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

    public static void atualizarListaDeTestes() {
        List<Teste> listaDeTestes = TelaTesteControle.listatestes();

        listModel.clear(); // Limpa o modelo da lista antes de adicionar os novos elementos
        for (Teste teste : listaDeTestes) {
            String item = "Receita " + teste.getCodReceita()+ " - Data " + teste.getDataTeste() +" - Nota " + teste.getNota();
            listModel.addElement(item);
        }
    }
}
