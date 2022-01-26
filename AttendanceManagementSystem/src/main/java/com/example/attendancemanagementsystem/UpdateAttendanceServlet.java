package com.example.attendancemanagementsystem;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import com.example.database.db;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "updateattendance", value = "/updateattendance")
public class UpdateAttendanceServlet extends HttpServlet {
    db dbc = new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session=request.getSession();
        session.removeAttribute("msg");
        String username = (String) session.getAttribute("username");
        String todaydate = (String) session.getAttribute("todaydate");
        String set = "";

        Student myStudent = dbc.selectStudent(id);
        if (myStudent.getAttendance().equals("absent")) {

//            out.println("do you love me  "+myStudent.getSname());
            set = "present";

            boolean isValid = dbc.updateAttendance(id,set);
//
            if (isValid) {
                List<Student> listStudent;
                listStudent = dbc.selectStudentsDashboard(username, todaydate);
                out.println(listStudent);
                //request.setAttribute("listPerson", listPerson);
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                request.setAttribute("listStudent", listStudent);
                //request.setAttribute("message", "success");
                dispatcher.forward(request, response);
//                out.println("do you really love me my dear sexy bou "+isValid);
            } else {
                List<Student> listStudent;
                listStudent = dbc.selectStudentsDashboard(username, todaydate);
                out.println(listStudent);
                session.setAttribute("msg", "failed");
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                request.setAttribute("listStudent", listStudent);
                //request.setAttribute("message", "success");
                dispatcher.forward(request, response);
            }
        }
        else {

            set = "absent";

            boolean isValid = dbc.updateAttendance(id,set);
//
            if (isValid) {
                List<Student> listStudent;
                listStudent = dbc.selectStudentsDashboard(username, todaydate);
                out.println(listStudent);
                //request.setAttribute("listPerson", listPerson);
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                request.setAttribute("listStudent", listStudent);
                //request.setAttribute("message", "success");
                dispatcher.forward(request, response);
//                out.println("do you really love me my dear sexy bou "+isValid);
            } else {
                List<Student> listStudent;
                listStudent = dbc.selectStudentsDashboard(username, todaydate);
                out.println(listStudent);
                session.setAttribute("msg", "failed");
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                request.setAttribute("listStudent", listStudent);
                //request.setAttribute("message", "success");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
