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
	@Transactional(readOnly=true)
	public BbsDto getBbs(int seq) throws Exception {		
		return khBbsDao.getBbs(seq);		
	}

	@Override
	public boolean readCount(int seq) throws Exception {
		// TODO Auto-generated method stub
		return khBbsDao.readCount(seq);		
	}

	@Override
	public List<BbsDto> getBbsPagingList(BbsParam param) throws Exception {
		// TODO Auto-generated method stub
		return khBbsDao.getBbsPagingList(param);		
	}

	@Override
	public int getBbsCount(BbsParam param) throws Exception {
		return khBbsDao.getBbsCount(param);		
	}

	@Override
	public void reply(BbsDto bbs) throws Exception {
		khBbsDao.replyBbsUpdate(bbs);
		khBbsDao.replyBbsInsert(bbs);
	}

	@Override
	public void updateBbs(BbsDto bbs) throws Exception {
		khBbsDao.updateBbs(bbs);		
	}

	

	
	
	
}








