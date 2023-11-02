package controle;

import dao.daoRestaurante;
import model.Restaurante;

import java.util.List;

public class TelaCadRestauranteControle {

    private daoRestaurante dao = new daoRestaurante();

    public void inserirRestaurante(int codRest, String nomeRest) {
        Restaurante restaurante = new Restaurante(codRest, nomeRest);
        dao.inserir(restaurante);
    }

    public List<Restaurante> getTodosRestaurantes() {
        return dao.listarTodos();
    }







}
