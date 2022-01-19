package controller;

import java.util.ArrayList;

import model.tamagotchiDAO;
import model.tamagotchiVO;

public class check {
   
   public boolean checkLived(String user_id) {
      tamagotchiDAO a = new tamagotchiDAO();
      ArrayList<tamagotchiVO> al = null;
      al = a.livedTamaList();
      boolean lived = false;
      for(int i=0; i<al.size(); i++) {
         if(al.get(i).getUserId().equals(user_id)) {
            lived = true;
         }   
      }
      return lived;
   }
   
   
   public boolean checkDeath(String user_id) {
      tamagotchiDAO a = new tamagotchiDAO();
      ArrayList<tamagotchiVO> al = null;
      al = a.rankList();
      boolean death = false;
      for(int i=0; i<al.size(); i++) {
         if(al.get(i).getUserId().equals(user_id)) {
            death = true;
         }   
      }
      return death;
   }
   
   public boolean checkLived2(String nick) {
      tamagotchiDAO a = new tamagotchiDAO();
      ArrayList<tamagotchiVO> al = null;
      al = a.livedTamaList();
      boolean lived = false;
      for(int i=0; i<al.size(); i++) {
         if(al.get(i).getNick().equals(nick)) {
            lived = true;
         }   
      }
      return lived;
   }
   
   
   public boolean checkDeath2(String nick) {
      tamagotchiDAO a = new tamagotchiDAO();
      ArrayList<tamagotchiVO> al = null;
      al = a.rankList();
      boolean death = false;
      for(int i=0; i<al.size(); i++) {
         if(al.get(i).getNick().equals(nick)) {
            death = true;
         }   
      }
      return death;
   }
   
   
}