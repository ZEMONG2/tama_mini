package model;

public class userVO {
	private int num;
	private String id;
	private String passWord;

	public userVO(int num, String id, String passWord) {
		super();
		this.num = num;
		this.id = id;
		this.passWord = passWord;

	}
	
	

	public String getId() {
		return id;
	}

	public String getPassWord() {
		return passWord;
	}

}