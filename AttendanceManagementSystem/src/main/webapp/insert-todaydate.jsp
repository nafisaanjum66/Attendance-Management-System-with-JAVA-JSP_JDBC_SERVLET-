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
<%--    <b>Failed to update attendance...Try again</b>--%>

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
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <caption>
                <h2>
                    Please Enter Today's Date here
                </h2>
            </caption>

            <form action="inserttodaydate" method="post">


                <%--<c:set var="person" scope="request" value='<%= request.getAttribute("person")%>'>
                </c:set>
                <c:if test="${person.id != null}">--%>


                <%-- <fieldset class="form-group">
                     &lt;%&ndash;<label>ID</label>&ndash;%&gt;
                     <label>
                         <input type="hidden" name="id"  class="form-control" />
                     </label>

                 </fieldset>--%>

                <%--</c:if>--%>
                <%--<c:set var="person" scope="request" value='<%= session.getAttribute("")%>'>
                </c:set>--%>
                <fieldset class="form-group">
                    <label>Username</label>
                    <label>
                        <%--<input type="text" value="<c:out value='${person.name}'/>" class="form-control" name="name"
                               required="required"/>--%>
                        <input type="text" class="form-control" value="<%= session.getAttribute("username")%>" name="username"
                               required="required" readonly/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Password</label>
                    <label>
                        <input type="password" class="form-control" value="<%= session.getAttribute("password")%>" name="password"
                               required="required" readonly/>
                    </label>

                </fieldset>

                <fieldset class="form-group">
                    <label>Today's Date</label>
                    <label>
                        <input type="date" class="form-control" name="todaydate"
                               required="required"/>
                    </label>


                </fieldset>

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

                <button type="submit" class="btn btn-success">Enter</button>


            </form>
<%--            <a href="<%=request.getContextPath()%>/logout">logout</a>--%>
            <a href="logout">Logout</a>


            <%--<form action="registration" method="post">

                &lt;%&ndash;<c:if  test='<%= request.getAttribute("person")%> != null'>&ndash;%&gt;
                &lt;%&ndash;<%=String c =<c:out value='<%= request.getAttribute("person")%>'/>.id%>&ndash;%&gt;
                <c:set var="person" scope="request" value='<%= request.getAttribute("person")%>'>
                </c:set>
                <c:if test="${person.id != null}">

                    &lt;%&ndash;<input type="hidden" name="id" value="<c:out value='${person.id}' />" />&ndash;%&gt;
                    &lt;%&ndash;<input type="hidden" name="id" value="<c:out value='<%= request.getAttribute("person")%>'/>.id "/>&ndash;%&gt;
                    &lt;%&ndash;<input type="text" name="id" value="<c:out value='${person.id}'/> "/>&ndash;%&gt;
                    <fieldset class="form-group">
                        <label>ID</label>
                        <label>
                            <input type="text" name="id" value="${person.id}" class="form-control" required="required" readonly/>
                        </label>

                    </fieldset>

                </c:if>

                <fieldset class="form-group">
                    <label>Name</label>
                    <label>
                        &lt;%&ndash;<input type="text" value="<c:out value='${person.name}'/>" class="form-control" name="name"
                               required="required"/>&ndash;%&gt;
                        <input type="text" value="${person.name}" class="form-control" name="name"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Gender</label>
                    <label>
                        <input type="text" value="${person.gender}" class="form-control" name="gender"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Date of Birth</label>
                    <label>
                        <input type="text" value="${person.dob}" class="form-control" name="dob"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Email</label>
                    <label>
                        <input type="text" value="${person.email}" class="form-control" name="email"
                               required="required"/>
                    </label>

                </fieldset>

                <button type="submit" class="btn btn-success" >Add</button>


            </form>--%>

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

