<%
    //session.setMaxInactiveInterval(600);
    int n=session.getMaxInactiveInterval();
%>
<html>
    <body>
        <h3>Welcome Admin</h3>
         <h5>If you remain idle for <%=n%> seconds, your session will expire</h5>
        <hr>
        <pre>
        <a href="pentry.jsp">Add-New-Product</a>
        <a href="">Modify-Product-Details</a>
        <a href="">Remove-Product</a>
        <a href="">View-Orders</a>
        <a href="">Logout</a>
        </pre>
        <hr>
    </body>
</html>
