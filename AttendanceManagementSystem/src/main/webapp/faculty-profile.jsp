
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
                    Update Faculty Info
                </h2>
            </caption>
            <c:set var="msg" scope="request" value='<%= request.getAttribute("msg")%>'>

            </c:set>

            <c:if test="${fn:contains(msg, 'success')}">
                <p>Updated <b>Successfully</b></p>
            </c:if>
            <c:if test="${fn:contains(msg, 'failed')}">
                <p>Updated <b>Failed... Try Again</b></p>
            </c:if>

            <form action="profile" method="post">


                <c:set var="person" scope="request" value='<%= request.getAttribute("person")%>'>
                </c:set>
                <%--<c:if test="${person.id != null}">--%>


                <fieldset class="form-group">
                    <label>Faculty ID</label>
                    <label>
                        <input type="text" value="${person.id}" name="id"  class="form-control" readonly/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Username</label>
                    <label>
                        <input type="text" value="${person.username}" name="username"  class="form-control" readonly/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Password</label>
                    <label>
                        <input type="password" value="${person.password}" name="password"  class="form-control" readonly/>
                    </label>

                </fieldset>




                <%--</c:if>--%>

                <fieldset class="form-group">
                    <label>Full Name</label>
                    <label>
                        <%--<input type="text" value="<c:out value='${person.name}'/>" class="form-control" name="name"
                               required="required"/>--%>
                        <input type="text" value="${person.fullname}"  class="form-control" name="fullname"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Mobile No</label>
                    <label>
                        <input type="text" value="${person.mobile}"  class="form-control" name="mobile"
                               required="required"/>
                    </label>

                </fieldset>

                <fieldset class="form-group">
                    <label>Date of Birth</label>
                    <label>
                        <input type="text" value="${person.dob}"  class="form-control" name="dob"
                               required="required"/>
                    </label>

                </fieldset>

                <fieldset class="form-group">
                    <label>Qualification</label>
                    <label>
                        <input type="text" value="${person.qualification}"  class="form-control" name="qualification"
                               required="required"/>
                    </label>

                </fieldset>


                <%--<fieldset class="form-group">
                    <label>Branch</label>
                    <label>
                        <input type="text" value="${student.branch}"  class="form-control" name="branch"
                               required="required"/>
                    </label>

                </fieldset>--%>
                <%--<fieldset class="form-group">
                    <label>Attendance</label>
                    <label>
                        <input type="text" class="form-control" name="attendance"
                               required="required"/>
                    </label>

                </fieldset>--%>
                <%--<input type="text" value="" class="form-control" name="attendance"
                       />--%>

                <button type="submit" class="btn btn-success" >Submit</button>


            </form>


        </div>
    </div>
</div>
</body>
</html>


