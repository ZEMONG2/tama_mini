package model;

public class tamagotchiVO {
   
   private String nick;
   private int ex;
   private int lev;
   private int energy; 
   private String userId;
   private String start_date;
   private String end_date;
   private int dif;
   private int full;
   
   
   
   public tamagotchiVO(String nick, int ex, int lev, int energy, String user_id, String start_date, int dif, int full) {
      super();
      this.nick = nick;
      this.ex = ex;
      this.lev = lev;
      this.energy = energy;
      this.userId = user_id;
      this.start_date = start_date;
      this.dif = dif;
      this.full = full;
   }
   




   public tamagotchiVO(String nick, int lev, String user_id, String start_date, int dif) {
      super();
      this.nick = nick;
      this.lev = lev;
      this.userId = user_id;
      this.start_date = start_date;
      this.dif = dif;
   }



   public tamagotchiVO(String nick, int lev, String user_id, String start_date, String end_date, int dif) {
      super();
      this.nick = nick;
      this.lev = lev;
      this.userId = user_id;
      this.start_date = start_date;
      this.end_date = end_date;
      this.dif = dif;
   }



   public int getDif() {
      return dif;
   }


   public String getNick() {
      return nick;
   }

   public int getEx() {
      return ex;
   }

   public int getLev() {
      return lev;
   }

   public int getEnergy() {
      return energy;
   }

   public String getUserId() {
      return userId;
   }


   public String getStart_date() {
      return start_date;
   }


   public String getEnd_date() {
      return end_date;
   }

   public int getFull() {
      return full;
   }

}