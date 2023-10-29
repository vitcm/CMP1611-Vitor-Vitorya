package controle;

public class TelaCadLivroControle {
    public static String cadastraLivro(String nome, String isbn) {
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


            // CHAMAR AQUI A FUNÇÃO DO DAO QUE VAI SER CRIADA PARA INSERIR LIVROS NO DAO
            // FAZER LÁ UM BOOLEAN PARA QUE RETORNE VERDADEIRO OU FALSO (SUCESSO OU FRACASSO)

            resultado = "Cadastro realizado com sucesso!";
        }

        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z0-9]+");
    }

    public static boolean validaISBN(String cpf) {
        return cpf.matches("\\d{13}");
    }
}
