package kh.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.a.dao.KhPdsDao;
import kh.com.a.model.PdsDto;

@Repository
public class KhPdsDaoImpl implements KhPdsDao {

	
	//	private SqlSession sqlSession;	// pre version
	@Autowired
	private SqlSessionTemplate sqlSession;	// new version
	
	String ns = "KHPds.";
	
	@Override
	public List<PdsDto> getPdsList() {
		return sqlSession.selectList(ns+"getPbsList");
	}

	@Override
	public void uploadPds(PdsDto dto) {
		sqlSession.insert(ns+"uploadPds", dto);
	}
	
}
