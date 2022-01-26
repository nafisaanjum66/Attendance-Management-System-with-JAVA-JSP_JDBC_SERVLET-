package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "searchdashboardstudent", value = "/searchdashboardstudent")
public class SearchDashboardStudentServlet extends HttpServlet {
    db dbc = new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();
//        session.removeAttribute("token");
        String username = (String) session.getAttribute("username");
        String todaydate = (String) session.getAttribute("todaydate");

        String search = request.getParameter("searchDashboardStudent");
        List<Student> student;
        student = dbc.searchDashboardStudent(search,username,todaydate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        request.setAttribute("listStudent", student);
        //request.setAttribute("message", "success");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
