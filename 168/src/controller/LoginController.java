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
		//��ѡ�� ��¼��ͬʱ���������cookie��ֵ�����趨����һ�ܵ�ʱ��
		

		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		//��ȡsession����
		HttpSession session = request.getSession();
		//ȡ��CreateVerifyImageController�д�ŵ���֤���ַ���
		String saveVcode = (String) session.getAttribute("verifyCode");
		String forwardPath = ""; 
		//�ж��û��Ƿ���ȷ������֤��
		if (!vcode.equalsIgnoreCase(saveVcode)) {
			//��֤�����
			request. setAttribute("info", "��֤�벻��ȷ! ");
			forwardPath = "/error.jsp";} else {
			//��֤����ȷ
			UserDao userDao = new UserDao();
			User user=userDao.get(userName);
			//�ж��û����Ƿ������ݿ���	
			if (user == null) {
					//�û���������
					request. setAttribute("info", "��������û���������! ");
					forwardPath = "/error.jsp";} else {
						//�û�������
						if (!user.getPassword() .equals(password)){
							//�������
							request. setAttribute ("info", "����������벻��ȷ! ");
							forwardPath = "/error.jsp";
						}
						else {
							//�û���������ȷ����Ҫ���ݵ����ݴ����session���Χ��,һ���Ự�׶ε����г��򶼿��Դ��л�ȡ
							session.setAttribute("currentUser", user);
							forwardPath = "/main.isp";
							//ת����Ϣ
							RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
							rd.forward(request, response);
						}
				}
		}
		
		
	}

}
