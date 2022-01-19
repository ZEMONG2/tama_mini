package controller;

import java.util.ArrayList;

import model.tamagotchiDAO;
import model.tamagotchiVO;

public class getNick {
	public String getUserNick(String user_id) {
		   tamagotchiDAO a = new tamagotchiDAO();
		   ArrayList<tamagotchiVO> al = null;
		   String nick = "";
		   al = a.alivedTamaList();
		   for(int i=0; i<al.size(); i++) {
			   if(al.get(i).getUserId().equals(user_id)) {
				   nick = al.get(i).getNick();
			   }   
		   }
		   return nick;
	   }
	   
	   public int getNickDif(String nick) {
		   tamagotchiDAO a = new tamagotchiDAO();
		   ArrayList<tamagotchiVO> al = null;
		   int dif = 0;
		   al = a.alivedTamaList();
		   for(int i=0; i<al.size(); i++) {
			   if(al.get(i).getNick().equals(nick)) {
				   dif = al.get(i).getDif();
			   }   
		   }
		   return dif;
	   }
	   
	   public int getNickFull(String nick) {
		   tamagotchiDAO a = new tamagotchiDAO();
		   ArrayList<tamagotchiVO> al = null;
		   int full = 0;
		   al = a.alivedTamaList();
		   for(int i=0; i<al.size(); i++) {
			   if(al.get(i).getNick().equals(nick)) {
				   full = al.get(i).getFull();
			   }   
		   }
		   return full;
	   }
	   
	   public int getNickEnergy(String nick) {
		   tamagotchiDAO a = new tamagotchiDAO();
		   ArrayList<tamagotchiVO> al = null;
		   int energy = 0;
		   al = a.alivedTamaList();
		   for(int i=0; i<al.size(); i++) {
			   if(al.get(i).getNick().equals(nick)) {
				   energy = al.get(i).getEnergy();
			   }   
		   }
		   return energy;
	   }
	   }
