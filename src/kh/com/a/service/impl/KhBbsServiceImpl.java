package kh.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.a.dao.KhBbsDao;
import kh.com.a.model.BbsDto;
import kh.com.a.model.BbsParam;
import kh.com.a.service.KhBbsService;

@Service
public class KhBbsServiceImpl implements KhBbsService {

	@Autowired
	KhBbsDao khBbsDao;

	@Override
	@Transactional(readOnly=true)
	public List<BbsDto> getBbsList() throws Exception {		
		return khBbsDao.getBbsList();
	}
	
	@Override
	public boolean writeBbs(BbsDto bbs) throws Exception {		
		return khBbsDao.writeBbs(bbs);		
	}

	@Override
	public int reply(BbsDto bbs) throws Exception {
		khBbsDao.replyBbsUpdate(bbs);
		return khBbsDao.replyBbsInsert(bbs);	
	}

	@Override
	@Transactional(readOnly=true)
	public BbsDto getBbs(int seq) throws Exception {		
		return khBbsDao.getBbs(seq);		
	}

	@Override
	public void deleteBbs(int seq) throws Exception {
		khBbsDao.deleteBbs(seq);		
	}

	@Override
	public List<BbsDto> getBbsPagingList(BbsParam param) throws Exception {
		return khBbsDao.getBbsPagingList(param);
	}

	@Override
	public int getBbsCount(BbsParam param) throws Exception {
		return khBbsDao.getBbsCount(param);
	}

	@Override
	public int updateBbs(BbsDto bbs) throws Exception {
		return khBbsDao.updateBbs(bbs);
	}
	
	
}








