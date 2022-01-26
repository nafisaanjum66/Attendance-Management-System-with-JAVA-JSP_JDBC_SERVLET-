package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.SQLException;

@WebServlet(name = "deletestudent", value = "/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
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
                Student existingStudent = dbc.selectStudent(id);
                session.setAttribute("id", id);
                //request.setAttribute("person", existingPerson);
//            out.println("ami paisi "+id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("delete-student.jsp");
                request.setAttribute("student", existingStudent);
                dispatcher.forward(request, response);
            }

        }catch(Exception e) {
            out.println("error in get delete student");
            out.println(e.getMessage());
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean isValid = dbc.deleteStudent(id);
            out.println(isValid);

            if(isValid) {
                //out.println("error valid delete  .... "+id+"jstjs"+isValid);

                response.sendRedirect("dashboard");
            }else{
                //out.println("<br/>");
                out.println("error invalid delete");

            }
        } catch (Exception e) {
            out.println("error in post delete student");
            out.println(e.getMessage());
        }
        //response.sendRedirect("list");
    }

}
