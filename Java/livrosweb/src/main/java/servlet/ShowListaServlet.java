package servlet;

import bo.BusinessObjectInterface;
import obj.Livro;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowListaServlet extends HttpServlet {
    private BusinessObjectInterface businessObject;
    @Inject
    public ShowListaServlet(BusinessObjectInterface businessObject) {
        this.businessObject = businessObject;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Livro> lista = businessObject.lsLivros();

        req.setAttribute("lista", lista);

        RequestDispatcher dispatcher = req.getRequestDispatcher("show.jsp");
        dispatcher.forward(req, resp);
    }
}
