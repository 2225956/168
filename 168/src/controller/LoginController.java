package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.UserDao;

@WebServlet(urlPatterns="/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//勾选了 登录的同时向浏览器存cookie的值，并设定保存一周的时间
		

		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		//获取session对象
		HttpSession session = request.getSession();
		//取出CreateVerifyImageController中存放的验证码字符串
		String saveVcode = (String) session.getAttribute("verifyCode");
		String forwardPath = ""; 
		//判断用户是否正确输入验证码
		if (!vcode.equalsIgnoreCase(saveVcode)) {
			//验证码错误
			request. setAttribute("info", "验证码不正确! ");
			forwardPath = "/error.jsp";} else {
			//验证码正确
			UserDao userDao = new UserDao();
			User user=userDao.get(userName);
			//判断用户名是否在数据库中	
			if (user == null) {
					//用户名不存在
					request. setAttribute("info", "您输入的用户名不存在! ");
					forwardPath = "/error.jsp";} else {
						//用户名存在
						if (!user.getPassword() .equals(password)){
							//密码错误
							request. setAttribute ("info", "您输入的密码不正确! ");
							forwardPath = "/error.jsp";
						}
						else {
							//用户名密码正确将需要传递的数据存放在session域或范围中,一个会话阶段的所有程序都可以从中获取
							session.setAttribute("currentUser", user);
							forwardPath = "/main.isp";
							//转发信息
							RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
							rd.forward(request, response);
						}
				}
		}
		
		
	}

}
