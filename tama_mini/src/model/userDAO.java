package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.userVO;

public class userDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
 
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_d_2_0115";
			String password = "smhrd2";

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(rs != null) {
			rs.close();
						
			}
			if(pst != null) {
			pst.close();
			}
			if(conn != null) {
			conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public boolean insertUser(String id, String passWord) {
		
		boolean check = false;

		try { 
			connect();
			
			String sql = "insert into user_info values(?, ?)";

			
			pst = conn.prepareStatement(sql);

			
			pst.setString(1, id);
			pst.setString(2, passWord);

			
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				check = true;
			} else { 
				check = false;
			}

			
		} catch (Exception e) { 
			
			System.out.println("Coming soon");
		
		} finally {
		
			close();
		}
		return check;
	}
	public ArrayList<userVO> selectUser() {
		ArrayList<userVO> al = new ArrayList<userVO>();

		try {

			connect();
			
			String sql = "select * from user_info";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt(1); 
				String id = rs.getString("id");
				String passWord = rs.getString("passWord");

				al.add(new userVO(num, id, passWord));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			close();
		}
		return al;
	}
	
	
	public int login(String id, String passWord) {

		try {

			connect();

			String sql = "select passWord from user_info where id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				if(rs.getString(1).contentEquals(passWord)) {
					return 1;
				}else {
					return 0;
				}
			}
			return -1;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			close();
		}
		return -2;
	}
	
	
}