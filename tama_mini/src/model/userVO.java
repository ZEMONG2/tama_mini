package model;

public class userVO {
	private int num;
	private String id;
	private int passWord;

	public userVO(int num, String id, int passWord) {
		super();
		this.num = num;
		this.id = id;
		this.passWord = passWord;

	}

	public String getId() {
		return id;
	}

	public int getPassWord() {
		return passWord;
	}

}