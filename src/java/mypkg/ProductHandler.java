package mypkg;
import java.sql.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ProductHandler extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try{
            String qr="select * from products";
            Connection con=mypkg.Data.connect();
            PreparedStatement ps=con.prepareStatement(qr);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String s1=rs.getString(1);
                String s2=rs.getString(2);
                String s3=rs.getString(3);
                String s4=rs.getString(4);
                String s5=rs.getString(5);
                out.println(s1+","+s2+","+s3+","+s4+","+s5+"<br>");
            }
            con.close();
            
        }catch(Exception e){}
    }
    
}
