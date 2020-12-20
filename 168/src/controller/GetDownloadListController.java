package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Download;
import dao.DownloadDao;

@WebServlet(urlPatterns="/getDownloadList.do")
public class GetDownloadListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DownloadDao dao = new DownloadDao();
		ArrayList<Download> list = dao.query();
		request.setAttribute("downloadList", list);
		//信息转发
		RequestDispatcher rd = request.getRequestDispatcher("/download.jsp");
		rd.forward(request, response);
	}

}
