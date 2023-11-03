package controle;

import dao.daoReceita;
import model.Receita;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadReceitaControle {
    public static String cadastraReceita( String cpf, String nome, String data,
                                          String categoria, String quantidade,
                                          String medida, String modoDeFazer) {
        String resultado = "";

        if(nome.isEmpty() || cpf.isEmpty() || data.isEmpty() || categoria.isEmpty()
                || quantidade.isEmpty() || medida.isEmpty()) {
            resultado = "Os campos cpf, nome, data, categoria, quantidade e medida são obrigatórios.";
            return resultado;
        } else {
            if (!validaNome(nome)) {
                resultado = "Favor inserir um nome válido";
                return resultado;
            }
            if (!validaData(data)) {
                resultado = "Favor inserir uma data válida";
                return resultado;
            }
            if (!validaQtde(quantidade)) {
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

            Receita receita = new Receita();
            receita.setNomeReceita(nome);
            receita.setCodCozinheiro(cpf);
            receita.setCodCategoria(Integer.parseInt(categoria));
            receita.setDataInventada(dataIngresso);
            receita.setDescricaoPreparacao(modoDeFazer);
            receita.setNumPorcoes(Integer.parseInt(quantidade));

            daoReceita daoreceita = new daoReceita();
            boolean inseridoComSucesso = daoreceita.inserir(receita);

            if (inseridoComSucesso) {
                resultado = "Cadastro realizado com sucesso!";
            } else {
                resultado = "Não foi possível realizar o cadastro.";
            }
        }

        return resultado;
    }

    public static boolean validaNome(String nome) {
        return nome.matches("[a-zA-Z ]+");
    }

    public static boolean validaData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public static boolean validaQtde(String salario) {
        return salario.matches("[0-9,.]+");
    }
}
