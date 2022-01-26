package com.example.attendancemanagementsystem;

import com.example.database.db;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "generatereportofallmystudent", value = "/generatereportofallmystudent")
public class GenerateReportOfAllMyStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();
        String username = (String) session.getAttribute("username");
        //String todaydate = (String) session.getAttribute("todaydate");

        String attendance = request.getParameter("attendance");

        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("F://All_Student_Attendance.pdf"));
            document.open();
            Paragraph p = new Paragraph();
            p.add("Attendance Management System \n Student Attendance Report \n All My Student Report");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(new float[] {10, 15, 25, 20, 10, 15, 15, 15, 20});
            table.getDefaultCell().setHorizontalAlignment((Element.ALIGN_CENTER));
            table.addCell("id");
            table.addCell("Faculty name");
            table.addCell("Date");
            table.addCell("Student Name");
            table.addCell("Roll No");
            table.addCell("course");
            table.addCell("Semester");
            table.addCell("Branch");
            table.addCell("Attendance");

            table.setHeaderRows(1);

            PdfPCell[] cells = table.getRow(0).getCells();

            for( int j=0; j< cells.length;j++){
                cells[j].setBackgroundColor(BaseColor.LIGHT_GRAY);
            }
            Connection con = db.getConnection();

            String queryWithAttendance = "select id,username,todaydate,sname,rollno,course,semester,branch,attendance from attendancems.student where username = '"+username+"' and attendance = '"+attendance+"';";
            String queryWithoutAttendance = "select id,username,todaydate,sname,rollno,course,semester,branch,attendance from attendancems.student where username = '"+username+"';";

            Statement st = con.createStatement();

            if (attendance.equals("all")){

                ResultSet rs = st.executeQuery(queryWithoutAttendance);

                while(rs.next()){
                    table.addCell(String.valueOf(rs.getInt(1)));
                    table.addCell(rs.getString(2));
                    table.addCell(rs.getString(3));
                    table.addCell(rs.getString(4));
                    table.addCell(rs.getString(5));
                    table.addCell(rs.getString(6));
                    table.addCell(rs.getString(7));
                    table.addCell(rs.getString(8));
                    table.addCell(rs.getString(9));
                }

                document.add(table);
                document.close();
                System.out.println("Generation done with attendance");
                con.close();

            }else{
                //Statement st = con.createStatement();
                ResultSet rs1 = st.executeQuery(queryWithAttendance);

                while(rs1.next()){
                    table.addCell(String.valueOf(rs1.getInt(1)));
                    table.addCell(rs1.getString(2));
                    table.addCell(rs1.getString(3));
                    table.addCell(rs1.getString(4));
                    table.addCell(rs1.getString(5));
                    table.addCell(rs1.getString(6));
                    table.addCell(rs1.getString(7));
                    table.addCell(rs1.getString(8));
                    table.addCell(rs1.getString(9));
                }

                document.add(table);
                document.close();
                System.out.println("Generation done");
                con.close();

            }



        }catch (Exception e){
            e.printStackTrace();
            out.println(e.getMessage());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("allmystudent");
        dispatcher.forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
