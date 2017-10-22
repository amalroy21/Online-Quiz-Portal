<%
session.setAttribute("un", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>