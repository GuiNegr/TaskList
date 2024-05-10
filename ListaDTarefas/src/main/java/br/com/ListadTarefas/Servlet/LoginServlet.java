package br.com.ListadTarefas.Servlet;

import br.com.ListadTarefas.Dao.userDAO;
import br.com.ListadTarefas.Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id;
        String userEmail;
        String userPass;
        String username;

        username = req.getParameter("userName");
        id = req.getParameter("id");
        userEmail = req.getParameter("userEmail");
        userPass = req.getParameter("userPass");

        UserModel userModel = new UserModel(id,username,userEmail,userPass);
        userDAO userDAO = new userDAO();

        if (userDAO.check(userModel)){
            resp.sendRedirect("HomeLogado.html");
        }else {
            req.getRequestDispatcher("createUser.html").forward(req,resp);
        }


    }
}
