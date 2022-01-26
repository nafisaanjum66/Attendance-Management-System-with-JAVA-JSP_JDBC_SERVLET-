package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.example.model.Registration;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {
    db dbc = new db();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        //start
        //String username = request.getParameter("username");
        //String todaydate = request.getParameter("todaydate");
        HttpSession session=request.getSession();
        session.removeAttribute("msg1");
        session.removeAttribute("msg2");
        String username = (String) session.getAttribute("username");
        //String todaydate = (String) session.getAttribute("todaydate");
        Registration faculty = dbc.selectMyProfile(username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-profile.jsp");
        request.setAttribute("person", faculty);
        dispatcher.forward(request, response);


//        out.println("today date here..."+ username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();

        //start
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String qualification = request.getParameter("qualification");

//        out.println("today date here..."+ fullname +mobile +dob + qualification);
        Registration myfaculty = new Registration(username,fullname, mobile, dob, qualification);
        boolean isValid = dbc.updateFacultyProfile(myfaculty);


        if(isValid){


            Registration faculty = dbc.selectMyProfile(username);

            RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-profile.jsp");
            request.setAttribute("person", faculty);
//            session.setAttribute("msg1", "success");
            request.setAttribute("msg", "success");
            dispatcher.forward(request, response);
        }else{


            Registration faculty = dbc.selectMyProfile(username);

            RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-profile.jsp");
            request.setAttribute("person", faculty);
//            session.setAttribute("msg2", "failed");
            request.setAttribute("msg", "failed");
            dispatcher.forward(request, response);
        }
    }
}
