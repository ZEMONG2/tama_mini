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
          
         
         String sql = "insert into tamagotchi_info values (?, 0, 1, 50, ?, sysdate, null, ?)";
         
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
            vo = new tamagotchiVO(name, ex, lev, energy, user_id, start_date, dif);
         }

      } catch (Exception e) {
         e.printStackTrace();

      } finally {
         close();
      }

      return vo;
   }
   
   public ArrayList<tamagotchiVO> livedTamaList(){
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
            al.add(new tamagotchiVO(name, lev, user_id, start_date, dif));
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
   
   

}