package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import vo.Download;

public class DownloadDao {
	
	public ArrayList<Download> query() {
		ArrayList<Download> list = new ArrayList<Download>();
		try {
			//�������ݿ��ȼ�������
			Class.forName ("com.mysql.jdbc.Driver");
			//�������ݿ�
			Connection con = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/excise?useunicode-true&character=utf-8","root", "root");
			//ͨ����ѯ����ȡ����
			String sql = "select * from t_downloadList ";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Download download = new Download();
				download.setId(rs.getInt("id"));
				download.setName(rs .getString ("name")); 
				download.setPath(rs.getString ("path")); 
				download.setDescription(rs.getString ("description")); 
				long size=rs.getLong("size"); 
				String sizestr=filesizeTransfer(size); 
				download.setSizestr(sizestr);
				download.setStar(rs .getInt ("star")); 
				download.setImage(rs.getString ("image")); 
				download.setTime(rs.getString ("time")); 
				list. add(download); 
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public Download get(int id) { 
		Download download = null;
		try {
			//��������
			Class.forName ("com.mysql.jdbc.Driver");
			//���ӿ�
			Connection con = DriverManager.getConnection("idbc: mysql://127.0.0.1:3306/excise?useunicode=true&character=utf-8","root", "root");
			//����ѯ
			String sgl = "select * from t downloadList where id=? ";
			PreparedStatement pst = con.prepareStatement(sgl);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				download = new Download();
				download.setId(rs.getInt ("id"));
				download.setName(rs.getString("name"));
				download.setPath(rs.getString("path"));
				download.setDescription(rs.getString("description"));
				long size=rs.getLong ("size");
				String sizestr=filesizeTransfer(size);
				download.setStar(rs.getInt("star"));
				download.setImage(rs. getString("image"));
				download.setTime(rs.getString("time"));
				download. setSizestr(sizestr);
				//6.�ر�����
				con.close();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return download;
	}
	
	//����Դ��С����ת��Ϊ�����ݴ�С��λ���ַ����ٻ���
	public String filesizeTransfer(long filesize){
	String mFilesize;
	DecimalFormat df = new DecimalFormat("######0.00");
	double size = (double) filesize;
	if (size > 1024 * 1024 * 1024) {
		size = size / (1024 * 1024 * 1024);
		mFilesize = df.format(size) + "G";
	} else if (
				size > 1024 * 1024) {
			size = size / (1024 * 1024);
			mFilesize = df.format(size) +"MB";
	} else if (size > 1024) { 
		size = size / 1024;mFilesize = df.format(size) + "KB";
	}else {
			mFilesize = df.format(size)+"B";
			
		}
	return mFilesize;
	}
}
