package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdateUserProfileServlet", urlPatterns = "/update")
public class UpdateUserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(req,resp);
    }

    //updates user's username and email
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        User updatedUser = new User(
                user.getId(),
                req.getParameter("username"),
                req.getParameter("email"),
                req.getParameter("password")
        );
        updatedUser.setPassword(req.getParameter("password"));

        DaoFactory.getUsersDao().updateUser(updatedUser);
        user.setUsername(updatedUser.getUsername());
        resp.sendRedirect("profile");
    }
}