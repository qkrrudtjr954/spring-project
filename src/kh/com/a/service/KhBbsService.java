package kh.com.a.service;

import java.util.List;

import kh.com.a.model.BbsDto;
import kh.com.a.model.BbsParam;

public interface KhBbsService {
	
	public List<BbsDto> getBbsList() throws Exception;
	
	boolean writeBbs(BbsDto bbs) throws Exception;
		
	BbsDto getBbs(int seq) throws Exception;
	public boolean readCount(int seq) throws Exception;
	
	List<BbsDto> getBbsPagingList(BbsParam param) throws Exception;
	int getBbsCount(BbsParam param) throws Exception;
	
	void reply(BbsDto bbs) throws Exception;
	
	public void updateBbs(BbsDto bbs) throws Exception;
}
