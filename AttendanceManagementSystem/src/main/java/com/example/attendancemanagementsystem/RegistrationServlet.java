package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Registration;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    db dbc=new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String qualification = request.getParameter("qualification");
        Registration newPerson = new Registration(username, password, fullname, mobile, dob, qualification);

        dbc.insertRegistration(newPerson);
        out.println("Success registration");

        Registration addLogin = new Registration(username, password);


        dbc.insertLogin(addLogin);
        response.sendRedirect("login.jsp");
        //out.println("Success login");
    }
}
