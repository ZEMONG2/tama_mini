package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.tamagotchiVO;

public class tamagotchiDAO {
   
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
      }catch(Exception e) {
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
         }if(conn != null) {
         conn.close();
         }
      }catch(SQLException e){
         e.printStackTrace();
      }
   }
   
   //(add)
   public boolean insertTama(String nick, String user_id, int dif) {

      boolean check = false;
      
      try { 
         connect();
          
         
         String sql = "insert into tamagotchi_info values (?, 0, 1, 50, ?, sysdate, null, ?, 50)";
         
         pst = conn.prepareStatement(sql);
         
         pst.setString(1, nick);
         pst.setString(2, user_id);
         pst.setInt(3, dif);
         
         
         int cnt = pst.executeUpdate();
         
         if(cnt>0) {
            check = true;
         }
      } catch (Exception e) { 
         e.printStackTrace(); 
         System.out.println("Coming soon");
      } finally {
         close();
      }
      return check;
      
   }
   
   public tamagotchiVO selectOneInfo(String nick) {
      tamagotchiVO vo = null;

      try {
         connect();

         String sql = "select * from tamagotchi_info where nick = ? and end_date is null";
         pst = conn.prepareStatement(sql);
         pst.setString(1, nick);
         
         rs = pst.executeQuery();


         if (rs.next()) {
            String name = rs.getString("nick");
            int ex = rs.getInt("exp");
            int lev = rs.getInt("lev");
            int energy = rs.getInt("energy");
            String user_id = rs.getString("user_id");
            String start_date = rs.getString("start_date");
            int dif = rs.getInt("dif");
            int full = rs.getInt("full");
            vo = new tamagotchiVO(name, ex, lev, energy, user_id, start_date, dif, full);
         }

      } catch (Exception e) {
         e.printStackTrace();

      } finally {
         close();
      }

      return vo;
   }
   
   public ArrayList<tamagotchiVO> alivedTamaList(){
      ArrayList<tamagotchiVO> al = new ArrayList<tamagotchiVO>();

      try {
         connect();

         String sql = "select * from tamagotchi_info where end_date is null order by lev desc";
         pst = conn.prepareStatement(sql);
         
         rs = pst.executeQuery();


         while(rs.next()) {
            String name = rs.getString("nick");
            String user_id = rs.getString("user_id");
            String start_date = rs.getString("start_date");
            int lev = rs.getInt("lev");
            int dif = rs.getInt("dif");
            int energy = rs.getInt("energy");
            int full = rs.getInt("full");
            int ex = rs.getInt("ex");
            al.add(new tamagotchiVO(name, lev, user_id, start_date, dif, energy, full, ex));
         }

      } catch (Exception e) {
         e.printStackTrace();

      } finally {
         close();
      }

      return al;
   }
   
   public ArrayList<tamagotchiVO> rankList() {
      ArrayList<tamagotchiVO> al = new ArrayList<tamagotchiVO>();

      try {
         connect();

         String sql = "select * from tamagotchi_info where end_date is not null order by lev desc";
         pst = conn.prepareStatement(sql);
         
         rs = pst.executeQuery();


         while(rs.next()) {
            String name = rs.getString("nick");
            int lev = rs.getInt("lev");
            String user_id = rs.getString("user_id");
            String start_date = rs.getString("start_date");
            String end_date = rs.getString("end_date");
            int dif = rs.getInt("dif");
            al.add(new tamagotchiVO(name, lev, user_id, start_date, end_date, dif));
         }

      } catch (Exception e) {
         e.printStackTrace();

      } finally {
         close();
      }

      return al;
   }
   

   
   public boolean updateEndDate(String nick) {

      boolean check = false;
      
      try {
         connect();
         
         String sql = "update tamagotchi_info set end_date = sysdate where nick = ?";

         pst = conn.prepareStatement(sql);
         pst.setString(1, nick);
         
         int cnt = pst.executeUpdate();
         
         if(cnt>0) {
            check = true;
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }finally {
         close();
         
      }
      return check;

}
   public boolean levelUp(String nick) {
	      boolean check = false;
	      
	      try {
	         connect();
	         
	         String sql = "update tamagotchi_info set lev = lev + 1, ex = ex - 100 where nick = ?";

	         pst = conn.prepareStatement(sql);
	         pst.setString(1, nick);
	         
	         int cnt = pst.executeUpdate();
	         
	         if(cnt>0) {
	            check = true;
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally {
	         close();
	         
	      }
	      return check;

   }
   
   
   public boolean updateTamaEx(int a, String nick) {

      boolean check = false;
      
      try {
         connect();
         
         String sql = "update tamagotchi_info set ex = ? where nick = ? and end_date is null";

         pst = conn.prepareStatement(sql);
         pst.setInt(1, a);
         pst.setString(2, nick);
         
         int cnt = pst.executeUpdate();
         
         if(cnt>0) {
            check = true;
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }finally {
         close();
         
      }
      return check;

}
   
   public boolean updateTamaLev(int a, String nick) {

      boolean check = false;
      
      try {
         connect();
         
         String sql = "update tamagotchi_info set lev = ? where nick = ? and end_date is null";

         pst = conn.prepareStatement(sql);
         pst.setInt(1, a);
         pst.setString(2, nick);
         
         int cnt = pst.executeUpdate();
         
         if(cnt>0) {
            check = true;
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }finally {
         close();
      }
      return check;

}
   
   public boolean updateTamaEnergy(int a, String nick) {

      boolean check = false;
      
      try {
         connect();
         
         String sql = "update tamagotchi_info set energy = ? where nick = ? and end_date is null";

         pst = conn.prepareStatement(sql);
         pst.setInt(1, a);
         pst.setString(2, nick);
         
         int cnt = pst.executeUpdate();
         
         if(cnt>0) {
            check = true;
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }finally {
         close();
         
      }
      return check;

}
   
   public boolean sleep(int energy, int full, String nick) {

	      boolean check = false;

	      try {
	         connect();

	         String sql = "update tamagotchi_info set energy = energy + ?, full = full - ? where nick = ?";

	         pst = conn.prepareStatement(sql);

	         pst.setInt(1, energy);
	         pst.setInt(2, full);
	         pst.setString(3, nick);

	         int cnt = pst.executeUpdate();

	         if (cnt > 0) { // 추가 성공
	            check = true;
	         } else { // 추가 실패
	            check = false;
	         }

	      } catch (Exception e) { // ClassNotFoundException 만 처리가능

	         e.printStackTrace();// 개발중에 마니 사용
	         System.out.println("지금은 준비중입니다.");

	      } finally {

	         close();
	      }
	      return check;
	   }

	   public boolean run(int energy, int full, int ex, String nick) {

	      boolean check = false;

	      try {
	         connect();

	         String sql = "update tamagotchi_info set energy = energy - ?, full = full - ? ,ex = ex + ? where nick = ?";

	         pst = conn.prepareStatement(sql);

	         pst.setInt(1, energy);
	         pst.setInt(2, full);
	         pst.setInt(3, ex);
	         pst.setString(4, nick);

	         int cnt = pst.executeUpdate();

	         if (cnt > 0) { // 추가 성공
	            check = true;
	         } else { // 추가 실패
	            check = false;
	         }

	      } catch (Exception e) { // ClassNotFoundException 만 처리가능

	         e.printStackTrace();// 개발중에 마니 사용
	         System.out.println("지금은 준비중입니다.");

	      } finally {

	         close();
	      }
	      return check;

	   }

	   public boolean game(int energy, int full, int ex, String nick) {

	      boolean check = false;

	      try {
	         connect();

	         String sql = "update tamagotchi_info set energy = energy - ?, full = full - ?, ex = ex + ? where nick = ?";

	         pst = conn.prepareStatement(sql);

	         pst.setInt(1, energy);
	         pst.setInt(2, full);
	         pst.setInt(3, ex);
	         pst.setString(4, nick);

	         int cnt = pst.executeUpdate();

	         if (cnt > 0) { // 추가 성공
	            check = true;
	         } else { // 추가 실패
	            check = false;
	         }

	         // 여기에다가 리턴 적으면 안됨

	         // catch : try내에서 예외상황이 발생한 경우 catch문으로 들어오게됨
	      } catch (Exception e) {
	         e.printStackTrace();// 개발중에 마니 사용
	         System.out.println("지금은 준비중입니다.");

	      } finally {

	         close();
	      }
	      return check;
	   }

	   public boolean eat(int energy, int full, String nick) {

	      boolean check = false;

	      try {
	         connect();

	         String sql = "update tamagotchi_info set energy = energy + ?, full = full + ? where nick = ?";

	         pst = conn.prepareStatement(sql);

	         pst.setInt(1, energy);
	         pst.setInt(2, full);
	         pst.setString(3, nick);

	         int cnt = pst.executeUpdate();

	         if (cnt > 0) { // 추가 성공
	            check = true;
	         } else { // 추가 실패
	            check = false;
	         }

	      } catch (Exception e) { // ClassNotFoundException 만 처리가능

	         e.printStackTrace();// 개발중에 마니 사용
	         System.out.println("지금은 준비중입니다.");

	      } finally {

	         close();
	      }
	      return check;
	   }
	}