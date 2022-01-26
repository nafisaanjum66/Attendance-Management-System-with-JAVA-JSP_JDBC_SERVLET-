
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
             <li><a href="<%=request.getContextPath()%>/login.jsp"
                    class="nav-link">Sign Out</a></li>
         </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <caption>
                <h2>
                    Add New Student
                </h2>
            </caption>


            <form action="addnewstudent" method="post">


                <%--<c:set var="person" scope="request" value='<%= request.getAttribute("person")%>'>
                </c:set>
                <c:if test="${person.id != null}">--%>


                <fieldset class="form-group">
                    <%--<label>ID</label>--%>
                    <label>
                        <input type="hidden" name="id"  class="form-control" />
                    </label>

                </fieldset>

                <%--</c:if>--%>

                <fieldset class="form-group">
                    <label>Student Name</label>
                    <label>
                        <%--<input type="text" value="<c:out value='${person.name}'/>" class="form-control" name="name"
                               required="required"/>--%>
                        <input type="text"  class="form-control" name="sname"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Roll No</label>
                    <label>
                        <input type="text"  class="form-control" name="rollno"
                               required="required"/>
                    </label>

                </fieldset>

                <fieldset class="form-group">
                    <label>Course</label>
                    <label>
                        <input type="text"  class="form-control" name="course"
                               required="required"/>
                    </label>

                </fieldset>

                <fieldset class="form-group">
                    <label>Semester</label>
                    <label>
                        <input type="text"  class="form-control" name="semester"
                               required="required"/>
                    </label>

                </fieldset>


                <fieldset class="form-group">
                    <label>Branch</label>
                    <label>
                        <input type="text"  class="form-control" name="branch"
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
<%--                    <input type="hidden" value="" class="form-control" name="attendance"--%>
<%--                           required="required"/>--%>

                <button type="submit" class="btn btn-success" >Add Student</button>


            </form>


        </div>
    </div>
</div>
</body>
</html>


