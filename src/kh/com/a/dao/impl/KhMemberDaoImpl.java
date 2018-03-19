package kh.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhMemberDao;
import kh.com.a.model.MemberDto;

@Repository
public class KhMemberDaoImpl implements KhMemberDao {
	
	@Autowired		// 자동생성  == DI(Dependency Injection)
	SqlSession sqlSession;	// IOC(Inversion of Control)
	
	private String namespace = "KHMember."; 
	
	@Override
	public boolean addmember(MemberDto mem) throws Exception {		
		int n = sqlSession.insert(namespace + "addmember", mem);		
		return n>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto mem) throws Exception {
		return sqlSession.selectOne(namespace + "login", mem);
	}
	
	

}







