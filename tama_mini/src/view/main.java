package view;

import java.util.Scanner;
import model.tamagotchiDAO;
import model.userDAO;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		userDAO uDao = new userDAO();

		tamagotchiDAO tDao = new tamagotchiDAO();

		System.out.println("=====TAMAGOTCHI GAME START=====");

		String id = null;

		while (true) {
			System.out.println("1.sign up 2.sign in 3.exit");
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
					System.out.println("succes");
					System.out.println("===========================");
					break;

				} else {
					System.out.println("fail");
					System.out.println("===========================");
				}
			} else if (select == 3) {
				System.out.println("See you again!");
				break;
			} else {
				System.out.println("error : invalid value");
				System.out.println("-----------------------------");
			}

		}
		int dif = 0;
		String nickname;
		int nan2do;
		int nickStart = 0;
		System.out.println("[1] Strat with new nickname  [2] Start with a saved nickname");
		
		if(nickStart == 1) {
			System.out.println("<<Please, give me a nickname>>");
			nickname = sc.next();
			System.out.println("==================================");
			boolean check = tDao.insertTama(nickname, id, dif);
		}else if(nickStart ==2) {
			System.out.println("<<Please write your saved nickname>>");
			
			
			
		}
		
		

		
		
		
		
		
		
		

		int choose = 0;
			System.out.println("<<Please select a difficulty level>>");
			while(true) {
			System.out.println("[1] hard [2] normal [3] easy");
			nan2do = sc.nextInt();

			if (nan2do == 1) { // 난이도 상
				System.out.println("Hard difficulty is selected");
				break;
			} else if (nan2do == 2) { // 난이도 중
				System.out.println("Normal difficulty is selected");
				break;
			} else if (nan2do == 3) { // 난이도 하
				System.out.println("Easy difficulty is selected");
				break;
			} else {
				System.out.println("Sorry you made the wrong choice, please select again");
				System.out.println("======================================================");
			}
			}
	
			
		
			while(true) {
			System.out.println("Please choose what to do");
			System.out.println("[1] Eat  [2] Play  [3] Exercise");
			choose = sc.nextInt();

			if (choose == 1) {
				System.out.println("Eating"); //먹이주기
				break;
			} else if (choose == 2) { 
				System.out.println("Playing"); // 놀아주기
				break;
			} else if (choose == 3) {
				System.out.println("Exerciseing"); // 운동하기
				break;
			} else {
				System.out.println("Sorry you made the wrong choice, please select again");
				System.out.println("======================================================");
			}
			}
		
	
}
	}
