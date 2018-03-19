package kh.com.a.service;

import java.util.List;

import kh.com.a.model.BbsDto;

public interface KhBbsService {
	
	public List<BbsDto> getBbsList() throws Exception;
	
	boolean writeBbs(BbsDto bbs) throws Exception;
	
	void reply(BbsDto bbs) throws Exception;
	
	BbsDto getBbs(int seq) throws Exception;
	void deleteBbs(int seq) throws Exception;

}
