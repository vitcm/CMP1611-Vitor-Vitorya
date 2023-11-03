package controle;

import dao.daoReceitaLivro;
import model.ReceitaLivro;

import java.util.ArrayList;
import java.util.List;

public class TelaLivroControle {
    public static List<String> listaReceitasPorLivro(String isbn) {
        return daoReceitaLivro.obterReceitasPorISBN(isbn);
    }
}
