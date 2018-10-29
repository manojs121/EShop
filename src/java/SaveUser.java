
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUser extends HttpServlet {

    Connection con;
    PreparedStatement ps;

    public void init() {
        try{
        con = mypkg.Data.connect();
        String qr = "insert into users values(?,?,?,?,?,?)";
        ps = con.prepareStatement(qr);
        }catch(Exception e){}
    }

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) {

        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //reads the data coming from client
        //?userid=aaa&password=&username=abc&address=indore&mobile=9909090099&email=abc%40gmail.com
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        //store them to database (using JDBC/Hibernate)
        try {
            ps.setString(1, userid);
            ps.setString(2, password);
            ps.setString(3, username);
            ps.setString(4, address);
            ps.setString(5, mobile);
            ps.setString(6, email);
            ps.executeUpdate();
            out.println("<h3>Registration Successfully Completed</h3>");
            out.println("<h4><a href=index.jsp>Login-Now</a></h4>");
        } catch (Exception e) {
            out.println(e);
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
