/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.Club_InfoDAO;
import dto.Club_InfoBean;
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
@WebServlet(urlPatterns = {"/ClubRegister"})
public class ClubRegister extends HttpServlet {

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
        
        HttpSession session=request.getSession();
        String userid=(String)session.getAttribute("userid");
        String club_name=request.getParameter("club_name");
        String opening_time=request.getParameter("opening_time");
        String closing_time=request.getParameter("closing_time");
        int no_of_courts=Integer.parseInt(request.getParameter("no_of_courts"));
        
        Club_InfoBean club=new Club_InfoBean();
        club.setClub_name(club_name);
        club.setOpening_time(opening_time);
        club.setClosing_time(closing_time);
        club.setNo_of_courts(no_of_courts);
        
        Club_InfoDAO ob=new Club_InfoDAO();
        int res=ob.insertClub(club,userid);
        
        if(res==1)
        {
             session.removeAttribute("userid");
             session.invalidate();
             request.setAttribute("res","Registered Successfully");
             RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
             rd.forward(request, response);
        }
        else
        {
             request.setAttribute("res","Registeration Failed");
             RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
             rd.forward(request, response);
        }
    }

}
