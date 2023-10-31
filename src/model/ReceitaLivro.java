package model;

public class ReceitaLivro {
    private int codReceita;
    private String isbn;


    public ReceitaLivro() {}

    public ReceitaLivro(int codReceita, String isbn) {
        this.codReceita = codReceita;
        this.isbn = isbn;
    }


    public int getCodReceita() {
        return codReceita;
    }

    public void setCodReceita(int codReceita) {
        this.codReceita = codReceita;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
