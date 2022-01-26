package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "present", value = "/present")
public class PresentServlet extends HttpServlet {
    db dbc = new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session=request.getSession();
//        if (session.getAttribute("msg") == null){
//            session.removeAttribute("msg");
//        }
        String username = (String) session.getAttribute("username");
        String todaydate = (String) session.getAttribute("todaydate");

        Student myStudent = dbc.selectStudent(id);
//        out.println("help me "+myStudent.getAttendance());
        if (myStudent.getAttendance().isEmpty()) {

//            out.println("do you love me  "+myStudent.getSname());

            boolean isValid = dbc.updateAttendancePresent(id);
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
