import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s=request.getParameter("ct");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String qr="select pcode, pname from products where pcat=?";
        try{
            Connection con=mypkg.Data.connect();
            PreparedStatement ps=con.prepareStatement(qr);
            ps.setString(1, s);
            ResultSet rs=ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Select Desired Product</h3>");
            out.println("<hr>");
            while(rs.next()){
                String s1=rs.getString(1);//code
                String s2=rs.getString(2);//name
                out.println("<a href=ProductDetails?id="+s1+">");
                out.println(s2);
                out.println("</a>");
                out.println("<br>");
            }
            out.println("<hr>");
            out.println("<a href=CategoryPage>Category-Page</a><br>");
            out.println("<a href=buyerpage.jsp>Buyer-Home</a><br>");
            out.println("</body>");
            out.println("</html>");
            
        }catch(Exception ex){
            out.println(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
