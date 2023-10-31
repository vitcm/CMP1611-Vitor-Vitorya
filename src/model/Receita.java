package model;

import java.util.Date;

public class Receita {
    private int codReceita;
    private String nomeReceita;
    private Date dataInventada;
    private String codCozinheiro;
    private int codCategoria;
    private String descricaoPreparacao;
    private int numPorcoes;


    public Receita() {}

    public Receita(int codReceita, String nomeReceita, Date dataInventada, String codCozinheiro, int codCategoria, String descricaoPreparacao, int numPorcoes) {
        this.codReceita = codReceita;
        this.nomeReceita = nomeReceita;
        this.dataInventada = dataInventada;
        this.codCozinheiro = codCozinheiro;
        this.codCategoria = codCategoria;
        this.descricaoPreparacao = descricaoPreparacao;
        this.numPorcoes = numPorcoes;
    }

    public int getCodReceita() {
        return codReceita;
    }

    public void setCodReceita(int codReceita) {
        this.codReceita = codReceita;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public Date getDataInventada() {
        return dataInventada;
    }

    public void setDataInventada(Date dataInventada) {
        this.dataInventada = dataInventada;
    }

    public String getCodCozinheiro() {
        return codCozinheiro;
    }

    public void setCodCozinheiro(String codCozinheiro) {
        this.codCozinheiro = codCozinheiro;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescricaoPreparacao() {
        return descricaoPreparacao;
    }

    public void setDescricaoPreparacao(String descricaoPreparacao) {
        this.descricaoPreparacao = descricaoPreparacao;
    }

    public int getNumPorcoes() {
        return numPorcoes;
    }

    public void setNumPorcoes(int numPorcoes) {
        this.numPorcoes = numPorcoes;
    }

}
