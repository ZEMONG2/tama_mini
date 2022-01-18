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
		
		while(true) {
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
	            
	            if(check == true) {
	               System.out.println("succes");
	               System.out.println("===========================");
	               break;
	               
	            }else {
	               System.out.println("fail");
	               System.out.println("===========================");
	            }
			}else if(select == 3) {
				System.out.println("See you again!");
				break;
			}else {
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
			System.out.println("[1] 상 [2] 중 [3] 하");
			nan2do = sc.nextInt();
			
			if(nan2do == 1) { //난이도 상
				System.out.println("");
				
			}else if(nan2do ==2) { //난이도 중
				System.out.println("");
				
			}else if(nan2do == 3) { //난이도 하
				System.out.println("");
			}
			
			
			
			
			
			
			
		}
		
		
		
	}
