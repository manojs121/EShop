<html>
    <body>
        <h3>Online Shop</h3>
        <h3>Product-Entry-Form</h3>
        <hr>
        <form action="SaveProduct">
            <pre>
            PCode       <input type="text" name="pcode"/>
            Name        <input type="text" name="pname"/>
            Desc        <input type="text" name="pdesc"/>
            Category    <select name="pcat">
                        <option>auto</option>
                        <option>books</option>
                        <option>computers</option>
                        <option>electronics</option>
                        <option>furniture</option>
                        <option>others</option>
                        </select>
            Price       <input type="text" name="price"/>
                        <input type="submit" value="Save"/>
            </pre>
        </form>
        <hr>
        <a href="adminpage.jsp">Admin-Home</a>
    </body>
</html>
