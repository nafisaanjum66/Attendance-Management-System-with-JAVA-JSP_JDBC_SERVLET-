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

       <%-- <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/person"
                   class="nav-link">Persons</a></li>
        </ul>--%>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <caption>
                <h2>
                    Faculty Registration
                </h2>
            </caption>


            <form action="registration" method="post">


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
                    <label>Username</label>
                    <label>
                        <%--<input type="text" value="<c:out value='${person.name}'/>" class="form-control" name="name"
                               required="required"/>--%>
                        <input type="text"  class="form-control" name="username"
                               required="required"/>
                    </label>

                </fieldset>
                <fieldset class="form-group">
                    <label>Password</label>
                    <label>
                        <input type="password"  class="form-control" name="password"
                               required="required"/>
                    </label>

                </fieldset>

                    <fieldset class="form-group">
                        <label>Full name</label>
                        <label>
                            <input type="text"  class="form-control" name="fullname"
                                   required="required"/>
                        </label>

                    </fieldset>

                    <fieldset class="form-group">
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

                </fieldset>

                <button type="submit" class="btn btn-success" >Registration</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="login.jsp">Take me to Login</a>


            </form>


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
</body>
</html>

