package model;

public class Ingrediente {
    private int codIngrediente;
    private String nomeIngrediente;
    private String descricao;


    public Ingrediente() {}

    public Ingrediente( String nomeIngrediente, String descricao) {
        this.nomeIngrediente = nomeIngrediente;
        this.descricao = descricao;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
