package controle;

import dao.daoDegustador;
import dao.daoTeste;
import model.Degustador;
import model.Teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelaTesteControle {
    public static String cadastraTeste(String cpfDegust, String codReceita, String data, String nota) {
        String resultado = "";

        if(cpfDegust.isEmpty() || codReceita.isEmpty() || nota.isEmpty() || data.isEmpty()) {
            resultado = "Os campos cpf, receita, data e nota são obrigatórios.";
            return resultado;
        } else {
            if (!validaNota(nota)) {
                resultado = "Favor inserir uma nota válida";
                return resultado;
            }
            if (!validaData(data)) {
                resultado = "Favor inserir uma data válida";
                return resultado;
            }

            // Parse the date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataTeste;
            try {
                dataTeste = sdf.parse(data);
            } catch (ParseException e) {
                return "Formato de data inválido.";
            }

            Teste teste = new Teste();
            teste.setCodReceita(Integer.parseInt(codReceita));
            teste.setCpfDegustador(cpfDegust);
            teste.setDataTeste(dataTeste);
            teste.setNota(Integer.parseInt(nota));

            daoTeste daoteste = new daoTeste();
            boolean inseridoComSucesso = daoteste.inserir(teste);

            if (inseridoComSucesso) {
                resultado = "Cadastro realizado com sucesso!";
            } else {
                resultado = "Não foi possível realizar o cadastro.";
            }
        }

        return resultado;
    }
    public static boolean validaData(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }
    public static boolean validaNota(String salario) {
        return salario.matches("[0-9]+");
    }

    public static List<Teste> listatestes(){
        List<Teste> testes = new ArrayList<>();
        daoTeste daoteste = new daoTeste();
        testes = daoteste.listarTodos();
        return testes;
    }
}
