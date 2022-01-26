package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Login;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "forgetpassword", value = "/forgetpassword")
public class ForgetPasswordServlet extends HttpServlet {
    db dbc = new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            //int id;
            //HttpSession session=request.getSession();
            String username = request.getParameter("username");
            //String password = request.getParameter("password");
            //Login existingPerson = dbc.selectChangePassPerson(username);
            //session.setAttribute("id", id);
            //request.setAttribute("person", existingPerson);
            //out.println("ami paisi "+username);
            HttpSession session=request.getSession();
            session.setAttribute("uname", username);
            /*RequestDispatcher dispatcher = request.getRequestDispatcher("forget-password.jsp");
            request.setAttribute("person", existingPerson);
            dispatcher.forward(request, response);*/
            response.sendRedirect("forget-password.jsp");


        }catch(Exception e) {
            out.println("error in get user for forget password");
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            //int id = Integer.parseInt(request.getParameter("id"));
            //HttpSession session=request.getSession();
            //String username = request.getParameter("username");
            //String password = request.getParameter("password");
            //String todaydate = request.getParameter("todaydate");

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String retypepassword = request.getParameter("retypepassword");
           /* if (session.getAttribute("token").equals("1")){*/
//                Login changepass = new Login(password, username);
//                boolean isValid = dbc.changePassword(changepass);
                //out.println(isValid);

                if (retypepassword.equals(password)) {
                    out.println("done  valid in change pass");

                    //String todaydate = "";
                    Login changepass = new Login(username, password);
                    boolean isValid = dbc.changePassword(changepass);
                    //session.setAttribute("username", username);
                    //session.setAttribute("todaydate", todaydate);
                    if (isValid){

                        response.sendRedirect("login.jsp");
                    }else{
                         out.println("changing passsword is not valid");
                    }
                    //out.println("ami.........." +isValid);

                } else {
                    //out.println("<br/>");
                    out.println("New Password and retype passowrd missmatch");

                }
                out.println("allah help");

            /*}
            else{
                response.sendRedirect("registration");
            }*/

            //response.sendRedirect("person");
        }catch(Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }
}
