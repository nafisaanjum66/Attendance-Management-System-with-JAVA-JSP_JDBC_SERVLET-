package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Login;
import com.example.model.Registration;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "changepassword", value = "/changepassword")
public class ChangePasswordServlet extends HttpServlet {
    db dbc = new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        session.removeAttribute("pass");
        RequestDispatcher dispatcher = request.getRequestDispatcher("changemypass.jsp");
//        request.setAttribute("person", faculty);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();

        String username = (String) session.getAttribute("username");
        //String todaydate = (String) session.getAttribute("todaydate");
        Registration f = dbc.selectMyProfile(username);
        String getPass = f.getPassword();
        String currentpass = request.getParameter("currentpass");
        String password = request.getParameter("newpass");
        String retypepass = request.getParameter("retypepass");


//        out.println("today date here..."+ fullname +mobile +dob + qualification);
        if (getPass.equals(currentpass)){
            if (password.equals(retypepass)){
                Registration myfaculty = new Registration(username,password);
                Login mypass = new Login(username,password);
                boolean isValid = dbc.updateMyPassword(myfaculty);
                boolean isValid1 = dbc.updateMyPasswordLogin(mypass);
                if (isValid && isValid1) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("changemypass.jsp");
                    request.setAttribute("pass", "success");
                    dispatcher.forward(request, response);
                }
                else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("changemypass.jsp");
                    request.setAttribute("pass", "failed");
                    dispatcher.forward(request, response);
                }
            }
        }
    }
}
