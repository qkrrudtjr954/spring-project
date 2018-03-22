package kh.com.a.model;

import java.io.Serializable;
import java.util.Date;

/*
create table poll(
    pollid number not null,
    id varchar2(50) not null,
    question varchar2(1000) not null,
    sdate date not null,
    edate date not null,
    itemcount number not null,
    polltotal number not null,
    regdate date not null,
    constraint poll_pk primary key(pollid)
);

create sequence poll_seq start with 1 increment by 1;

alter table poll add constraint poll_fk
foreign key(id) references member(id);

commit;
*/


// 투표 항목 (질문)
public class PollDto implements Serializable {
	private int pollid;	// 투표 번호 : 1, 2, 3, ...
	private String id;	// 투표 아이디
	private String question;	//	질문 
	private Date sdate;
	private Date edate;
	private int itemcount;	//	보기의 수
	private int polltotal;
	private Date regdate;
	private boolean vote;
	
	public PollDto() {
		// TODO Auto-generated constructor stub
	}

	public PollDto(String id, String question, int itemcount) {
		super();
		this.id = id;
		this.question = question;
		this.itemcount = itemcount;
	}

	public PollDto(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		super();
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}

	public PollDto(int pollid, String id, String question, Date sdate, Date edate, int itemcount, int polltotal,
			Date regdate, boolean vote) {
		super();
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.regdate = regdate;
		this.vote = vote;
	}

	
	
	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public int getPolltotal() {
		return polltotal;
	}

	public void setPolltotal(int polltotal) {
		this.polltotal = polltotal;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "PollDto [pollid=" + pollid + ", id=" + id + ", question=" + question + ", sdate=" + sdate + ", edate="
				+ edate + ", itemcount=" + itemcount + ", polltotal=" + polltotal + ", regdate=" + regdate + ", vote="
				+ vote + "]";
	}
	
	
	
	
	
}
