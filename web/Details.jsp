<%@page  isThreadSafe="false" errorPage="myerrors.jsp" contentType="text/html" import="java.sql.*"%>

<%@include file="header.jsp" %>
<%!
    private int highDis=20;
    private int lowDis=10;

    int getDiscount(int price){
        int dis=0;
        if(price>=50000){
            dis=price*highDis/100;
        }else{
            dis=price*lowDis/100;
        }
        return dis;
    }
%>
<%
    int x=10;
    String qr="select * from products where pcode=?";
    String s=request.getParameter("t1");
    int id=Integer.parseInt(s);
    Connection con=mypkg.Data.connect();
    PreparedStatement ps=con.prepareStatement(qr);
    ps.setInt(1, id);
    ResultSet rs=ps.executeQuery();
    rs.next();
    String s1=rs.getString(1);
    String s2=rs.getString(2);
    String s3=rs.getString(3);
    String s4=rs.getString(4);
    String s5=rs.getString(5);
%>
<html>
    <body>
        <h3>Product-Details</h3>
        <table border="2" width="2" cellspacing="2" cellpadding="2">
           <tbody>
                <tr>
                    <td>Code</td>
                    <td><%=s1%></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><%=s2%></td>
                </tr>
                <tr>
                    <td>Desc</td>
                    <td><%=s3%></td>
                </tr>
                <tr>
                    <td>Catg</td>
                    <td><%=s4%></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><%=s5%></td>
                </tr>
                <tr>
                    <td>Disc</td>
                    <td><%=getDiscount(Integer.parseInt(s5))%></td>
                </tr>
            </tbody>
        </table>
        <hr>
        <a href="buyerpage.jsp">Home</a>
    </body>
</html>
<%
    con.close();
%>