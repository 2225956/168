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
		//��װ������
		String vCode = createImage.createCode();
		//��ȡ����ַ���
		HttpSession session = request.getSession();
		//��ȡsession����
		session.setAttribute("verifyCode", vCode);
		//���ɵ��ַ�������session������һ������
		
		response.setContentType("img/jpeg");
		//����ͼƬ��ָ���ļ���
		BufferedImage image = createImage.CreateImage(vCode);
		//�÷�װ�õķ���ȥ���������ͼƬ��ʽ
		ServletOutputStream out = response.getOutputStream();
		//�ֽ������
		ImageIO.write(image, "JPEG", out);
		//�����ʽָ��
		out.flush();//��ջ��������������
		out.close();//����
	}

	

}
