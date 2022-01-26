package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Registration;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addnewstudent", value = "/addnewstudent")
public class AddNewStudentServlet extends HttpServlet {
    db dbc=new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();
        String username = (String) session.getAttribute("username");
        String todaydate = (String) session.getAttribute("todaydate");
        String sname = request.getParameter("sname");
        String rollno = request.getParameter("rollno");
        String course = request.getParameter("course");
        String semester = request.getParameter("semester");
        String branch = request.getParameter("branch");
        String attendance = request.getParameter("attendance");
        Student newStudent = new Student(username, todaydate, sname,rollno, course, semester,branch,attendance);

        dbc.insertNewStudent(newStudent);
        //out.println("Success registration");

        /*com.example.model.Registration addLogin = new Registration(username, password);


        dbc.insertLogin(addLogin);*/
        response.sendRedirect("dashboard");
        //out.println("Success login");
    }
}
