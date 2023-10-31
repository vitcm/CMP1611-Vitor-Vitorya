package model;

public class Categoria {
    private int codCategoria;
    private String descCategoria;


    public Categoria() {}

    public Categoria(int codCategoria, String descCategoria) {
        this.codCategoria = codCategoria;
        this.descCategoria = descCategoria;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

}
