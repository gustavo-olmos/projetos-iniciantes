package bo;

import obj.Livro;

import java.util.List;

public interface BusinessObjectInterface {
    List<Livro> lsLivros();

    Livro cadastraLivros(Livro livro);
}
