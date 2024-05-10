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


@WebServlet("/List")
public class ReadTarefasServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<TarefasModel> tasks = new TarefasDao().read();

        req.setAttribute("tasks", tasks);

        req.getRequestDispatcher("read.jsp").forward(req,resp);
    }
}
