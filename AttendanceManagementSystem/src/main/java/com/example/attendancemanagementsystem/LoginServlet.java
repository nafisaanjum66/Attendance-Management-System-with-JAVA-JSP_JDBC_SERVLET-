package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Login;
import com.example.model.Registration;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    db dbc=new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            String uname = request.getParameter("username");
            String pass = request.getParameter("password");
            out.println("k tumi");
            Registration reg = new Registration();
            out.println(reg.getUsername());
            out.println("k tumi 2");
            if(reg.getUsername().equals(uname) && reg.getPassword().equals(pass)){
                out.println("success in login servlet");
                response.sendRedirect("dashboard.jsp");
            }else{
                out.println("damage in login servlet");
            }
        }catch (Exception e){
            out.println("error in login catch");
            out.println(e.getMessage());
        }

*/

/*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            //int id;
            //HttpSession session=request.getSession();
            if(request.getParameter("username") != null && request.getParameter("password") != null) {

                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Login existingPerson = dbc.selectLoginPerson(username,password);
                //session.setAttribute("id", id);
                //request.setAttribute("person", existingPerson);
//            out.println("ami paisi "+id);


                //RequestDispatcher dispatcher = request.getRequestDispatcher("update-person.jsp");
                //request.setAttribute("person", existingPerson);
                //dispatcher.forward(request, response);
            }


        }catch(Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }

*/



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            HttpSession session=request.getSession();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //String todaydate = request.getParameter("todaydate");

            Login newPerson = new Login(username, password);

            //dbc.validLogin(newPerson);


            //out.println("k tumi");
            //response.sendRedirect("dashboard.jsp");
            //Registration reg = new Registration();
            //out.println(reg.getUsername());
            //out.println("k tumi 2");

            if(dbc.validLogin(newPerson)){
                out.println("success in login servlet");
                //Login existingPerson = dbc.selectLoginPerson(username,password);
                /*Login newDate = new Login(username, password,todaydate);
                if(dbc.insertDateInLogin(newDate)){*/

                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("token", "1");
                    response.sendRedirect("inserttodaydate");
                //}

//                response.sendRedirect("dashboard.jsp");
            }else{
                session.setAttribute("log","failed");
                response.sendRedirect("login.jsp");
            }
        }catch (Exception e){
            out.println("error in login catch");
            out.println(e.getMessage());
        }


    }
}
