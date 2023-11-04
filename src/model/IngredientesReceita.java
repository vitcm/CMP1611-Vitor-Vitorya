package model;

public class IngredientesReceita {

    private int codReceita;
    private int codIngrediente;
    private int quantidade;
    private String medida;

    public IngredientesReceita(int codReceita, int codIngrediente, int quantidade, String medida) {
        this.codReceita = codReceita;
        this.codIngrediente = codIngrediente;
        this.quantidade = quantidade;
        this.medida = medida;
    }
    
    public int getCodReceita() {
        return codReceita;
    }

    public void setCodReceita(int codReceita) {
        this.codReceita = codReceita;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

}
