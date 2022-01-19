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

		String nickname;
		int nan2do;

		System.out.println("<<give me a nickname>>");
		nickname = sc.next();

		boolean check = tDao.insertTama(nickname, id);

		
			System.out.println("<<Please select a difficulty level>>");
			System.out.println("[1] high [2] middle [3] low");
			nan2do = sc.nextInt();

			if (nan2do == 1) { // 난이도 상
				System.out.println("");

			} else if (nan2do == 2) { // 난이도 중
				System.out.println("");

			} else if (nan2do == 3) { // 난이도 하
				System.out.println("");
			} else {
				System.out.println("Sorry you made the wrong choice, please select again");
			}

		
	
	
			int choose = 0;
		

			System.out.println("Please choose what to do");
			System.out.println("[1] Eat  [2] Play  [3] Exercise");
			choose = sc.nextInt();

			if (choose == 1) {
				System.out.println("Eating");
			} else if (choose == 2) {
				System.out.println("Playing");
			} else if (choose == 3) {
				System.out.println("Exerciseing");
			} else {
				System.out.println("Sorry you made the wrong choice, please select again");
			}

		
	
}}
