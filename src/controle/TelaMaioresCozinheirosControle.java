package controle;

import dao.daoCozinheiro;
import model.Cozinheiro;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TelaMaioresCozinheirosControle {

    private daoCozinheiro daoCozinheiro;

    public TelaMaioresCozinheirosControle() {
        this.daoCozinheiro = new daoCozinheiro();
    }

    public DefaultTableModel buscarMaioresCozinheirosModeloTabela() {
        List<Cozinheiro> listaCozinheiros = daoCozinheiro.buscarMaioresCozinheiros();
        String[] nomesColunas = {"Nome cozinheiro", "Nome fantasia", "CPF cozinheiros", "Quantidade de receitas criadas"};
        DefaultTableModel modeloTabela = new DefaultTableModel(nomesColunas, 0);

        for (Cozinheiro coz : listaCozinheiros) {
            Object[] dados = {
                    coz.getNome(),
                    coz.getNomeFantasia(),
                    coz.getCpf(),
                    coz.getQuantidadeReceitas()
            };
            modeloTabela.addRow(dados);
        }

        return modeloTabela;
    }
}
