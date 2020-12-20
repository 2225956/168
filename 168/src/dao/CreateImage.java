package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;





public class CreateImage {
	//初始化信息（图片的尺寸，验证码字符数，干扰线数）
	private static final int WIDTH = 100;
	private static final int HEIGHT = 30;
	private static final int LENGTH = 4;
	private static final int LINECOUNT = 6;
	
	//验证码的组成成分
	private static final String str = "123456789" + "QWERTYUIOPASDFHGHJKLZXCVBNM"+"qwertyuiopasdfghjklzxcvbnm";
	
	private static Random random = new Random();
	//随机取值，构成验证码
	public String createCode(){
		String code = "";
		for(int i = 0;i < LENGTH;i++){
			char c = str.charAt(random.nextInt(str.length()));
			
			code = code + c;
		}
		return code;
	}
	//验证码随机颜色
	public Color getColor(){
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	//验证码字体样式
	public Font getFont(){
		return new Font("黑体",Font.BOLD,23);
	}
	//按上述方法生成验证码字符
	public void drowChar(Graphics g,String code){
		g.setFont(getFont());
		for(int i =0;i<LENGTH;i++){
			char c = code.charAt(i);
			g.setColor(getColor());
			g.drawString(c + "", 20 * i + 10, 25);
		}
	}
	//添加干扰线
	public void drawLine(Graphics g){
		int x = random.nextInt(WIDTH);
		int y = random.nextInt(HEIGHT);
		int x1 = random.nextInt(13);
		int y1 = random.nextInt(13);
		
		g.setColor(getColor());
		g.drawLine(x, y, x1, y1);
	}
	//生成最终的验证码图片
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
		
		return image;//返回这个图片
	}

	
	
	
	
	
	
}
