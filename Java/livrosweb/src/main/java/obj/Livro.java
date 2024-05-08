package obj;

import lombok.Data;

@Data
public class Livro {
    private String nome;
    private String autor;

    public Livro(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }
}
