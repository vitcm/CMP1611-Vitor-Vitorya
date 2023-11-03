package controle;

import dao.daoLivro;
import model.Livro;
import telas.TelaVisuLivros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelaVisuLivrosControle {

    public static List<Livro> listaLivros() {
        List<Livro> livrosDoBanco = new ArrayList<>();
        daoLivro daolivro = new daoLivro();
        livrosDoBanco = daoLivro.listarTodos();
        return livrosDoBanco;
    }
}
