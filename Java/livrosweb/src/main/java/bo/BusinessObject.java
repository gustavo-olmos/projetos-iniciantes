package bo;

import dao.LivroDaoInter;
import obj.Livro;

import javax.inject.Inject;
import java.util.List;

public class BusinessObject implements BusinessObjectInterface {

    private LivroDaoInter lvInter;

    @Inject
    public BusinessObject(LivroDaoInter lvInter) {
        this.lvInter = lvInter;
    }

    @Override
    public List<Livro> lsLivros() {
        return lvInter.listarLivros();
    }

    @Override
    public Livro cadastraLivros(Livro livro) {
        if(livro.getNome().isEmpty() || livro.getAutor().isEmpty()){
            throw new IllegalArgumentException("Dados inválidos");
        } else {
            return lvInter.salvaLivros(livro);
        }
    }
}
