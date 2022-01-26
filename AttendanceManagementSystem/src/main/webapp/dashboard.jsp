<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Attendance Management System</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<c:set var="msg" scope="request" value='<%= session.getAttribute("token")%>'>
</c:set>
<c:if test="${fn:contains(msg, '1')}">

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blueviolet">
        <div>
            <a href="#" class="navbar-brand"> Attendance Management System </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/dashboard" class="nav-link">Dashboard</a></li>
            <li><a href="<%=request.getContextPath()%>/allmystudent" class="nav-link">All My Students</a></li>
            <li><a href="<%=request.getContextPath()%>/profile" class="nav-link">My Profile</a></li>
            <li><a href="<%=request.getContextPath()%>/changepassword" class="nav-link">Change Password</a></li>
            <li>
                <a href="<%=request.getContextPath()%>/login.jsp" class="nav-link">Sign Out</a></li>

        </ul>
    </nav>
</header>
<br>
<div class="container col-md-12">
    <center>
        <h2>Welcome, <%= session.getAttribute("username")%>
        </h2>
        <hr>
        <h3>Record For <%= session.getAttribute("todaydate")%>
        </h3>
        <br>
    </center>


        <%--<c:set var="username" scope="request" value='<%= session.getAttribute("username")%>'>
        </c:set>
        <c:set var="todaydate" scope="request" value='<%= session.getAttribute("todaydate")%>'>
        </c:set>--%>

        <%--<input type="text" name="username" value="<%= session.getAttribute("username")%>" readonly/>
        <input type="text" name="todaydate" value="<%= session.getAttribute("todaydate")%>" readonly/>--%>

    <div class="row">


        <div class="container">
                <%--<h3 class="text-center">List of Persons</h3>
                <hr>--%>
                <%--<div class="container text-left">

                    <a href="<%=request.getContextPath()%>/addnew-student.jsp" class="btn btn-success">Add
                        New Student</a>

                </div>

    --%>
            <div class="row">
                <div class="col-md-4">
                    <div class="container text-center">

                        <a href="<%=request.getContextPath()%>/addnew-student.jsp" class="btn btn-success">Add
                            New Student</a>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="container text-left">

                        <form action="searchdashboardstudent" method="get">
                            <input type="text" class="form-control" name="searchDashboardStudent"
                                   placeholder="Search Here..."/>
                        </form>

                    </div>
                </div>
                <div class="col-md-4">
                        <div class="container text-left">

                            <form action="generatereportofdashboardstudent" method="get">
                                <div class="row">
                                    <div class="col-md-6">
                                <select name="attendance" class="form-control">
                                    <option value="all">All</option>
                                    <option value="present">Present</option>
                                    <option value="absent">Absent</option>
                                </select>
                                    </div>


                                    <div class="col-md-6">
                                <input type="submit" class="form-control" name="generateDashboardStudent"
                                       value="Generate Report" style="background-color: red"/>
                                    </div>
                                </div>

                            </form>

                        </div>
                </div>
            </div>

            <div>


                <div>
                    <c:set var="msg" scope="request" value='<%= request.getAttribute("msg")%>'>
                    </c:set>
                    <c:if test="${fn:contains(msg, 'failed')}">
                        <b>Failed to update attendance...Try again</b>
                    </c:if>
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Student Name</th>
                        <th>Roll No</th>
                        <th>Course</th>
                        <th>Semester</th>
                        <th>Branch</th>
                        <th>Attendance</th>
                        <th>Action</th>
                        <th>RE-Consider</th>
                    </tr>
                    </thead>
                    <tbody>

                        <%--<jsp:useBean id="listPerson" scope="request" type="java.util.List"/>--%><%--
<c:if test="${fn:contains(message, 'success')}">
            <c:forEach var="person" items="${listPerson}">--%>
                        <%--<c:set var="username" scope="request" value='<%= session.getAttribute("username")%>'>
                        </c:set>
                        <c:set var="todaydate" scope="request" value='<%= session.getAttribute("todaydate")%>'>
                        </c:set>--%>

                    <c:forEach var="student" items='<%= request.getAttribute("listStudent")%>'>

                        <tr>
                            <td><c:out value="${student.id}"/></td>
                            <td><c:out value="${student.sname}"/></td>
                            <td><c:out value="${student.rollno}"/></td>
                            <td><c:out value="${student.course}"/></td>
                            <td><c:out value="${student.semester}"/></td>
                            <td><c:out value="${student.branch}"/></td>
                            <td>
                                <c:if test="${empty student.attendance}">
                                    <button class="btn btn-success">
                                        <a style="color: aliceblue"
                                           href="<%=request.getContextPath()%>/present?id=${student.id}">P</a>
                                    </button>
                                    ||
                                    <button class="btn btn-danger">
                                        <a style="color: aliceblue"
                                           href="<%=request.getContextPath()%>/absent?id=${student.id}">A</a>
                                    </button>

                                </c:if>
                                <c:if test="${not empty student.attendance}">
                                    <c:out value="${student.attendance}"/>
                                </c:if>
                            </td>

                            <td>
                                <a href='<%=request.getContextPath()%>/updatestudent?id=${student.id}'>Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href='<%=request.getContextPath()%>/deletestudent?id=${student.id}'>Delete</a>
                            </td>
                            <td>
                                <c:if test="${not empty student.attendance}">
                                    <a href='<%=request.getContextPath()%>/updateattendance?id=${student.id}'>Change</a>
                                </c:if>

                            </td>
                        </tr>
                    </c:forEach>
                        <%--</c:if>--%>

                    </tbody>

                </table>
            </div>
        </div>

    </div>
    </c:if>
    <c:if test="${!fn:contains(msg, '1')}">
            <%
        response.sendRedirect("login.jsp");
    %>
    </c:if>
</body>
</html>

