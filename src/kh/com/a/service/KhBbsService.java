package kh.com.a.service;

import java.util.List;

import kh.com.a.model.BbsDto;
import kh.com.a.model.BbsParam;

public interface KhBbsService {
	
	public List<BbsDto> getBbsList() throws Exception;
	List<BbsDto> getBbsPagingList(BbsParam param) throws Exception;
	
	boolean writeBbs(BbsDto bbs) throws Exception;
	
	int reply(BbsDto bbs) throws Exception;
	
	BbsDto getBbs(int seq) throws Exception;
	void deleteBbs(int seq) throws Exception;
	
	int getBbsCount(BbsParam param) throws Exception;
	public int updateBbs(BbsDto bbs) throws Exception;

}
