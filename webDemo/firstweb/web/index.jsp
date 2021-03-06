<%--
  Created by IntelliJ IDEA.
  User: Nightcat
  Date: 2018-09-02
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.test.jsp.*, java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <h3>JSP build-in objects</h3>
  Request user agent: <%= request.getHeader("User-Agent")%>
  <br>
  Request language: <%= request.getLocale() %>

  <h3>JSP Expression</h3>
    Current time: <%= new java.util.Date()%><br>
    Convert a string to uppercase: <%= new String("Hello World.").toUpperCase()%><br>
    25 * 4 = <%= 25*4%> <br>
    Is 75 less than 69? <%= 75<69%><br>
    <br>

  <h3>JSP Scriptlet</h3>
    Count down: <br>
    <%
      for (int i = 10; i >= 0; i--) {
          out.println(i + "<br>");
      }
    %>

  <h3>JSP Declaration</h3>
  <%!
    String makeItLower(String data) {
        return data.toLowerCase();
    }
  %>
  Lower case "Hello World": <%= makeItLower("Hello World")%>

  <h3>Call Java Class from JSP</h3>
  Let's have some fun: <%= FunUtils.makeItLower("FUN FUn FUn")%>

  </body>
</html>
