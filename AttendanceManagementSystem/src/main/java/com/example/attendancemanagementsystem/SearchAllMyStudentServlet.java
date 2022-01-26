package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "searchallmystudent", value = "/searchallmystudent")
public class SearchAllMyStudentServlet extends HttpServlet {
    db dbc = new db();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();
//        session.removeAttribute("token");
        String username = (String) session.getAttribute("username");

        String search = request.getParameter("searchAllMyStudent");
        List<Student> student;
        student = dbc.searchAllMyStudent(search,username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("allmy-student.jsp");
        request.setAttribute("listMyStudent", student);
        //request.setAttribute("message", "success");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
