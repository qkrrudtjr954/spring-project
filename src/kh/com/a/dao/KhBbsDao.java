package kh.com.a.dao;

import java.util.List;

import kh.com.a.model.BbsDto;

public interface KhBbsDao {
	
	List<BbsDto> getBbsList() throws Exception;

	boolean writeBbs(BbsDto bbs) throws Exception;
	
	boolean replyBbsUpdate(BbsDto bbs) throws Exception;
	boolean replyBbsInsert(BbsDto bbs) throws Exception;
	
	public BbsDto getBbs(int seq) throws Exception;
	
	public void deleteBbs(int seq) throws Exception;
}
