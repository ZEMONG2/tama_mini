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
		
		while(true) {
			System.out.println("1.sign up 2.sign in 3.exit");
			System.out.print("select >> ");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.println("insert user_info");
				System.out.print("id : ");
				String id = sc.next();
				System.out.print("passWord : ");
				String passWord = sc.next();
				
				boolean check = uDao.insertUser(id, passWord);
				if (check == true) {
					System.out.println("sign up success");
				} else {
					System.out.println("sign up fail");
				}
			}else if(select == 2) {
				System.out.println("insert user_info");
				System.out.print("id : ");
				String id = sc.next();
				System.out.print("passWord : ");
				String passWord = sc.next();
				
				
				




				break;

			}else if(select == 3) {
				System.out.println("See you again!");
				break;
			}else {
				System.out.println("error : invalid value");
				System.out.println("-----------------------------");				
			}
			
		
		
		
	}
	}
}