package view;

import java.util.Scanner;

import controller.check;
import controller.getNick;
import controller.rank;
import model.tamagotchiDAO;
import model.tamagotchiVO;
import model.userDAO;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		userDAO uDao = new userDAO();

		tamagotchiDAO tDao = new tamagotchiDAO();

		check ch = new check();
		rank rk = new rank();
		getNick gn = new getNick();

		System.out.println("=====TAMAGOTCHI GAME START=====");

		String id = null;

		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("1.sign up 2.sign in 3.ranking 4.exit");
			System.out.print("select >> ");
			int select = sc.nextInt();
			System.out.println("---------------------------------------");
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

					if (!ch.checkAlived(id)) {
						System.out.println("create your character.");
						System.out.print("<<give me a nickname>> : ");
						nickname = sc.next();

						System.out.println("<<Please select a difficulty level>>");
						System.out.print("[1] high [2] middle [3] low ---- ");
						dif = sc.nextInt();

						if (dif == 1) { // 난이도 상
							System.out.println("level : hard");

						} else if (dif == 2) { // 난이도 중
							System.out.println("level : middle");

						} else if (dif == 3) { // 난이도 하
							System.out.println("level : low");
						} else {
							System.out.println("Sorry you made the wrong choice, please select again");
						}

						System.out.println("===========================");
						boolean ck = tDao.insertTama(nickname, id, dif);
						if (ck) {
							System.out.println("insert complete");
						} else {
							System.out.println("error : invalid value");
							break;
						}
					} else {
						System.out.println("check the tamagochi");
					}
					System.out.println("===========================");

					while (true) {
						System.out.println("Please choose what to do");
						System.out.print("[1] Eat  [2] Play  [3] Exercise [4] sleep [5] logout ---- ");
						int choose = sc.nextInt();
						boolean sck = false;

						if (choose == 1) {
							System.out.println("Eating");
							if (gn.getNickDif(gn.getUserNick(id)) == 1) {
								sck = tDao.eat(10, 30, gn.getUserNick(id));
							} else if (gn.getNickDif(gn.getUserNick(id)) == 2) {
								sck = tDao.eat(20, 40, gn.getUserNick(id));
							} else if (gn.getNickDif(gn.getUserNick(id)) == 3) {
								sck = tDao.eat(30, 50, gn.getUserNick(id));
							}

						} else if (choose == 2) {
							System.out.println("Playing");
							if (gn.getNickDif(gn.getUserNick(id)) == 1) {
								sck = tDao.game(30, 30, 10, gn.getUserNick(id));
							} else if (gn.getNickDif(gn.getUserNick(id)) == 2) {
								sck = tDao.game(20, 20, 20, gn.getUserNick(id));
							} else if (gn.getNickDif(gn.getUserNick(id)) == 3) {
								sck = tDao.game(10, 30, 30, gn.getUserNick(id));
							}
						}
							else if (choose == 3) {
								System.out.println("Exerciseing");
								if (gn.getNickDif(gn.getUserNick(id)) == 1) {
									sck = tDao.run(30, 30, 10, gn.getUserNick(id));
								} else if (gn.getNickDif(gn.getUserNick(id)) == 2) {
									sck = tDao.run(20, 20, 20, gn.getUserNick(id));
								} else if (gn.getNickDif(gn.getUserNick(id)) == 3) {
									sck = tDao.run(10, 30, 30, gn.getUserNick(id));
								}
							}
								else if (choose == 4) {
									System.out.println("Sleeping");
									if (gn.getNickDif(gn.getUserNick(id)) == 1) {
										sck = tDao.sleep(30, 30, gn.getUserNick(id));
									} else if (gn.getNickDif(gn.getUserNick(id)) == 2) {
										sck = tDao.sleep(40, 20, gn.getUserNick(id));
									} else if (gn.getNickDif(gn.getUserNick(id)) == 3) {
										sck = tDao.sleep(50, 10, gn.getUserNick(id));
									}

								}

							
							else if (choose == 5) {
								System.out.println("Logout complete");
								break;
							}

							else {
								System.out.println("Sorry you made the wrong choice, please select again");
							}
						System.out.println("현재 에너지 : " + gn.getNickEnergy(gn.getUserNick(id)));
						System.out.println("현재 포만감 : " + gn.getNickFull(gn.getUserNick(id)));
						System.out.println("현재 경험치 : " + gn.getNickEx(gn.getUserNick(id)));
						System.out.println("현재 레벨 : " + gn.getNickLevel(gn.getUserNick(id)));
						System.out.println("-------------------------------");
						System.out.println("complete");

						if (sck) {
							if (gn.getNickEx(gn.getUserNick(id)) >= 100) {
								tDao.levelUp(id);
							}
							if (((gn.getNickFull(gn.getUserNick(id))) <= 0)
									|| ((gn.getNickEnergy(gn.getUserNick(id))) <= 0)) {
								boolean death = tDao.updateEndDate(gn.getUserNick(id));
								if (death) {
									System.out.println("dead");
									break;
								}
								break;
							}
						}

						
					}

				} else {
					System.out.println("fail");
					System.out.println("===========================");
				}
			} else if (select == 3) {
				System.out.println("-----------------------------------------");
				System.out.print("1.ranking 2.alived list 3.death check >> ");
				int r = sc.nextInt();
				System.out.println("-----------------------------------------");
				if (r == 1) {

					rk.rank();
				} else if (r == 2) {
					rk.rankAlived();
				} else if (r == 3) {
					System.out.print("tamagotchi nickname : ");
					String nk = sc.next();
					if (ch.checkDeath2(nk)) {
						System.out.println(nk + " : dead");
					} else if (ch.checkAlived2(nk)) {
						System.out.println(nk + " : alive");
					} else {
						System.out.println("error : invalid value");
					}
					System.out.println("-----------------------------");

				}
				if (r == 4) {
					System.out.print("tamgotchi nickname : ");
					String dt = sc.next();
					boolean d = tDao.updateEndDate(dt);
					if (d) {
						System.out.println(dt + ": dead");
					} else {
						System.out.println("error : invalid value");
					}
					System.out.println("-----------------------------");
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