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
			//加载驱动
			Class.forName ("com.mysql.jdbc.Driver");
			//连接数据库
			Connection con=DriverManager.getConnection("idbc:mysql://127.0.0.1:3306/excise ?useunicode-true&character=utf-8","root", "990428");
			//方法查询
			String sql="select* from t_user where username=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs=pst.executeQuery();
			//判断加载数据
			if(rs.next()){
				user=new User(rs.getString("userName")
						,rs.getString("password")
						,rs.getString("chrName"));
					}
			//关流
			con.close();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return user;
			
	}

}


