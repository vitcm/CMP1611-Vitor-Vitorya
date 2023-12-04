package controle;

import dao.daoCategoria;

import javax.swing.table.DefaultTableModel;

public class TelaReceitaPorCategoriasControle {

    private daoCategoria categoriadao;

    public TelaReceitaPorCategoriasControle() {
        this.categoriadao = new daoCategoria();
    }

    public DefaultTableModel buscarReceitasPorCategoriaModeloTabela() {
        return daoCategoria.buscarReceitasPorCategoria();
    }
}
