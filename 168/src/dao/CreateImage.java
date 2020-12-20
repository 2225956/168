package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;





public class CreateImage {
	//��ʼ����Ϣ��ͼƬ�ĳߴ磬��֤���ַ���������������
	private static final int WIDTH = 100;
	private static final int HEIGHT = 30;
	private static final int LENGTH = 4;
	private static final int LINECOUNT = 6;
	
	//��֤�����ɳɷ�
	private static final String str = "123456789" + "QWERTYUIOPASDFHGHJKLZXCVBNM"+"qwertyuiopasdfghjklzxcvbnm";
	
	private static Random random = new Random();
	//���ȡֵ��������֤��
	public String createCode(){
		String code = "";
		for(int i = 0;i < LENGTH;i++){
			char c = str.charAt(random.nextInt(str.length()));
			
			code = code + c;
		}
		return code;
	}
	//��֤�������ɫ
	public Color getColor(){
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	//��֤��������ʽ
	public Font getFont(){
		return new Font("����",Font.BOLD,23);
	}
	//����������������֤���ַ�
	public void drowChar(Graphics g,String code){
		g.setFont(getFont());
		for(int i =0;i<LENGTH;i++){
			char c = code.charAt(i);
			g.setColor(getColor());
			g.drawString(c + "", 20 * i + 10, 25);
		}
	}
	//��Ӹ�����
	public void drawLine(Graphics g){
		int x = random.nextInt(WIDTH);
		int y = random.nextInt(HEIGHT);
		int x1 = random.nextInt(13);
		int y1 = random.nextInt(13);
		
		g.setColor(getColor());
		g.drawLine(x, y, x1, y1);
	}
	//�������յ���֤��ͼƬ
	public BufferedImage CreateImage(String code){
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = image.getGraphics();
		g.setColor(new Color(200,200,200));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		drowChar(g, code);
		for (int i = 0; i < LENGTH; i++) {
			drawLine(g);
		}
		g.dispose();
		
		return image;//�������ͼƬ
	}

	
	
	
	
	
	
}
