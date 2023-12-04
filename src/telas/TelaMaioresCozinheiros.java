package telas;

import controle.TelaMaioresCozinheirosControle;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaMaioresCozinheiros {

    public static void abreTelaMaioresCozinheiros() {
        JFrame frame = new JFrame("Top 5 Cozinheiros");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        // Título centralizado
        JLabel tituloLabel = new JLabel("Top 5 Cozinheiros", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(tituloLabel, BorderLayout.NORTH);

        // Cria uma instância do controle para buscar os dados dos maiores cozinheiros
        TelaMaioresCozinheirosControle controle = new TelaMaioresCozinheirosControle();

        // Obter o modelo da tabela preenchido com dados do banco de dados
        DefaultTableModel modelo = controle.buscarMaioresCozinheirosModeloTabela();

        // Criar tabela com modelo
        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Exibir a tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
