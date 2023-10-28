package controle;

public class TelaCadCozRestControle {
    public static String cadastraCozinheiroEmRestaurante(String cozinheiro, String restaurante) {
        String resultado = "";

        if(cozinheiro.isEmpty() || restaurante.isEmpty()) {
            resultado = "Os campos são obrigatórios.";
            return resultado;
        } else {
            if (!validaNome(cozinheiro)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }
            if (!validaNome(restaurante)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }

            // CHAMAR AQUI A FUNÇÃO DO DAO QUE VAI SER CRIADA PARA INSERIR OS DADOS
            // FAZER LÁ UM BOOLEAN PARA QUE RETORNE VERDADEIRO OU FALSO

            resultado = "Cadastro realizado com sucesso!";
        }

        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z]+");
    }
}
