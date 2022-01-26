package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "dashboard", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    db dbc = new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        //start
        //String username = request.getParameter("username");
        //String todaydate = request.getParameter("todaydate");
        HttpSession session=request.getSession();
//        session.removeAttribute("token");
        String username = (String) session.getAttribute("username");
        String todaydate = (String) session.getAttribute("todaydate");


        //out.println("today date here..."+todaydate);

        if (session.getAttribute("token").equals("1")){
            try {
                List<Student> listStudent;
                listStudent = dbc.selectStudentsDashboard(username,todaydate);
                out.println(listStudent);
                //request.setAttribute("listPerson", listPerson);
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                request.setAttribute("listStudent", listStudent);
                //request.setAttribute("message", "success");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                out.println("Error while connecting database");
                out.println(e.getMessage());
            }
        }
        else {
            response.sendRedirect("login");
        }

//

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
