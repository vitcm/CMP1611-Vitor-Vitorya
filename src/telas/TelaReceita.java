package telas;

import dao.daoReceita;
import model.Receita;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaReceita {



    public static void areaReceita(int codReceita) {
        daoReceita dao = new daoReceita();
        Receita receita = dao.buscarPorId(codReceita);

        // Verificar se a receita foi encontrada
        if (receita == null) {
            JOptionPane.showMessageDialog(null, "Receita não encontrada!");
            return;
        }

        // Buscar nome do cozinheiro e outros detalhes
        String nomeCozinheiro = dao.buscarNomeCozinheiro(receita.getCodCozinheiro());
        String modoPreparo = receita.getDescricaoPreparacao();

        List<String> ingredientes = dao.buscarIngredientesPorIdReceita(codReceita);

        JFrame frame = new JFrame(receita.getNomeReceita());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel(receita.getNomeReceita() + " - " + nomeCozinheiro, SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Lista de ingredientes
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String ingrediente : ingredientes) {
            listModel.addElement(ingrediente);
        }
        JList<String> listaIngredientesReceita = new JList<>(listModel);
        listaIngredientesReceita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        frame.add(new JScrollPane(listaIngredientesReceita), BorderLayout.CENTER);

        // Inserir o modo de preparo da receita
        JTextArea modoPreparoText = new JTextArea(modoPreparo);
        modoPreparoText.setWrapStyleWord(true);
        modoPreparoText.setLineWrap(true);
        modoPreparoText.setEditable(false);
        modoPreparoText.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(new JScrollPane(modoPreparoText), BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        // Exibir a tela
        frame.setVisible(true);
    }

}
