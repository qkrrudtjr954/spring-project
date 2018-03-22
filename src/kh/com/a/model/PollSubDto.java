package kh.com.a.model;

import java.io.Serializable;

public class PollSubDto implements Serializable {
	private int pollsubid;
	private int pollid;	//	투표 번호
	private String answer;
	private int account;
	
	public PollSubDto() {
		// TODO Auto-generated constructor stub
	}
		
	
	public PollSubDto(int pollsubid, int pollid, String answer, int account) {
		super();
		this.pollsubid = pollsubid;
		this.pollid = pollid;
		this.answer = answer;
		this.account = account;
	}


	public int getPollsubid() {
		return pollsubid;
	}


	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}


	public int getPollid() {
		return pollid;
	}


	public void setPollid(int pollid) {
		this.pollid = pollid;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getAccount() {
		return account;
	}


	public void setAccount(int account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "PollSubDto [pollsubid=" + pollsubid + ", pollid=" + pollid + ", answer=" + answer + ", account="
				+ account + "]";
	}
	
	
	
	
}
