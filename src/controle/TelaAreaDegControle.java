package controle;

import dao.daoDegustador;
import dao.daoEditor;
import model.Degustador;
import model.Editor;

import java.util.ArrayList;
import java.util.List;

public class TelaAreaDegControle {
    public static List<Degustador> listaDegustadores(){
        List<Degustador> degustadores = new ArrayList<>();
        daoDegustador daodegustador = new daoDegustador();
        degustadores = daodegustador.listarTodos();
        return degustadores;
    }
}
