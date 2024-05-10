package br.com.ListadTarefas.Servlet;

import br.com.ListadTarefas.Dao.TarefasDao;
import br.com.ListadTarefas.Model.TarefasModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/CreateTarefa")
public class CreateTarefasServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nomeTask = req.getParameter("nomeTask");
        String statusTask = req.getParameter("statusTask");

        TarefasDao tarefasdao = new TarefasDao();
        TarefasModel model = new TarefasModel(id,nomeTask,statusTask);

        tarefasdao.createTarefas(model);
        resp.sendRedirect("HomeLogado.html");
    }

}
