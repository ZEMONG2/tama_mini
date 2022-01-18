package model;

public class tamagotchiVO {
	
	private String nick;
	private int ex;
	private int lev;
	private int energy; 
	private String user_id;
	private String start_date;
	private String end_date;
	
	
	
	public tamagotchiVO(String nick, int ex, int lev, int energy, String user_id, String start_date) {
		super();
		this.nick = nick;
		this.ex = ex;
		this.lev = lev;
		this.energy = energy;
		this.user_id = user_id;
		this.start_date = start_date;
	}
	


	public tamagotchiVO(String nick, int lev, String user_id, String start_date) {
		super();
		this.nick = nick;
		this.lev = lev;
		this.user_id = user_id;
		this.start_date = start_date;
	}



	public tamagotchiVO(String nick, int lev, String user_id, String start_date, String end_date) {
		super();
		this.nick = nick;
		this.lev = lev;
		this.user_id = user_id;
		this.start_date = start_date;
		this.end_date = end_date;
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
		return user_id;
	}


	public String getStart_date() {
		return start_date;
	}


	public String getEnd_date() {
		return end_date;
	}


}