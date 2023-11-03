package controle;

import dao.daoLivro;
import dao.daoReceita;
import dao.daoReceitaLivro;
import model.Livro;
import model.Receita;
import model.ReceitaLivro;

import java.util.ArrayList;
import java.util.List;

public class TelaCadReceitaLivroControle {

    public static String cadastraReceitaEmLivro(String codigo, String isbn) {
        String resultado = "";

        if(codigo.isEmpty() || isbn.isEmpty() ) {
            resultado = "Os campos Receita e Livro são obrigatórios.";
            return resultado;
        }
            ReceitaLivro receitaLivro = new ReceitaLivro();
            receitaLivro.setCodReceita(Integer.parseInt(codigo));
            receitaLivro.setIsbn(isbn);

            daoReceitaLivro daoReceitaLivro = new daoReceitaLivro();
            boolean inseridoComSucesso = daoReceitaLivro.inserir(receitaLivro);

            if (inseridoComSucesso) {
                resultado = "Cadastro realizado com sucesso!";
            } else {
                resultado = "Não foi possível realizar o cadastro.";
            }
        return resultado;
    }
    public static List<Livro> listaLivros() {
        List<Livro> livros = new ArrayList<>();
        daoLivro daolivro = new daoLivro();
        livros = daolivro.listarTodos();
        return livros;
    }

    public static List<Receita> listaReceitas() {
        List<Receita> receitas = new ArrayList<>();
        daoReceita daoreceita = new daoReceita();
        receitas = daoreceita.listarTodos();
        return receitas;
    }
}
