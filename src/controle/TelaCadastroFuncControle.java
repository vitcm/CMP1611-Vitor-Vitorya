package controle;

import dao.daoCozinheiro;
import dao.daoDegustador;
import dao.daoEditor;
import model.Cozinheiro;
import model.Degustador;
import model.Editor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadastroFuncControle {
    public static String cadastraFuncionario(String nome, String cpf, String data, String salario, String cargo, String nomeFantasia) {
        String resultado = "";

        if (nome.isEmpty() || cpf.isEmpty() || data.isEmpty()) {
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
            // Parse the date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataIngresso;
            try {
                dataIngresso = sdf.parse(data);
            } catch (ParseException e) {
                return "Formato de data inválido.";
            }

            // Parse the salary
            BigDecimal salarioConvertido;
            try {
                salarioConvertido = new BigDecimal(salario.replace(",", "."));
            } catch (NumberFormatException e) {
                return "Formato de salário inválido.";
            }


            boolean inseridoComSucesso = false;

            if (cargo.equals("Editor")) {
                Editor editor = new Editor(cpf, nome, dataIngresso, salarioConvertido);
                daoEditor dao = new daoEditor();
                inseridoComSucesso = dao.inserir(editor);
            } else if (cargo.equals("Degustador")) {
                Degustador degustador = new Degustador(cpf, nome, dataIngresso, salarioConvertido);
                daoDegustador daoDegustador = new daoDegustador();
                inseridoComSucesso = daoDegustador.inserir(degustador);
            } else if (cargo.equals("Cozinheiro")) {
                Cozinheiro cozinheiro = new Cozinheiro(cpf, nome, dataIngresso, salarioConvertido, nomeFantasia);
                daoCozinheiro daoCozinheiro = new daoCozinheiro();
                inseridoComSucesso = daoCozinheiro.inserir(cozinheiro);
            }

            if (inseridoComSucesso) {
                resultado = "Cadastro realizado com sucesso!";
            } else {
                resultado = "Não foi possível realizar o cadastro.";
            }

            return resultado;
        }
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
