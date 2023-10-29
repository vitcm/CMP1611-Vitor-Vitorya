package controle;

public class TelaCadIngredienteControle {
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

            // CHAMAR AQUI A FUNÇÃO DO DAO QUE VAI SER CRIADA PARA INSERIR CATEGORIA NO DAO
            // FAZER LÁ UM BOOLEAN PARA QUE RETORNE VERDADEIRO OU FALSO

            resultado = "Cadastro realizado com sucesso!";
        }

        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z]+");
    }
}
