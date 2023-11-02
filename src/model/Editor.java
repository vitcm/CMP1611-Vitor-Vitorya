package model;

import java.math.BigDecimal;
import java.util.Date;

public class Editor {
    private String cpf;
    private String nome;
    private Date dataIngresso;
    private BigDecimal salario;


    public Editor() {}

    public Editor(String cpf, String nome, Date dataIngresso, BigDecimal salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataIngresso = dataIngresso;
        this.salario = salario;
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

    public void setDataIngresso(java.util.Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
