package controle;

public class TelaCadastroFuncControle {
    public static String cadastraFuncionario(String nome, String cpf, String data, String salario, String cargo, String nomeFantasia) {
        String resultado = "";

        if(nome.isEmpty() || cpf.isEmpty() || data.isEmpty()) {
            resultado = "Os campos nome, cpf e data são obrigatórios.";
            return resultado;
        } else {
            if (!validaNome(nome)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }
            if (!validaCPF(cpf)) {
                resultado = "Favor inserir um CPF válido";
                return resultado;
            }
            if (!validaData(data)) {
                resultado = "Favor inserir uma data válida";
                return resultado;
            }
            if (!validaSalario(salario)) {
                resultado = "Favor inserir um valor válido";
                return resultado;
            }

            // CHAMAR AQUI A FUNÇÃO DO DAO QUE VAI SER CRIADA PARA INSERIR FUNCIONARIOS NO DAO
            // FAZER LÁ UM BOOLEAN PARA QUE RETORNE VERDADEIRO OU FALSO

            resultado = "Cadastro realizado com sucesso!";
        }

        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z]+");
    }

    public static boolean validaCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }

    public static boolean validaData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean validaSalario(String salario) {
        return salario.matches("[0-9,.]+");
    }
}
