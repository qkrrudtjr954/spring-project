package kh.com.a.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhBbsDao;
import kh.com.a.model.BbsDto;

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
	public boolean replyBbsUpdate(BbsDto bbs) throws Exception {		
		sqlSession.update(ns+"replyBbsUpdate", bbs);
		return true; 
	}

	@Override
	public boolean replyBbsInsert(BbsDto bbs) throws Exception {
		sqlSession.insert(ns+"replyBbsInsert", bbs);
		return true;
	}

	@Override
	public BbsDto getBbs(int seq) throws Exception {		
		return sqlSession.selectOne(ns+"getBbs", seq);
	}

	@Override
	public void deleteBbs(int seq) throws Exception {
		sqlSession.update(ns+"deleteBbs", seq);
	}

	
}
