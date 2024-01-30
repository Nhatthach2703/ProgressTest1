<%-- 
    Document   : index
    Created on : Jan 30, 2024, 7:30:11 AM
    Author     : Xuan Vinh
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Child"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <th>Child ID</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
            <%
                List<Child> list = (List<Child>) request.getAttribute("list"); 
                if (list != null) {
                    for (Child y : list) {
            %>
            <tr>
                <td><%= y.getChildID()%></td>
                <td><%= y.getName()%></td>
                <td><%= y.getAge()%></td>
            </tr>
            <%                    
                    }
                }
            %>
        </table>
    </body>
</html>
