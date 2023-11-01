package controle;

import dao.daoCategoria;
import model.Categoria;

public class TelaCadCategoriasControle {

    public static String cadastraCategoria(String nome) {
        String resultado = "";

        if (nome.isEmpty()) {
            resultado = "O nome da categoria é obrigatório";
            return resultado;
        } else {
            if (!validaNome(nome)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }

            Categoria newCategoria = new Categoria(nome);
            daoCategoria dao = new daoCategoria();
            boolean inseridoComSucesso = dao.inserir(newCategoria);

            if (inseridoComSucesso) {
                resultado = "Cadastro realizado com sucesso!";
            } else {
                resultado = "Erro ao tentar cadastrar categoria. Por favor, tente novamente.";
            }
        }

        return resultado;
    }
    
    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z]+");
    }
}
