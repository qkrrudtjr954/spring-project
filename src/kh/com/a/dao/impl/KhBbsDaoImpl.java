package kh.com.a.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhBbsDao;
import kh.com.a.model.BbsDto;
import kh.com.a.model.BbsParam;

@Repository
public class KhBbsDaoImpl implements KhBbsDao {

	@Autowired
	SqlSession sqlSession;
	
	private String ns = "KHBbs.";
	
	@Override
	public List<BbsDto> getBbsList() throws Exception {		
		
		// sqlSession 설정 타입 (BATCH, SIMPLE)
		System.out.println("타입:" + sqlSession.getConfiguration().getDefaultExecutorType());
		
		List<BbsDto> list = new ArrayList<BbsDto>();		
		list = sqlSession.selectList(ns + "getBbsList");
						
		return list;
	}
	
	@Override
	public boolean writeBbs(BbsDto bbs) throws Exception {	
		sqlSession.insert(ns+"writeBbs",bbs);		
		return true;
	}	

	@Override
	public BbsDto getBbs(int seq) throws Exception {
		System.out.println("KhBbsDaoImpl getBbs");
		return sqlSession.selectOne(ns+"getBbs", seq);
	}

	@Override
	public boolean readCount(int seq) throws Exception {
		sqlSession.update(ns+"readCount",seq);
		return true;
	}

	@Override
	public List<BbsDto> getBbsPagingList(BbsParam param) throws Exception {
		List<BbsDto> list = new ArrayList<BbsDto>();
		list = sqlSession.selectList(ns+"getBbsPagingList", param);		
		return list;
	}

	@Override
	public int getBbsCount(BbsParam param) throws Exception {
		int num = 0;
		num = sqlSession.selectOne(ns+"getBbsCount", param);
		return num;
	}

	@Override
	public boolean replyBbsInsert(BbsDto bbs) throws Exception {
		sqlSession.insert(ns+"replyBbsInsert", bbs);
		return true;
	}

	@Override
	public boolean replyBbsUpdate(BbsDto bbs) throws Exception {
		sqlSession.update(ns+"replyBbsUpdate", bbs);
		return true;
	}

	@Override
	public void updateBbs(BbsDto bbs) throws Exception {
		sqlSession.update(ns+"updateBbs",bbs);
	}
	
	

	
	

	
}
