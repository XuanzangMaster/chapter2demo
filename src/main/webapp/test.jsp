<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>JSP学习</title>
</head>
<body>
<h2>HTTP Header Request Example</h2>
<table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
        <th>Header Name</th> <th>Header Value</th>
    </tr>
    <%
    Enumeration enumeration = request.getHeaderNames();
    while (enumeration.hasMoreElements()) {
        String headerName = (String) enumeration.nextElement();
        String headerValue = request.getHeader(headerName);
        out.print("<tr><td>" + headerName + "</td>" + "<td>" + headerValue + "</td></tr>");
    }
    %>

</table>

<h2>姓名：<%= request.getParameter("name")%></h2>
<h2>年龄：<%= request.getParameter("age")%></h2>

</body>
</html>
