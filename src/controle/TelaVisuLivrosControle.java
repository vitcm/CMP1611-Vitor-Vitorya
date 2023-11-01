package controle;

import dao.daoLivro;
import model.Livro;
import telas.TelaVisuLivros;

import java.util.List;
import java.util.stream.Collectors;

public class TelaVisuLivrosControle {

    private daoLivro dao;
    private TelaVisuLivros tela;

    public TelaVisuLivrosControle() {
        this.dao = new daoLivro();
    }

    public void abrirTelaDeLivros() {
        List<Livro> livrosDoBanco = dao.listarTodos();

        // Convertendo a lista de livros do banco para uma lista de strings formatada para exibição
        List<String> listaFormatada = livrosDoBanco.stream()
                .map(livro -> livro.getISBN() + " - " + livro.getTitulo())
                .collect(Collectors.toList());

        this.tela = new TelaVisuLivros(listaFormatada);
        tela.abreTelaLivros();
    }
}
