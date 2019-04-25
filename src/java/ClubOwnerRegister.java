/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.Club_OwnerDAO;
import dto.Club_OwnerBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GAGAN
 */
@WebServlet(urlPatterns = {"/ClubOwnerRegister"})
public class ClubOwnerRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
            String userid=request.getParameter("userid");
            String pass=request.getParameter("pass");
            String owner_name=request.getParameter("name");
            String cont_no=request.getParameter("cont_no");
            
            
            Club_OwnerBean owner=new Club_OwnerBean();
            owner.setUserid(userid);
            owner.setPassword(pass);
            owner.setOwner_name(owner_name);
            owner.setContact_no(cont_no);
            
            Club_OwnerDAO ob=new Club_OwnerDAO();
            int count=ob.insertOwner(owner);
            
            if(count==1)
            {
                HttpSession session=request.getSession();
                session.setAttribute("userid",userid);
                response.sendRedirect("club_register.jsp");
            }
            else
            {
                request.setAttribute("res","Registeration Failed");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
    
    }

 
}
