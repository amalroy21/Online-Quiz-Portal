<%
HttpSession sh=request.getSession(false);
sh.invalidate();
response.sendRedirect("index.jsp");
%>