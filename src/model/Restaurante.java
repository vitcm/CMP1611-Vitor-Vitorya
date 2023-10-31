package model;

public class Restaurante {
    private int codRest;
    private String nomeRest;


    public Restaurante() {}

    public Restaurante(int codRest, String nomeRest) {
        this.codRest = codRest;
        this.nomeRest = nomeRest;
    }


    public int getCodRest() {
        return codRest;
    }

    public void setCodRest(int codRest) {
        this.codRest = codRest;
    }

    public String getNomeRest() {
        return nomeRest;
    }

    public void setNomeRest(String nomeRest) {
        this.nomeRest = nomeRest;
    }

}
