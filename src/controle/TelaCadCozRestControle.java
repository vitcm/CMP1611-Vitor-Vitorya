package controle;

import dao.daoCozRestaurante;
import model.RestauranteCozinheiro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadCozRestControle {
    public static String cadastraCozinheiroEmRestaurante(String cozinheiro, String restaurante, String data) {
        String resultado = "";

        if(cozinheiro.isEmpty() || restaurante.isEmpty()) {
            resultado = "Os campos são obrigatórios.";
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

        RestauranteCozinheiro restauranteCozinheiro = new RestauranteCozinheiro();
        restauranteCozinheiro.setCodCozRestcoz(cozinheiro);
        restauranteCozinheiro.setCodRestRestcoz(Integer.parseInt(restaurante));
        restauranteCozinheiro.setDataContratacao(dataIngresso);

        daoCozRestaurante daoCozRest = new daoCozRestaurante();
        boolean inseridoComSucesso = daoCozRest.inserir(restauranteCozinheiro);

        if (inseridoComSucesso) {
            resultado = "Cadastro realizado com sucesso!";
        } else {
            resultado = "Não foi possível realizar o cadastro.";
        }

        return resultado;
    }

}
