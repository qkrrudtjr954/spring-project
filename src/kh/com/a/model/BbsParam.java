package kh.com.a.model;

import java.io.Serializable;

public class BbsParam implements Serializable {

	private int seq;
	private String id;
		
	private int ref;	// 그룹번호
	private int step;	// 열번호
	private int depth;	// 깊이	
	
	private String title;
	private String content;
	private String wdate;
	private int parent;	// 부모글
	
	private int del;
	private int readcount;
	
	// search
	private String s_category;
	private String s_keyword;
	
	// paging
	private int recordCountPerPage=10;
	private int pageNumber=0;
	
	private int start=1;
	private int end=10;
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getS_category() {
		return s_category;
	}
	public void setS_category(String s_category) {
		this.s_category = s_category;
	}
	public String getS_keyword() {
		return s_keyword;
	}
	public void setS_keyword(String s_keyword) {
		this.s_keyword = s_keyword;
	}
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "BbsParam [seq=" + seq + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth
				+ ", title=" + title + ", content=" + content + ", wdate=" + wdate + ", parent=" + parent + ", del="
				+ del + ", readcount=" + readcount + ", s_category=" + s_category + ", s_keyword=" + s_keyword
				+ ", recordCountPerPage=" + recordCountPerPage + ", pageNumber=" + pageNumber + ", start=" + start
				+ ", end=" + end + "]";
	}
	
	
	
}






