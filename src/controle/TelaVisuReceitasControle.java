package controle;

import dao.daoReceita;
import model.Receita;

import java.util.List;

public class TelaVisuReceitasControle {

    private daoReceita dao;

    public TelaVisuReceitasControle() {
        dao = new daoReceita();
    }

    public List<Receita> buscarTodasReceitas() {
        return dao.listarTodos();
    }

    public void adicionarReceita(Receita receita) {
        dao.inserir(receita);
    }

    public void atualizarReceita(Receita receita) {
        dao.atualizar(receita);
    }

    public void removerReceita(int codReceita) {
        dao.excluir(codReceita);
    }
}
