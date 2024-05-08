package servlet;

import bo.BusinessObjectInterface;
import obj.Livro;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="teste-servlet")
public class LivroServlet extends HttpServlet {
    private BusinessObjectInterface businessObject;
    @Inject
    public LivroServlet(BusinessObjectInterface businessObject) {
        this.businessObject = businessObject;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String autor = request.getParameter("autor");

        Livro livro = new Livro(nome, autor);
        Livro saveLivro = businessObject.cadastraLivros(livro);

        request.setAttribute("nome", saveLivro.getNome());
        request.setAttribute("autor", saveLivro.getAutor());

        RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
        dispatcher.forward(request, response);
    }
}
