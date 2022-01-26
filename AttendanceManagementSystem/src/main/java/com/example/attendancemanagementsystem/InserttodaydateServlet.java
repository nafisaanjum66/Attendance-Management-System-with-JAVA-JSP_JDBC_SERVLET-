package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Login;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "inserttodaydate", value = "/inserttodaydate")
public class InserttodaydateServlet extends HttpServlet {
    db dbc=new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            //int id;
            //HttpSession session=request.getSession();
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                Login existingPerson = dbc.selectLoginPerson(username,password);
                //session.setAttribute("id", id);
                //request.setAttribute("person", existingPerson);
//            out.println("ami paisi "+id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("insert-todaydate.jsp");
                request.setAttribute("person", existingPerson);
                dispatcher.forward(request, response);


        }catch(Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            //int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session=request.getSession();
            session.removeAttribute("log");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String todaydate = request.getParameter("todaydate");


            if (session.getAttribute("token").equals("1")){
                Login mydate = new Login(username, password, todaydate);
                boolean isValid = dbc.updateDateInLogin(mydate);
                out.println(isValid);

                if (isValid) {
                    out.println("done  valid in date");
                    session.setAttribute("username", username);
                    session.setAttribute("todaydate", todaydate);
                    response.sendRedirect("dashboard");
                } else {
                    //out.println("<br/>");
                    out.println("error invalid");

                }
                out.println("allah help");

            }
            else{
                response.sendRedirect("login");
            }

            //response.sendRedirect("person");
        }catch(Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }
}
