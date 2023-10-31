package model;

import java.sql.Date;
import java.math.BigDecimal;

public class Degustador {
    private String cpf;
    private String nome;
    private Date dataIngresso;
    private BigDecimal salario;

    public Degustador() {}

    public Degustador(String cpf, String nome, Date dataIngresso, BigDecimal salario) {
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

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
