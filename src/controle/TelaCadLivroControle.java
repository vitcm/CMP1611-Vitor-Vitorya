package controle;

import dao.daoEditor;
import dao.daoLivro;
import model.Editor;
import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class TelaCadLivroControle {
    public static String cadastraLivro(String nome, String isbn, String cpf) {
        String resultado = "";

        if(nome.isEmpty() || isbn.isEmpty() ) {
            resultado = "Os campos nome e ISBN são obrigatórios.";
            return resultado;
        } else {
            if (!validaNome(nome)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }
            if (!validaISBN(isbn)) {
                resultado = "Favor inserir um ISBN válido";
                return resultado;
            }

            Livro livro = new Livro();
            livro.setISBN(isbn);
            livro.setTitulo(nome);
            livro.setCpfEditor(cpf);
            daoLivro daolivro = new daoLivro();

            boolean inseridoComSucesso = daolivro.inserir(livro);

            if (inseridoComSucesso) {
                resultado = "Cadastro realizado com sucesso!";
            } else {
                resultado = "Não foi possível realizar o cadastro.";
            }
        }
        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z0-9 ]+");
    }

    public static boolean validaISBN(String cpf) {
        return cpf.matches("\\d{13}");
    }

    public static List<Editor> listaEditores(){
        List<Editor> editores = new ArrayList<>();
        daoEditor daoeditor = new daoEditor();
        editores = daoeditor.listarTodos();
        return editores;
    }
}
