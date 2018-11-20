<%
  //session.setMaxInactiveInterval(300);
  long val=session.getCreationTime();
  int ia=session.getMaxInactiveInterval();
  java.util.Date dt=new java.util.Date(val);
  String uid=(String)session.getAttribute("userid");
  if(uid==null){
      response.sendRedirect("index.jsp");
  }
%>

<html>
    <body>
        <h3>Welcome <%=uid%></h3>
        <h4>You are with us since <%=dt%></h4>
        <h5>If you remain idle for <%=ia%> seconds, your session will expire</h5>
        <hr>
        <pre>
        <a href="CategoryPage">Explore-Store</a>
        <a href="search.jsp">Search-Product</a>
        <a href="DisplayCart">View-Cart</a>
        <a href="">Confirm-Order</a>
        <a href="EndSession">Logout</a>
        </pre>
        <hr>
    </body>
</html>
