/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.source.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.util.*;

import com.source.dao.User;
import com.source.data.StudyDB;
import com.source.data.UserDB;


/**
 *
 * @author User
 */
@WebServlet(name = "UserController", urlPatterns = {"/users"})
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = null;
        //
        String action = request.getParameter("action");
        if (action == null) {
            //
            String host = request.getRemoteHost();
            String port = String.valueOf(request.getRemotePort());
            Cookie c1 = new Cookie("host", host);
            c1.setMaxAge(60*60);
            c1.setPath("/");
            response.addCookie(c1);
            Cookie c2 = new Cookie("port", port);
            c2.setMaxAge(60);
            c2.setPath("/");
            response.addCookie(c2);
            //
            url = "/home.jsp";
        } else if (action.equals("login")) {
            //get request parameters
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            //get user DB
            ArrayList<User> userDB = UserDB.defaultUsers();
            //get user based on email
            User user = UserDB.getUser(userDB, email);
            if (user == null) {
                String msg = "Invalid user info. Please try again.";
                url = "/login.jsp";
                request.setAttribute("loginErrorMsg", msg);
            } else //use fixed password "123"
             if (password.equals("123")) {
                    //create temporary DB for the app
                    session.setAttribute("userDB", userDB);
                    session.setAttribute("studyDB", StudyDB.defaultStudies());
                    session.setAttribute("reportDB", StudyDB.defaultReports());
                    //Participant
                    if (user.getType().equals("Participant")) {
                        //session theUser
                        session.setAttribute("theUser", user);
                        //
                        url = "/main.jsp";
                    }
                    //Admin
                    if (user.getType().equals("Admin")) {
                        //session theAdmin
                        session.setAttribute("theAdmin", user);
                        //
                        url = "/admin.jsp";
                    }
                } else {
                    String msg = "Invalid user info. Please try again.";
                    //
                    url = "/login.jsp";
                    request.setAttribute("loginErrorMsg", msg);
                }
        } else if (action.equals("create")) {
            //get request parameters
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String type = request.getParameter("type");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm_password");
            //
            if (type.equals("Participant") && password.equals(confirmPassword)) {
                //create a user
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setType(type);
                user.setNumCoins(0);
                user.setNumPostedStudies(0);
                user.setNumPartipation(0);
                //get default user list
                ArrayList<User> userDB = UserDB.defaultUsers();
                //add the created user
                userDB.add(user);
                //create temporary DB or the app
                session.setAttribute("userDB", userDB);
                session.setAttribute("studyDB", StudyDB.defaultStudies());
                session.setAttribute("reportDB", StudyDB.defaultReports());
                //session theUser
                session.setAttribute("theUser", user);
                //
                url = "/main.jsp";
            } else if (action.equals("how")) {
                if (session.getAttribute("theUser") != null) {
                    url = "/main.jsp";
                } else {
                    url = "/how.jsp";
                }
            }
        } else if (action.equals("about")) {
            if (session.getAttribute("theUser") != null) {
                url = "/about.jsp";
            } else {
                url = "/aboutl.jsp";
            }
        } else if (action.equals("home")) {
            if (session.getAttribute("theUser") != null) {
                url = "/main.jsp";
            } else {
                url = "/home.jsp";
            }
        } else if (action.equals("main")) {
            if (session.getAttribute("theUser") != null) {
                url = "/main.jsp";
            } else {
                url = "/login.jsp";
            }
        } else if (action.equals("logout")) {
            if (session.getAttribute("theUser") != null || session.getAttribute("theAdmin") != null) {
                session.invalidate();
                url = "/home.jsp";
            } else {
                url = "/home.jsp";
            }
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}