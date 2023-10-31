package model;

public class Livro {
    private String ISBN;
    private String titulo;
    private String cpfEditor;

    public Livro() {}

    public Livro(String ISBN, String titulo, String cpfEditor) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.cpfEditor = cpfEditor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCpfEditor() {
        return cpfEditor;
    }

    public void setCpfEditor(String cpfEditor) {
        this.cpfEditor = cpfEditor;
    }
}
