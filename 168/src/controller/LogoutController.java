package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//É¾³ýä¯ÀÀÆ÷ÖÐµÄcookie
		
		
		HttpSession session = request.getSession(); 
		session. removeAttribute("currentUser"); 
		
		response.sendRedirect("login.html"); 
	
	}

	

}
