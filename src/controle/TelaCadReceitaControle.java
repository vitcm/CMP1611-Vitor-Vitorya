package controle;

import dao.daoIngredientesReceita;
import dao.daoReceita;
import model.IngredientesReceita;
import model.Receita;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadReceitaControle {

    public static String cadastraReceitaEIngredientes(String cpf, String nome, String data,
                                                      String categoria, String quantidade,
                                                      String medida, String modoDeFazer, String ingredientes) {
        String resultado = "";

        if (nome.isEmpty() || cpf.isEmpty() || data.isEmpty() || categoria.isEmpty()
                || quantidade.isEmpty() || medida.isEmpty() || ingredientes.isEmpty()) {
            resultado = "Os campos cpf, nome, data, categoria, ingrediente, quantidade e medida são obrigatórios.";
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

            String cadastraReceita = cadastraReceita(cpf, nome, dataIngresso, categoria, quantidade, modoDeFazer);
            int codReceita=0;
            if(cadastraReceita.equals("Cadastro realizado com sucesso!")) {
                codReceita = daoReceita.buscarCodReceitaPorNome(nome);
            }
        String cadastraIngredientes = "";
            if(codReceita != -1) {
                cadastraIngredientes = cadastraIngredientePorReceita(codReceita, ingredientes);
            }

            if (cadastraReceita.equals("Não foi possível realizar o cadastro") ||
                    cadastraIngredientes.contains("Estrutura de dados do ingrediente incorreta")) {
                resultado = "Falha no cadastro da receita";
            } else {
                resultado = "Cadastro feito com sucesso!";
            }

            return resultado;
        }
    }
    public static String cadastraReceita( String cpf, String nome, Date dataIngresso,
                                          String categoria, String quantidade,
                                          String modoDeFazer) {
        String resultado = "";



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

        return resultado;
    }

    public static String cadastraIngredientePorReceita(int codReceita, String ingredientes) {
        String result = "";

        // Separa os ingredientes pela ";"
        String[] ingredientesArray = ingredientes.split(";");

        for (String ingredienteInfo : ingredientesArray) {
            // Separa os dados do ingrediente pelo "-"
            String[] dadosIngrediente = ingredienteInfo.split("-");
            System.out.println("ing info " + ingredienteInfo);
            if (dadosIngrediente.length == 4) { // Verifica se a estrutura está correta
                int codIngrediente = Integer.parseInt(dadosIngrediente[0]);
                System.out.println("cod ing " + codIngrediente);
                String nomeIngrediente = dadosIngrediente[1];
                System.out.println("nome ing " + nomeIngrediente);
                int quantidade = Integer.parseInt(dadosIngrediente[2]);
                System.out.println("qtde ing " + quantidade);
                String medida = dadosIngrediente[3];
                System.out.println("medida " + medida);

                // Cria um novo objeto IngredientesReceita e insere no banco de dados
                IngredientesReceita ingredienteReceita = new IngredientesReceita(codReceita, codIngrediente, quantidade, medida);
                daoIngredientesReceita daoIngredienteReceita = new daoIngredientesReceita();
                boolean inseridoComSucesso = daoIngredienteReceita.inserirIngredienteReceita(ingredienteReceita);

                if (inseridoComSucesso) {
                    result += "Ingrediente '" + nomeIngrediente + "' cadastrado com sucesso.\n";
                } else {
                    result += "Erro ao cadastrar ingrediente '" + nomeIngrediente + "'.\n";
                }
            } else {
                result += "Estrutura de dados do ingrediente incorreta: " + ingredienteInfo + ".\n";
            }
        }

        return result;
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
