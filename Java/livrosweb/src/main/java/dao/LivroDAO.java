package dao;

import obj.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements LivroDaoInter{
    private List<Livro> books = new ArrayList<>();

    @Override
    public Livro salvaLivros(Livro livro) {
        books.add(livro);
        return livro;
    }

    @Override
    public List<Livro> listarLivros(){
        return this.books;
    }
}
