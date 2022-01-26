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
            <a href="#" class="navbar-brand"> Attendance Management System </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/registration.jsp"
                   class="nav-link">Registration</a></li>
        </ul>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/login.jsp"
                   class="nav-link">Login</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <caption>
                <h2>
                    Change Passsword
                    <hr>
                </h2>
            </caption>

            <form action="forgetpassword" method="post">


                <%--<c:set var="username" scope="session" value='<%= session.getAttribute("username")%>'>
                </c:set>--%>
                <%--<c:if test="${person.id != null}">--%>


                <%-- <fieldset class="form-group">
                     &lt;%&ndash;<label>ID</label>&ndash;%&gt;
                     <label>
                         <input type="hidden" name="id"  class="form-control" />
                     </label>

                 </fieldset>--%>

                <%--</c:if>--%>


                    <%--<label>Username</label>--%>

                        <%--<input type="text" value="<c:out value='${person.name}'/>" class="form-control" name="name"
                               required="required"/>--%>
                        <input type="hidden" class="form-control" value='<%= session.getAttribute("uname")%>' name="username"
                               required="required"/>



                <fieldset class="form-group">
                    <label>New Password</label>
                    <label>
                        <input type="password" class="form-control" name="password"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Re-Type New Password</label>
                    <label>
                        <input type="password" class="form-control" name="retypepassword"
                               required="required"/>
                    </label>

                </fieldset>

                <%--<fieldset class="form-group">
                    &lt;%&ndash;<label>Today's Date</label>&ndash;%&gt;
                    <a href="forget-password.jsp">Forget Password</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="registration.jsp" style="color: red">Sign Up</a>

                    &lt;%&ndash;<label>
                        <input type="date"  class="form-control" name="todaydate"
                               required="required"/>
                    </label>&ndash;%&gt;

                </fieldset>--%>

                <%--                <fieldset class="form-group">
                                    <label>Mobile No</label>
                                    <label>
                                        <input type="text"  class="form-control" name="mobile"
                                               required="required"/>
                                    </label>

                                </fieldset>


                                <fieldset class="form-group">
                                    <label>Date of Birth</label>
                                    <label>
                                        <input type="date"  class="form-control" name="dob"
                                               required="required"/>
                                    </label>

                                </fieldset>
                                <fieldset class="form-group">
                                    <label>Qualification</label>
                                    <label>
                                        <input type="text" class="form-control" name="qualification"
                                               required="required"/>
                                    </label>

                                </fieldset>--%>

                <button type="submit" class="btn btn-success">Change</button>


            </form>


        </div>
    </div>
</div>
</body>
</html>

