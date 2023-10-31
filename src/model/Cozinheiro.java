package model;

import java.sql.Date;
import java.math.BigDecimal;

public class Cozinheiro {
    private String cpf;
    private String nome;
    private Date dataIngresso;
    private BigDecimal salario;
    private String nomeFantasia;
    private String listaRestaurantes;

    public Cozinheiro() {}

    public Cozinheiro(String cpf, String nome, Date dataIngresso, BigDecimal salario, String nomeFantasia, String listaRestaurantes) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataIngresso = dataIngresso;
        this.salario = salario;
        this.nomeFantasia = nomeFantasia;
        this.listaRestaurantes = listaRestaurantes;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getListaRestaurantes() {
        return listaRestaurantes;
    }

    public void setListaRestaurantes(String listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }
}
