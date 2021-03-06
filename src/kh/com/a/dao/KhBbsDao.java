package kh.com.a.dao;

import java.util.List;

import kh.com.a.model.BbsDto;
import kh.com.a.model.BbsParam;

public interface KhBbsDao {
	
	List<BbsDto> getBbsList() throws Exception;

	boolean writeBbs(BbsDto bbs) throws Exception;
	
	public BbsDto getBbs(int seq) throws Exception;
	boolean readCount(int seq) throws Exception;
	
	List<BbsDto> getBbsPagingList(BbsParam param) throws Exception;
	int getBbsCount(BbsParam param) throws Exception;
	
	boolean replyBbsInsert(BbsDto bbs) throws Exception;
	boolean replyBbsUpdate(BbsDto bbs) throws Exception;
	
	public void updateBbs(BbsDto bbs)throws Exception;
}






