package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> names = model.list();
        req.setAttribute("userName", names);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldName = req.getParameter("oldName");
        String oldPassword = req.getParameter("oldPass");
        User oldUser = new User(oldName, oldPassword);

        String newName = req.getParameter("newName");
        String newPass = req.getParameter("newPass");
        User newUser = new User(newName, newPass);

        Model model = Model.getInstance();
        model.edit(oldUser, newUser);

        doGet(req, resp);
    }
}
