

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String ch=request.getParameter("radchoice");
        
        if(ch.equals("club_owner"))
            response.sendRedirect("club_owner_register.jsp");
        else
            response.sendRedirect("club_member_register.jsp");
        
    }
}
