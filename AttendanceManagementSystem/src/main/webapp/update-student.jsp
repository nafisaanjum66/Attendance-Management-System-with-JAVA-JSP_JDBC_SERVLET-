
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Attendance Management System</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blueviolet">
        <div>
            <a href="<%=request.getContextPath()%>/registration" class="navbar-brand"> Attendance Management System </a>
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
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <caption>
                <h2>
                    Update Student Info
                </h2>
            </caption>


            <form action="updatestudent" method="post">


                <c:set var="student" scope="request" value='<%= request.getAttribute("student")%>'>
                </c:set>
                <%--<c:if test="${person.id != null}">--%>


                <fieldset class="form-group">
                    <label>Student ID</label>
                    <label>
                        <input type="text" value="${student.id}" name="id"  class="form-control" readonly/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Username</label>
                    <label>
                        <input type="text" value="${student.username}" name="username"  class="form-control" readonly/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Date</label>
                    <label>
                        <input type="text" value="${student.todaydate}" name="todaydate"  class="form-control" readonly/>
                    </label>

                </fieldset>




                <%--</c:if>--%>

                <fieldset class="form-group">
                    <label>Student Name</label>
                    <label>
                        <%--<input type="text" value="<c:out value='${person.name}'/>" class="form-control" name="name"
                               required="required"/>--%>
                        <input type="text" value="${student.sname}"  class="form-control" name="sname"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Roll No</label>
                    <label>
                        <input type="text" value="${student.rollno}"  class="form-control" name="rollno"
                               required="required"/>
                    </label>

                </fieldset>

                <fieldset class="form-group">
                    <label>Course</label>
                    <label>
                        <input type="text" value="${student.course}"  class="form-control" name="course"
                               required="required"/>
                    </label>

                </fieldset>

                <fieldset class="form-group">
                    <label>Semester</label>
                    <label>
                        <input type="text" value="${student.semester}"  class="form-control" name="semester"
                               required="required"/>
                    </label>

                </fieldset>


                <fieldset class="form-group">
                    <label>Branch</label>
                    <label>
                        <input type="text" value="${student.branch}"  class="form-control" name="branch"
                               required="required"/>
                    </label>

                </fieldset>
                <%--<fieldset class="form-group">
                    <label>Attendance</label>
                    <label>
                        <input type="text" class="form-control" name="attendance"
                               required="required"/>
                    </label>

                </fieldset>--%>
                                    <%--<input type="text" value="" class="form-control" name="attendance"
                                           />--%>

                <button type="submit" class="btn btn-success" >Update Student</button>


            </form>


        </div>
    </div>
</div>
</body>
</html>


