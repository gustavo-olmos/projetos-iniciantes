package dao;

import obj.Livro;

import java.util.List;

public interface LivroDaoInter {
    Livro salvaLivros(Livro livro);

    List<Livro> listarLivros();
}
