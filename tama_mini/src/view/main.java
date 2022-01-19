package view;

import java.util.Scanner;

import controller.check;
import controller.rank;
import model.tamagotchiDAO;
import model.userDAO;

public class main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      userDAO uDao = new userDAO();

      tamagotchiDAO tDao = new tamagotchiDAO();
      
      check ch = new check();
      rank rk = new rank();

      System.out.println("=====TAMAGOTCHI GAME START=====");

      String id = null;

      while (true) {
         System.out.println("1.sign up 2.sign in 3.ranking 4.exit");
         System.out.print("select >> ");
         int select = sc.nextInt();
         if (select == 1) {
            System.out.println("insert user_info");
            System.out.print("id : ");
            id = sc.next();
            System.out.print("passWord : ");
            int passWord = sc.nextInt();

            boolean check = uDao.insertUser(id, passWord);
            if (check == true) {
               System.out.println("sign up success");
            } else {
               System.out.println("sign up fail");
            }
         } else if (select == 2) {
            System.out.println("insert user_info");
            System.out.print("id : ");
            id = sc.next();
            System.out.print("passWord : ");
            int passWord = sc.nextInt();

            boolean check = uDao.selectOneUser(id, passWord);

            if (check == true) {
               System.out.println("success");
               System.out.println("===========================");
               
               String nickname;
               int dif;
               
               if(!ch.checkAlived(id)) {
                System.out.print("create your character.");
               System.out.print("<<give me a nickname>> : ");
               nickname = sc.next();
               
               
               
               System.out.println("<<Please select a difficulty level>>");
               System.out.println("[1] high [2] middle [3] low");
               dif = sc.nextInt();
               
               if (dif == 1) { // 난이도 상
                  System.out.println("level : high");
                  
               } else if (dif == 2) { // 난이도 중
                  System.out.println("level : middle");
                  
               } else if (dif == 3) { // 난이도 하
                  System.out.println("level : high");
               } else {
                  System.out.println("Sorry you made the wrong choice, please select again");
               }
               
               boolean ck = tDao.insertTama(nickname, id, dif);
               if(ck) {
                  System.out.println("insert complete");
               }else {
                  System.out.println("error : invalid value");   
                  break;
               }
               }else {
                  System.out.println("check the tamagochi");
               }
               
               while(true) {
               System.out.println("Please choose what to do");
               System.out.println("[1] Eat  [2] Play  [3] Exercise [4] logout");
               int choose = sc.nextInt();
               
               if (choose == 1) {
                  System.out.println("Eating");
               } else if (choose == 2) {
                  System.out.println("Playing");
               } else if (choose == 3) {
                  System.out.println("Exerciseing");
               }  else if (choose == 4) {
                  System.out.println("Logout complete");
                  break;
               } else {
                  System.out.println("Sorry you made the wrong choice, please select again");
               }
               }

            } else {
               System.out.println("fail");
               System.out.println("===========================");
            }
         }else if (select == 3){
            System.out.print("1.ranking 2.lived list 3.death check");
            int r = sc.nextInt();
            if(r == 1) {
               rk.rank();
            }else if(r == 2) {
               rk.rankLived();               
            }else if(r == 3) {
               System.out.print("tamagotchi nickname : ");
               String nk = sc.next();
               if(ch.checkDeath2(nk)) {
                  System.out.println(nk+" : dead");
               }else if(ch.checkAlived2(nk)) {
                  System.out.println(nk+" : alive");                  
               }else {
                  System.out.println("error : invalid value");                                    
               }
               
            }if(r == 4) {               
               System.out.print("tamgotchi nickname : ");
               String dt = sc.next();
               boolean d = tDao.updateEndDate(dt);
               if(d) {
                  System.out.println(dt + ": dead");
               }else {
                  System.out.println("error : invalid value");
               }
            }
            
         } else if (select == 4) {
            System.out.println("See you again!");
            break;
         } else {
            System.out.println("error : invalid value");
            System.out.println("-----------------------------");
         }

      }

   
}
   }