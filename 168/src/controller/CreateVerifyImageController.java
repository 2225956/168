package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateImage;

@WebServlet(urlPatterns = "/createVerifyImage.do")
public class CreateVerifyImageController extends HttpServlet {
	
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreateImage createImage = new CreateImage();
		//封装生成器
		String vCode = createImage.createCode();
		//获取随机字符串
		HttpSession session = request.getSession();
		//获取session对象
		session.setAttribute("verifyCode", vCode);
		//生成的字符串放在session中做进一步处理
		
		response.setContentType("img/jpeg");
		//返回图片到指定文件夹
		BufferedImage image = createImage.CreateImage(vCode);
		//用封装好的方法去生成所需的图片样式
		ServletOutputStream out = response.getOutputStream();
		//字节流输出
		ImageIO.write(image, "JPEG", out);
		//输出格式指定
		out.flush();//清空缓冲器，立即输出
		out.close();//关流
	}

	

}
