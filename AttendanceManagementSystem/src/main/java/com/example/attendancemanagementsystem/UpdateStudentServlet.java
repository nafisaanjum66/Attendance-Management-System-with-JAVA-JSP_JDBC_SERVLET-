package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updatestudent", value = "/updatestudent")
public class UpdateStudentServlet extends HttpServlet {
    db dbc=new db();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            //int id;
            HttpSession session=request.getSession();
            if(request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                Student existingStudent = dbc.selectStudentWithoutAttendance(id);
                session.setAttribute("id", id);
                //request.setAttribute("person", existingPerson);
//            out.println("ami paisi "+id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("update-student.jsp");
                request.setAttribute("student", existingStudent);
                dispatcher.forward(request, response);
            }

        }catch(Exception e) {
            out.println("error in get in  update Servlet");
            out.println(e.getMessage());
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String todaydate = request.getParameter("todaydate");
            String sname = request.getParameter("sname");
            String rollno = request.getParameter("rollno");
            String course = request.getParameter("course");
            String semester = request.getParameter("semester");
            String branch = request.getParameter("branch");
            //String attendance = request.getParameter("attendance");

            Student update = new Student(id, username, todaydate, sname, rollno,course, semester, branch);
            //Person update = new Person(id, name, gender, dob, email);
            out.println("error try");
            boolean isValid = dbc.updateStudent(update);
            out.println(isValid);

            if(isValid) {
                out.println("error valid");

                response.sendRedirect("dashboard");
            }else{
                //out.println("<br/>");
                out.println("error invalid in update person post");

            }
            //response.sendRedirect("person");
        }catch(Exception e) {
            out.println("Error in update");
            out.println(e.getMessage());
        }
    }

}
