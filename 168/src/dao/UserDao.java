package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.User;



public class UserDao {
	public User get(String userName) { 
		User user = null;
		try{ 
			//��������
			Class.forName ("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection con=DriverManager.getConnection("idbc:mysql://127.0.0.1:3306/excise ?useunicode-true&character=utf-8","root", "990428");
			//������ѯ
			String sql="select* from t_user where username=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs=pst.executeQuery();
			//�жϼ�������
			if(rs.next()){
				user=new User(rs.getString("userName")
						,rs.getString("password")
						,rs.getString("chrName"));
					}
			//����
			con.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return user;
			
	}

}


