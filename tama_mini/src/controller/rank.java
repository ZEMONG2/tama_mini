package controller;

import java.util.ArrayList;

import model.tamagotchiDAO;
import model.tamagotchiVO;
public class rank {

      
      public void rank() {
         tamagotchiDAO a = new tamagotchiDAO();
         ArrayList<tamagotchiVO> al = a.rankList();
         if(al.size() != 0) {
         System.out.println("=================================================");
         System.out.println("』』』』』』』』』』』』』』』』』Ranking』』』』』』』』』』』』』』』』』");
         System.out.println("=================================================");
         System.out.printf("%s\t%s\t%s\t%s\t%s\t\t\t%s\t\t\t%s\n", "Rank", "Nick", "Level", "ID", "Start", "End", "Dif");         
         for(int i=0; i<al.size(); i++) {
            System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\n", (i+1), al.get(i).getNick(), al.get(i).getLev(), al.get(i).getUserId(), al.get(i).getStart_date(), al.get(i).getEnd_date(), al.get(i).getDif());
         }
         System.out.println("=================================================");
         }
         
      }
      
      public void rankLived() {
         tamagotchiDAO a = new tamagotchiDAO();
         ArrayList<tamagotchiVO> al = a.alivedTamaList();
         if (al.size() != 0) {
            System.out.println("=================================================");
            System.out.println("』』』』』』』』』』』』』』Ranking_(Lived)』』』』』』』』』』』』』』");
            System.out.println("=================================================");
            System.out.printf("%s\t%s\t%s\t%s\t%s\t\t\t%s\t\n", "Rank", "Nick", "Level", "ID", "Start", "Dif");
            for (int i = 0; i < al.size(); i++) {
               System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n", (i + 1), al.get(i).getNick(), al.get(i).getLev(),
                     al.get(i).getUserId(), al.get(i).getStart_date(), al.get(i).getDif());
            }
            System.out.println("=================================================");
         }

      }
      
   }