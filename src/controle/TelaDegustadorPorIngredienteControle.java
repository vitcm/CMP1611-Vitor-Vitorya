package controle;

import dao.daoTeste;
import model.Teste;
import java.util.List;

public class TelaDegustadorPorIngredienteControle {
    private daoTeste testeDao;

    public TelaDegustadorPorIngredienteControle() {
        this.testeDao = new daoTeste();
    }

    public List<Teste> buscarTestesPorIngredientes(String ingredienteX, String ingredienteY) {
        return testeDao.buscarTestesPorIngredientes(ingredienteX, ingredienteY);
    }
}
