package controle;
import dao.daoIngrediente;
import dao.daoLivro;
import model.Ingrediente;
import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class TelaCadIngredienteControle {

    private static daoIngrediente dao = new daoIngrediente();

    public static String cadastraIngrediente(String nome) {
        String resultado = "";

        if(nome.isEmpty()) {
            resultado = "O nome do ingrediente é obrigatório";
            return resultado;
        } else {
            if (!validaNome(nome)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }

            Ingrediente novoIngrediente = new Ingrediente(nome, "");
            daoIngrediente dao = new daoIngrediente();
            boolean inserido = dao.inserir(novoIngrediente);


            if (!inserido) {
                resultado = "Erro ao realizar cadastro. Tente novamente.";
                return resultado;
            } else {
                resultado = "Cadastro realizado com sucesso!";
            }
        }

        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z ]+");  // Updated regex to include spaces for names with multiple words.
    }
    public static List<Ingrediente> listaIngredientes() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        daoIngrediente daoingrediente = new daoIngrediente();
        ingredientes = daoingrediente.listarTodos();
        return ingredientes;
    }

}
