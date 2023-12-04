package model;

import java.util.Date;

public class Teste {
    private int codReceita;
    private String cpfDegustador;
    private Date dataTeste;
    private int nota;
    private String nomeTestador;
    private String nomeReceita;


    public Teste() {}

    public Teste(int codReceita, String cpfDegustador, Date dataTeste, int nota) {
        this.codReceita = codReceita;
        this.cpfDegustador = cpfDegustador;
        this.dataTeste = dataTeste;
        this.nota = nota;
    }

    public int getCodReceita() {
        return codReceita;
    }

    public void setCodReceita(int codReceita) {
        this.codReceita = codReceita;
    }

    public String getCpfDegustador() {
        return cpfDegustador;
    }

    public void setCpfDegustador(String cpfDegustador) {
        this.cpfDegustador = cpfDegustador;
    }

    public Date getDataTeste() {
        return dataTeste;
    }

    public void setDataTeste(Date dataTeste) {
        this.dataTeste = dataTeste;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNomeTestador() {
        return nomeTestador;
    }

    public void setNomeTestador(String nomeTestador) {
        this.nomeTestador = nomeTestador;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }
}
