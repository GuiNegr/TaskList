package br.com.ListadTarefas.Servlet;

import br.com.ListadTarefas.Dao.TarefasDao;
import br.com.ListadTarefas.Model.TarefasModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteTarefa")
public class DeleteTarefasServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        TarefasDao tarefasDao = new TarefasDao();
        tarefasDao.deleteById(id);

        resp.sendRedirect("/List");

    }
}
