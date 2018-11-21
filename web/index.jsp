<%@include file="header.jsp" %>
<html>
    <body>
        <form action="VerifyUser">
            <pre>
            Userid      <input type="text" name="userid"/>
            Password    <input type="password" name="password"/>
            Usertype    <select name="usertype"><option>Buyer</option><option>Admin</option></select>
            Save Pwd    <input type="checkbox" name="save"/>
                        <input type="submit" value="Login"/>
            </pre>
        </form>
        <hr>
        <a href="registration.jsp">New-User</a>
    </body>
</html>
