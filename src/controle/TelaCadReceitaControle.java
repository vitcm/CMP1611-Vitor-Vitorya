package controle;

public class TelaCadReceitaControle {
    public static String cadastraReceita( String cpf, String nome, String data,
                                          String categoria, String ingrediente,
                                          String quantidade, String medida) {
        String resultado = "";

        if(nome.isEmpty() || cpf.isEmpty() || data.isEmpty() || categoria.isEmpty() ||
                ingrediente.isEmpty() || quantidade.isEmpty() || medida.isEmpty()) {
            resultado = "Os campos cpf, nome, data, categoria, ingrediente, quantidade e medida são obrigatórios.";
            return resultado;
        } else {
            if (!validaNome(nome)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }
            String cpfvalidacao = validaCPF(cpf); //ARRUMAR A VALIDAÇÃO DO CPF
            if(!cpfvalidacao.equals("ok")){
                resultado = cpfvalidacao;
            }
            if (!validaData(data)) {
                resultado = "Favor inserir uma data válida";
                return resultado;
            }
            if (!validaQtde(quantidade)) {
                resultado = "Favor inserir um valor válido";
                return resultado;
            }

            //CATEGORIA, INGREDIENTE E MEDIDA JÁ VÃO SER VALIDADOS ANTES, JÁ QUE É UM COMBOBOX DO QUE ESTÁ PRESENTE NO BD.

            // CHAMAR AQUI A FUNÇÃO DO DAO QUE VAI SER CRIADA PARA INSERIR A RECEITA NO DAO
            // FAZER LÁ UM BOOLEAN PARA QUE RETORNE VERDADEIRO OU FALSO

            // DAO DE INGREDIENTE/RECEITA PARA A QTDE E MEDIDA
            // OS OUTROS DADOS VÃO PARA O DAO DE RECEITA

            resultado = "Cadastro realizado com sucesso!";
        }

        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z]+");
    }

    public static String validaCPF(String cpf) {
        String vCPF = "";
        if(!cpf.matches("\\d{11}")) {
            vCPF="Favor inserir um CPF válido.";
        } else{ // criar um if aqui?
            // O CPF PRECISA EXISTIR NO SISTEMA. ENTÃO AQUI CHAMAR UMA FUNÇÃO DO DAO QUE
            // PROCURE O CPF ESPECÍFICO. SE DER FALSO, RETORNAR vCPF="Favor inserir um CPF cadastrado no sistema.";
        } // INSERIR UM ÚLTIMO ELSE QUE RETORNA O vCPF="ok"
        return vCPF;
    }


    public static boolean validaData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean validaQtde(String salario) {
        return salario.matches("[0-9,.]+");
    }
}
